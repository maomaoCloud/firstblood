package com.tiaotiaopoker.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
 * 头条新闻pojo类
 * Created by maojian
 * @date 2018/8/24 10:42
 */
public class HeadlineNews {

    private String newsId;
    private String newsTitle;
    private String newsCoverImg;
    private Date newsCreateTime;
    private Date newsUpdateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date newsStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date newsEndTime;
    private Integer newsSort;
    private String newsType;
    private Integer newsStatus;
    private String newsDetail;

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsCoverImg() {
        return newsCoverImg;
    }

    public void setNewsCoverImg(String newsCoverImg) {
        this.newsCoverImg = newsCoverImg;
    }

    public Date getNewsCreateTime() {
        return newsCreateTime;
    }

    public void setNewsCreateTime(Date newsCreateTime) {
        this.newsCreateTime = newsCreateTime;
    }

    public Date getNewsUpdateTime() {
        return newsUpdateTime;
    }

    public void setNewsUpdateTime(Date newsUpdateTime) {
        this.newsUpdateTime = newsUpdateTime;
    }

    public Date getNewsStartTime() {
        return newsStartTime;
    }

    public void setNewsStartTime(Date newsStartTime) {
        this.newsStartTime = newsStartTime;
    }

    public Date getNewsEndTime() {
        return newsEndTime;
    }

    public void setNewsEndTime(Date newsEndTime) {
        this.newsEndTime = newsEndTime;
    }

    public Integer getNewsSort() {
        return newsSort;
    }

    public void setNewsSort(Integer newsSort) {
        this.newsSort = newsSort;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public Integer getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(Integer newsStatus) {
        this.newsStatus = newsStatus;
    }

    public String getNewsDetail() {
        return newsDetail;
    }

    public void setNewsDetail(String newsDetail) {
        this.newsDetail = newsDetail;
    }

}