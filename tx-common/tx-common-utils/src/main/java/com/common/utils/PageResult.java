package com.common.utils;

import java.io.Serializable;
import java.util.List;


public class PageResult<T> implements Serializable {

    //当前页
    private int pageNum;

    //每页的数量
    private int pageSize;

    //总页数
    private int pages;

    //总记录数
    private long total;

    //当前页的数量
    private int size;

    //是否为第一页
    private boolean isFirstPage = false;

    //是否为最后一页
    private boolean isLastPage = false;

    //分页结果集
    private List<T> list;


    private T t;

    public int getPageNum() {
        if (pageNum <= 0) {
            this.pageNum = 1;
        }
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        if (pageSize <= 0) {
            this.pageSize = 10;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean getIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean getIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }
}
