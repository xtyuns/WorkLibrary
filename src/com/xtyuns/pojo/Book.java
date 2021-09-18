package com.xtyuns.pojo;

public class Book {
    private Integer id;
    private String bName;
    private String author;
    private String pubComp;
    private String pubDate;
    private Integer bCount;
    private Float price;

    public Book() {
    }

    public Book(Integer id, String bName, String author, String pubComp, String pubDate, Integer bCount, Float price) {
        this.id = id;
        this.bName = bName;
        this.author = author;
        this.pubComp = pubComp;
        this.pubDate = pubDate;
        this.bCount = bCount;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubComp() {
        return pubComp;
    }

    public void setPubComp(String pubComp) {
        this.pubComp = pubComp;
    }

    public String getPubDate() {
        // reformat: 2021-09-18 00:00:00.0
        if (null != pubDate && pubDate.length() == 21)
            return pubDate.substring(0, 19);
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Integer getbCount() {
        return bCount;
    }

    public void setbCount(Integer bCount) {
        this.bCount = bCount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
