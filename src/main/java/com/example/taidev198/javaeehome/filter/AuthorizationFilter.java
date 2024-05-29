package com.example.taidev198.javaeehome.filter;

import com.example.taidev198.javaeehome.constant.SystemConstant;
import com.example.taidev198.javaeehome.model.UserModel;
import com.example.taidev198.javaeehome.utils.SessionUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AuthorizationFilter implements Filter {

    private ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        String authorization = request.getHeader("Authorization");
        if (uri != null && uri.contains("/admin")) {
            UserModel user = (UserModel) SessionUtils.getInstance().getValue(request,"USERMODEL");
            if (user != null) {
                if (user.getRole().getName().equals(SystemConstant.ADMIN)) {
                    filterChain.doFilter(request, response);//go to website
                } else if (user.getRole().getName().equals(SystemConstant.USER)) {
                    response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login");
                }
            }else {
                response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login");
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
