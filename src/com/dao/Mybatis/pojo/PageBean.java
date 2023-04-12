package com.dao.Mybatis.pojo;

import java.util.List;

/**
 * 这个类用来封装分页查询的数据
 */
public class PageBean {
    //当前页码
    private int currentPage;
    //设置每页显示几条数据
    private int row;
    //一共有多少条数据
    private int maxrow;
    //一共有多少页
    private int maxPage;
    //当前页的数据
    private List<Object> currentList;

    public PageBean() {
    }

    public PageBean(int currentPage, int row, int maxrow, int maxPage, List<Object> currentList) {
        this.currentPage = currentPage;
        this.row = row;
        this.maxrow = maxrow;
        this.maxPage = maxPage;
        this.currentList = currentList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getMaxrow() {
        return maxrow;
    }

    public void setMaxrow(int maxrow) {
        this.maxrow = maxrow;
    }

    public List<Object> getCurrentList() {
        return currentList;
    }

    public void setCurrentList(List<Object> currentList) {
        this.currentList = currentList;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    @Override
    public String toString() {
        return "pageBean{" +
                "currentPage=" + currentPage +
                ", row=" + row +
                ", maxrow=" + maxrow +
                ", currentList=" + currentList +
                '}';
    }
}
