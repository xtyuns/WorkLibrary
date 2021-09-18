package com.xtyuns.servlet;

import com.xtyuns.resp.Result;
import com.xtyuns.service.BookService;
import com.xtyuns.service.impl.BookServiceImpl;
import com.xtyuns.utils.ExceptionUtil;
import com.xtyuns.vo.Books;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");

        Result result = null;
        try {
            if ("getBooks".equals(type)) {
                String page = request.getParameter("page");
                String pageSize = request.getParameter("limit");
                Books books = null;
                if (null == page || null == pageSize) {
                    books = bookService.findAllBook();
                } else {
                    books = bookService.findBookInPage(page, pageSize);
                }
                result = Result.success(books);
            } else if ("cutBook".equals(type)) {
                String id = request.getParameter("id");
                Boolean cutRet = bookService.removeBookById(id);
                if (cutRet) {
                    result = Result.success("删除成功");
                } else {
                    result = Result.error("删除失败");
                }
            } else {
                result = Result.error(4003, "not_supported_action");
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");

        Result result = null;
        try {
            if ("cutBookList".equals(type)) {
                String[] ids = req.getParameterValues("ids[]");
                Boolean cutRet = bookService.removeBookByIds(ids);
                if (cutRet) {
                    result = Result.success("删除成功");
                } else {
                    result = Result.error("删除失败");
                }
            } else if ("editBook".equals(type)) {
                String id = req.getParameter("id");
                Map<String, String[]> parameterMap = req.getParameterMap();
                Map<String, String> params = new HashMap<>(parameterMap.size());
                parameterMap.forEach((k, vs) -> params.put(k, vs[0]));
                Boolean editRet = bookService.modifyBookById(id, params);
                if (editRet) {
                    result = Result.success("修改成功");
                } else {
                    result = Result.error("修改失败");
                }
            } else if ("addBook".equals(type)) {
                Map<String, String[]> parameterMap = req.getParameterMap();
                Map<String, String> params = new HashMap<>(parameterMap.size());
                parameterMap.forEach((k, vs) -> params.put(k, vs[0]));
                Boolean addRet = bookService.saveBook(params);
                if (addRet) {
                    result = Result.success("添加成功");
                } else {
                    result = Result.error("添加失败");
                }
            } else {
                result = Result.error(4003, "not_supported_action");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = Result.error(5000, ExceptionUtil.formatMsg(e));
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.error(ExceptionUtil.formatMsg(e));
        }

        resp.getWriter().write(result.toString());
    }

}
