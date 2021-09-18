package com.xtyuns.dao.impl;

import com.xtyuns.dao.BookDao;
import com.xtyuns.pojo.Book;
import com.xtyuns.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.*;

public class BookDaoImpl implements BookDao {
    QueryRunner qr = new QueryRunner(JDBCUtil.dataSource);

    @Override
    public Long countAllBook() throws SQLException {
        return qr.query("select count(*) from book", new ScalarHandler<Long>());
    }

    @Override
    public List<Book> selectAllBook() throws SQLException {
        String sql = "select * from book";
        List<Book> ret = qr.query(sql, new BeanListHandler<>(Book.class));
        return ret;
    }

    @Override
    public List<Book> selectBookInPage(int page, int pageSize) throws SQLException {
        String sql = "select * from book limit ?,?";
        List<Book> ret = qr.query(sql, new BeanListHandler<>(Book.class), (page - 1) * pageSize, pageSize);
        return ret;
    }

    @Override
    public Boolean deleteBookById(int id) throws SQLException {
        String sql = "delete from book where id = ?";
        int rows = qr.update(sql, id);
        return rows != 0;
    }

    @Override
    public Boolean deleteBookByIds(Integer[] ids) throws SQLException {
        String params = String.join("", Collections.nCopies(ids.length, ",?"));
        String sql = "delete from book where id in (" + params.substring(1) + ")";
        int rows = qr.update(sql, (Object[]) ids);
        return rows != 0;
    }

    @Override
    public Boolean updateBookById(Book book) throws SQLException {
        char split = ' ';
        StringBuilder sb = new StringBuilder("update book set");
        List<Object> list = new ArrayList<>();
        // maybe use reflect
        if (null != book.getbName()) {
            sb.append(split).append("bName=?");
            list.add(book.getbName());
            split = ',';
        }
        if (null != book.getAuthor()) {
            sb.append(split).append("author=?");
            list.add(book.getAuthor());
            split = ',';
        }
        if (null != book.getPubComp()) {
            sb.append(split).append("pubComp=?");
            list.add(book.getPubComp());
            split = ',';
        }
        if (null != book.getPubDate()) {
            sb.append(split).append("pubDate=?");
            list.add(book.getPubDate());
            split = ',';
        }
        if (null != book.getbCount()) {
            sb.append(split).append("bCount=?");
            list.add(book.getbCount());
            split = ',';
        }
        if (null != book.getPrice()) {
            sb.append(split).append("price=?");
            list.add(book.getPrice());
            split = ',';
        }
        sb.append(" where id=?");
        list.add(book.getId());
//        System.out.println(sb);
//        System.out.println(list);
        int ret = qr.update(sb.toString(), list.toArray());
        return ret != 0;
    }

    @Override
    public Boolean insertBook(Book book) throws SQLException {
        String sql = "insert into book(bName, author, pubComp, pubDate, bCount, price)" +
                "values (?,?,?,?,?,?)";
        int ret = qr.update(sql, book.getbName(), book.getAuthor(), book.getPubComp(), book.getPubDate(), book.getbCount(), book.getPrice());
        return ret != 0;
    }
}
