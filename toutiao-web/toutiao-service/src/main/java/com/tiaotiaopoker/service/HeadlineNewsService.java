package com.tiaotiaopoker.service;



import com.tiaotiaopoker.pojo.HeadlineNews;
import org.springframework.stereotype.Component;

import java.util.Map;

public interface HeadlineNewsService {

    public Map<String, Object> queryNewsByPage(String typeId, int pageNum, int pageSize);

    public HeadlineNews queryNewsById(String newsId);

    public int addAndUpdateNews(HeadlineNews news);

}