package com.example.taidev198.javaeehome.controller.admin.api;

import com.example.taidev198.javaeehome.constant.SystemConstant;
import com.example.taidev198.javaeehome.model.NewsModel;
import com.example.taidev198.javaeehome.model.UserModel;
import com.example.taidev198.javaeehome.service.INewsService;
import com.example.taidev198.javaeehome.service.NewsService;
import com.example.taidev198.javaeehome.utils.HttpUtils;
import com.example.taidev198.javaeehome.utils.SessionUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.example.taidev198.javaeehome.utils.HttpUtils.stringRequestToArray;

@WebServlet(urlPatterns = {"/api-admin-news"})
public class NewsAPI extends HttpServlet {

    //@Inject
    private INewsService newsService = new NewsService();

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("onGet");
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        NewsModel newsModel;
        Gson gson = new GsonBuilder().create();
        newsModel = gson.fromJson(request.getReader(), NewsModel.class);
        //get current user's data
        newsModel.setCreatedBy(((UserModel)SessionUtils.getInstance().getValue(request, "USERMODEL")).getUserName());
        newsModel.setModifiedBy(((UserModel)SessionUtils.getInstance().getValue(request, "USERMODEL")).getUserName());
        newsModel = newsService.save(newsModel);
        mapper.writeValue(response.getOutputStream(), newsModel);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("onPost");
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        NewsModel newsModel;
        Gson gson = new GsonBuilder().create();
        newsModel = HttpUtils.of(request.getReader()).toModel(NewsModel.class);
        UserModel userModel = (UserModel)SessionUtils.getInstance().getValue(request, "USERMODEL");
        newsModel.setModifiedBy(userModel.getUserName());
        newsModel.setCreatedBy(userModel.getUserName());
        newsModel = newsService.save(newsModel);
        mapper.writeValue(response.getOutputStream(), newsModel);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("onDelete");
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        //get string jsonObject contains id list and convert to long array
        newsService.delete(HttpUtils.stringRequestToArray(HttpUtils.of(request.getReader()).getValue()));
        mapper.writeValue(response.getOutputStream(), "{}");
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("onPut");
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        UserModel userModel = (UserModel)SessionUtils.getInstance().getValue(request, "USERMODEL");
        NewsModel updatedNewsModel = HttpUtils.of(request.getReader()).toModel(NewsModel.class);
        Gson gson = new GsonBuilder().create();
       // updatedNewsModel.setId(userModel.);
        updatedNewsModel = newsService.update(updatedNewsModel, userModel);
        //updatedNewsModel.setModifiedBy((userModel.getUserName()));//set who is modified
        mapper.writeValue(response.getOutputStream(), updatedNewsModel);
    }

}
