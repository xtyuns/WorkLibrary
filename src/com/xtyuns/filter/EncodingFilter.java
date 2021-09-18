package com.xtyuns.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Dictionary;

public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String uri = ((HttpServletRequest) request).getRequestURI();
        if (uri.endsWith(".jsp") || uri.endsWith(".html") || uri.equals("/")) {
            response.setContentType("text/html;charset=utf-8");
        } else if (!uri.contains(".")) {
            response.setContentType("text/json;charset=utf-8");
        }
        chain.doFilter(request, response);
    }
}
