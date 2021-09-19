package com.xtyuns.filter;

import com.xtyuns.resp.Result;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest hsr = (HttpServletRequest) request;
        String uri = hsr.getRequestURI();
        uri = uri.replace("../", "");
        // remove context path in URI
        String contextPath = hsr.getServletContext().getContextPath();
        uri = uri.substring(contextPath.length());

        // 前端页面分离, 因此只过滤 Servlet, 放行首页和登录页
        if ("/".equals(uri) || "/login".equals(uri) || uri.contains(".")) {
            chain.doFilter(request, response);
        } else {
            HttpSession session = hsr.getSession();
            Object user = session.getAttribute("user");
            if (null != user) {
                chain.doFilter(request, response);
            } else {
                Result result = Result.error(4001, "用户未登录!");
                response.getWriter().write(result.toString());
            }
        }

    }
}
