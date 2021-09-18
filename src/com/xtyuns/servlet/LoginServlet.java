package com.xtyuns.servlet;

import com.xtyuns.pojo.User;
import com.xtyuns.resp.Result;
import com.xtyuns.service.UserService;
import com.xtyuns.service.impl.UserServiceImpl;
import com.xtyuns.utils.ExceptionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 使用 POST 方式进行登录, GET 方式退出登录
 */
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Result result = null;
        try {
            User user = userService.login(username, password);
            if (null == user) {
                result = Result.error("用户名或密码错误!");
            } else {
                request.getSession().setAttribute("user", user);
                result = Result.success("欢迎登录: " + user.getUsername());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = Result.error(5000, ExceptionUtil.formatMsg(e));
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.error(ExceptionUtil.formatMsg(e));
        }

        response.getWriter().write(result.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        resp.getWriter().write(Result.success("成功退出登录").toString());
    }
}
