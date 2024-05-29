package com.example.taidev198.javaeehome.controller.web;

import java.io.*;

import com.example.taidev198.javaeehome.model.UserModel;
import com.example.taidev198.javaeehome.service.IUserService;
import com.example.taidev198.javaeehome.service.UserService;
import com.example.taidev198.javaeehome.utils.FormUtils;
import com.example.taidev198.javaeehome.utils.SessionUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap", "/thoat"})
public class HomeController extends HttpServlet {
    private IUserService userService = new UserService();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        RequestDispatcher dispatcher = null;
        if (action != null && action.equals("login")) {
            dispatcher = request.getRequestDispatcher("/views/login.jsp");
            dispatcher.forward(request, response);
        } else if (action != null && action.equals("logout")) {
            SessionUtils.getInstance().removeValue(request, "USERMODEL");
            //after clicking logout we redirect to another url using response send direct
            response.sendRedirect(request.getContextPath() + "/trang-chu");
        } else {
            dispatcher = request.getRequestDispatcher("/views/admin/index.jsp");
            dispatcher.forward(request, response);
        }

//        UserModel user = new UserModel();
//        user.setUserName("tai");
//        request.setAttribute("user", user);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            UserModel userModel = new UserModel();
            userModel.setUserName(request.getParameter("username"));
            userModel.setPassword(request.getParameter("password"));
            userModel = userService.findByUsernameAndPasswordAndStatus(userModel.getUserName(), userModel.getPassword(), 1);
            SessionUtils sessionUtils = SessionUtils.getInstance();
            if (userModel != null) {//authentication


                if (userModel.getRole().getName().equals("USER")) {//authenzication
                    response.sendRedirect(request.getContextPath()+"/trang-chu");
                } else if (userModel.getRole().getName().equals("ADMIN")) {
                    response.sendRedirect(request.getContextPath()+"/admin-home");
                }
                sessionUtils.putValue(request, "USERMODEL", userModel);
            } else {
                response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login");
                sessionUtils.removeValue(request, "USERMODEL");
            }

        }

    }

    public void destroy() {
    }
}