package com.example.taidev198.javaeehome.controller.admin;

import com.example.taidev198.javaeehome.model.UserModel;
import com.example.taidev198.javaeehome.service.INewsService;
import com.example.taidev198.javaeehome.service.NewsService;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns ={ "/admin-new-list"})
public class NewsController extends HttpServlet {
    private String message;

    @Inject
    private INewsService newsService;

    public void init() {
        message = "nguyen thanh tai";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        UserModel user = new UserModel();
        user.setUserName("tai");
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/news/list.jsp");
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
