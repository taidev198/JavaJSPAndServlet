package com.example.taidev198.javaeehome.controller.admin;

import com.example.taidev198.javaeehome.constant.SystemConstant;
import com.example.taidev198.javaeehome.model.NewsModel;
import com.example.taidev198.javaeehome.model.UserModel;
import com.example.taidev198.javaeehome.service.INewsService;
import com.example.taidev198.javaeehome.service.NewsService;
import com.example.taidev198.javaeehome.utils.FormUtils;
import jakarta.inject.Inject;
//import com.google.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns ={ "/admin-new-list"})
public class NewsController extends HttpServlet {
    private String message;

    //@Inject
    private INewsService newsService = new NewsService();

    public void init() {
        message = "nguyen thanh tai";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
//        NewsModel newsModel = FormUtils.toModel(NewsModel.class, request);
        String viewUrl = "";
        NewsModel newsModel = new NewsModel();
        newsModel.setType(request.getParameter("type"));
    //    if (newsModel.getType().equals(SystemConstant.GET_LIST_NEWS)) {
            String pageStr = request.getParameter("page");
            String maxPageStr = request.getParameter("maxPageItem");
            if (pageStr == null || pageStr.equals("")) {
                pageStr = "1";
            }
            newsModel.setPage(Integer.parseInt(pageStr));
            if (maxPageStr == null || maxPageStr.equals("")) {
                maxPageStr = "2";
            }
            newsModel.setMaxPageItem(Integer.parseInt(maxPageStr));
            int offset = (newsModel.getPage() - 1) * newsModel.getMaxPageItem();
            List<NewsModel> newsList = newsService.findAll(offset,newsModel.getMaxPageItem());
            newsModel.setListModels(newsList);
            newsModel.setTotalItems(newsService.getTotalItems());
            newsModel.setTotalPages((int) Math.ceil((double) newsModel.getTotalItems()/newsModel.getMaxPageItem()));
            viewUrl = "/views/admin/news/list.jsp";
//            RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
//            dispatcher.forward(request, response);
//        } else if (newsModel.getType().equals(SystemConstant.CHANGE_NEWS)) {
//            if (newsModel.getId()!=null) {//exists
//                newsModel = newsService.findOneById(newsModel.getId());
//
//            } else {//no exist
//
//            }
//
//            viewUrl = "/views/admin/news/edit.jsp";
//
//        }
        request.setAttribute(SystemConstant.MODEL, newsModel);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void destroy() {
    }
}
