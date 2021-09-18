package com.xtyuns.vo;

import com.xtyuns.pojo.Book;

import java.util.List;

public class Books {
    private final List<Book> data;
    private final Long count;

    public Books(List<Book> data, Long count) {
        this.data = data;
        this.count = count;
    }

    public List<Book> getData() {
        return data;
    }

    public Long getCount() {
        return count;
    }
}
