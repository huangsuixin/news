package com.app.huangsuixin1506101066.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Silence
 */

public class NewsPager {
    private Integer allPages; //总页数
    private List<NewsInfo> contentlist; //新闻实体集合
    private Integer currentPage; //当前页码
    private Integer allNum; //总数
    private Integer maxResult; //每页条数

    public NewsPager() {
        contentlist = new ArrayList<>();
    }

    public Integer getAllPages() {
        return allPages;
    }

    public void setAllPages(Integer allPages) {
        this.allPages = allPages;
    }

    public List<NewsInfo> getContentlist() {
        return contentlist;
    }

    public void setContentlist(List<NewsInfo> contentlist) {
        this.contentlist = contentlist;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }

    public Integer getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(Integer maxResult) {
        this.maxResult = maxResult;
    }

    @Override
    public String toString() {
        return "NewsPager{" +
                "allPages=" + allPages +
                ", contentlist=" + contentlist +
                ", currentPage=" + currentPage +
                ", allNum=" + allNum +
                ", maxResult=" + maxResult +
                '}';
    }
}
