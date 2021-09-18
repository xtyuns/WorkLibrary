package com.xtyuns.dao;

import com.xtyuns.pojo.Book;
import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    Long countAllBook() throws SQLException;

    List<Book> selectAllBook() throws SQLException;

    List<Book> selectBookInPage(int page, int pageSize) throws SQLException;

    Boolean deleteBookById(int id) throws SQLException;

    Boolean deleteBookByIds(Integer[] ids) throws SQLException;

    Boolean updateBookById(Book book) throws SQLException;

    Boolean insertBook(Book book) throws SQLException;
}
