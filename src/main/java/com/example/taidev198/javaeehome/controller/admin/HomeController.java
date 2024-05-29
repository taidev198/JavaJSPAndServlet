package com.example.taidev198.javaeehome.controller.admin;

import com.example.taidev198.javaeehome.model.UserModel;
import com.example.taidev198.javaeehome.service.IUserService;
import com.example.taidev198.javaeehome.service.UserService;
import com.example.taidev198.javaeehome.utils.FormUtils;
import com.example.taidev198.javaeehome.utils.HttpUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns ={ "/admin-home"})
public class HomeController extends HttpServlet {
    private String message;
    private IUserService userService = new UserService();

    public void init() {
        message = "nguyen thanh tai";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        RequestDispatcher dispatcher;
        if (action != null && action.equals("login")) {
             dispatcher = request.getRequestDispatcher("/views/login.jsp");
        } else if (action != null && action.equals("logout")) {
            dispatcher = request.getRequestDispatcher("/views/admin/dang-nhap.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/views/admin/index.jsp");
        }
        dispatcher.forward(request, response);
//        UserModel user = new UserModel();
//        user.setUserName("tai");
//        request.setAttribute("user", user);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            UserModel userModel = FormUtils.toModel(UserModel.class, request);
            userModel = userService.findByUsernameAndPasswordAndStatus(userModel.getUserName(), userModel.getPassword(), 1);
            if (userModel != null) {//authentication
                if (userModel.getRole().getCode().equals("USER")) {//authenzication

                }
            } else {
                response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login");
            }
        }

    }

    public void destroy() {
    }
}