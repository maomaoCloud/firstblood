package com.tiaotiaopoker.service;



import com.tiaotiaopoker.common.Pagination;
import com.tiaotiaopoker.pojo.HeadlineNews;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public interface HeadlineNewsService {

    public List<HeadlineNews> queryNewsByCondition(HeadlineNews news, Pagination page);

    public Map<String, Object> queryNewsByPage(String typeId, int pageNum, int pageSize);

    public HeadlineNews queryNewsById(String newsId);

    public int addAndUpdateNews(HeadlineNews news);

    int editNewsBySelective(HeadlineNews news);

    int setNewsSort(HeadlineNews news);

}