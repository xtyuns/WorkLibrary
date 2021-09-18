package com.xtyuns.service.impl;

import com.xtyuns.dao.BookDao;
import com.xtyuns.dao.impl.BookDaoImpl;
import com.xtyuns.pojo.Book;
import com.xtyuns.service.BookService;
import com.xtyuns.vo.Books;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UnknownFormatConversionException;

public class BookServiceImpl implements BookService {
    BookDao bDao = new BookDaoImpl();

    @Override
    public Books findAllBook() throws SQLException {
        List<Book> books = bDao.selectAllBook();
        return new Books(books, (long) books.size());
    }

    @Override
    public Books findBookInPage(String page, String pageSize) throws SQLException {
        try {
            int nPage = Integer.parseInt(page);
            int nPageSize = Integer.parseInt(pageSize);
            List<Book> books = bDao.selectBookInPage(nPage, nPageSize);
            Long count = bDao.countAllBook();
            return new Books(books, count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public Boolean removeBookById(String id) throws SQLException {
        try {
            int bid = Integer.parseInt(id);
            return bDao.deleteBookById(bid);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public Boolean removeBookByIds(String[] ids) throws SQLException {
        try {
            int size = 0;
            if (null == ids || (size = ids.length) == 0) throw new IllegalArgumentException("书籍编号列表不能为空");

            Integer[] nIds = new Integer[size];
            for (int i = 0; i < size; i++) {
                nIds[i] = Integer.valueOf(ids[i]);
            }

            return bDao.deleteBookByIds(nIds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public Boolean modifyBookById(String id, Map<String, String> updateField) throws SQLException {
        updateField.remove("id");
        Book book = new Book();
        try {
            book.setId(Integer.valueOf(id));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        Class<Book> bookClass = Book.class;
        updateField.forEach((k, v) -> {
            try {
                Field field = bookClass.getDeclaredField(k);
                field.setAccessible(true);
                Class<?> type = field.getType();
                if (type == String.class) {
                    field.set(book, v);
                } else if (type == Integer.class) {
                    field.set(book, Integer.valueOf(v));
                } else if (type == Float.class) {
                    field.set(book, Float.valueOf(v));
                } else {
                    throw new UnknownFormatConversionException("the type of \"" + k + "\" is not support");
                }
            } catch (NoSuchFieldException | IllegalAccessException ignore) {}
        });

        return bDao.updateBookById(book);
    }

    @Override
    public Boolean saveBook(Map<String, String> bookField) throws SQLException {
        Book newBook = new Book();

        Class<Book> bookClass = Book.class;
        bookField.forEach((k, v) -> {
            try {
                Field field = bookClass.getDeclaredField(k);
                field.setAccessible(true);
                Class<?> type = field.getType();
                if (type == String.class) {
                    field.set(newBook, v);
                } else if (type == Integer.class) {
                    field.set(newBook, Integer.valueOf(v));
                } else if (type == Float.class) {
                    field.set(newBook, Float.valueOf(v));
                } else {
                    throw new UnknownFormatConversionException("the type of \"" + k + "\" is not support");
                }
            } catch (NoSuchFieldException | IllegalAccessException ignore) {}
        });
        return bDao.insertBook(newBook);
    }
}
