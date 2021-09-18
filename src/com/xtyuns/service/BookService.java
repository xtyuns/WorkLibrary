package com.xtyuns.service;

import com.xtyuns.vo.Books;

import java.sql.SQLException;
import java.util.Map;

public interface BookService {
    Books findAllBook() throws SQLException;

    Books findBookInPage(String page, String pageSize) throws SQLException;

    Boolean removeBookById(String id) throws SQLException;

    Boolean removeBookByIds(String[] ids) throws SQLException;

    Boolean modifyBookById(String id, Map<String, String> updateField) throws SQLException;

    Boolean saveBook(Map<String, String> bookField) throws SQLException;
}
