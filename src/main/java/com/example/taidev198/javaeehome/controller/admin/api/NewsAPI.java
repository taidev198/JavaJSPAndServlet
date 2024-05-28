package com.example.taidev198.javaeehome.controller.admin.api;

import com.example.taidev198.javaeehome.model.NewsModel;
import com.example.taidev198.javaeehome.service.INewsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpUtils;

import java.io.IOException;

public class NewsAPI extends HttpServlet {

    @Inject
    private INewsService newsService;

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        NewsModel newsModel;
        Gson gson = new GsonBuilder().create();
        newsModel = gson.fromJson(request.getReader(), NewsModel.class);
        newsModel = newsService.save(newsModel);
        mapper.writeValue(response.getOutputStream(), newsModel);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        NewsModel newsModel;
        Gson gson = new GsonBuilder().create();
        newsModel = gson.fromJson(request.getReader(), NewsModel.class);
        newsModel = newsService.update(newsModel);
        mapper.writeValue(response.getOutputStream(), newsModel);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        NewsModel newsModel;
        Gson gson = new GsonBuilder().create();
        newsModel = gson.fromJson(request.getReader(), NewsModel.class);
      // newsModel = newsService.delete(newsModel.getListModels().toArray());
        mapper.writeValue(response.getOutputStream(), newsModel);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
