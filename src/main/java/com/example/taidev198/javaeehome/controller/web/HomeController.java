package com.example.taidev198.javaeehome.controller.web;

import java.io.*;

import com.example.taidev198.javaeehome.model.UserModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HomeController extends HttpServlet {
    private String message;


    public void init() {
        message = "nguyen thanh tai";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        UserModel user = new UserModel();
        user.setUserName("tai");
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("decorators/admin.jsp");
        dispatcher.forward(request, response);

//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
    }

    public void destroy() {
    }
}