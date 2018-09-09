package com.tiaotiaopoker.service.impl;


import com.tiaotiaopoker.StringUtils;
import com.tiaotiaopoker.common.Pagination;
import com.tiaotiaopoker.entity.NewsListItem;
import com.tiaotiaopoker.pojo.HeadlineNews;
import com.tiaotiaopoker.service.HeadlineNewsService;
import com.tiaotiaopoker.dao.HeadlineNewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author Administrator
 */
@Component(value = "headlineNewsService")
public class HeadlineNewsServiceImpl implements HeadlineNewsService {

    @Autowired
    private HeadlineNewsMapper headlineNewsMapper;

    @Override
    public List<HeadlineNews> queryNewsByCondition(HeadlineNews news, Pagination page) {
        Map<String, Object> paramMap = new HashMap<>();
        if (!StringUtils.isBlank(news.getNewsTitle())) {
            paramMap.put("newsTitle", news.getNewsTitle());
        }
        if (!StringUtils.isBlank(news.getNewsType())) {
            paramMap.put("newsType", news.getNewsType());
        }
        if (null != news.getNewsStatus()) {
            paramMap.put("newsStatus", news.getNewsStatus());
        }
        List<HeadlineNews> list = headlineNewsMapper.queryNewsByPage(paramMap);
        page.setTotal(headlineNewsMapper.countNewsByCondition(paramMap));
        return list;
    }

    @Override
    public Map<String, Object> queryNewsByPage(String typeId,
                                               int pageNum,
                                               int pageSize) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();
        if (!StringUtils.isBlank(typeId)) {
            paramMap.put("typeId", typeId);
        }

        List<HeadlineNews> originDatalist = headlineNewsMapper.queryNewsByPage(paramMap);
        List<NewsListItem> list = new ArrayList<>();
        for (HeadlineNews hn : originDatalist)
            list.add(NewsListItem.genItemFromHeadlineNews(hn));

        int total;
        total = headlineNewsMapper.countNewsByCondition(paramMap);
        resultMap.put("hasMore", (pageNum - 1) * pageSize + list.size() < total);
        resultMap.put("data", list);
        return resultMap;
    }

    @Override
    public HeadlineNews queryNewsById(String newsId) {

        return headlineNewsMapper.selectByPrimaryKey(newsId);
    }

    @Override
    public int addAndUpdateNews(HeadlineNews news) {
        int result = 0;
        if (StringUtils.isBlank(news.getNewsId())) {
            news.setNewsId(StringUtils.generateShortUUID());
            news.setNewsCreateTime(new Date());
            result = headlineNewsMapper.insert(news);
        } else {
            news.setNewsUpdateTime(new Date());
            result = headlineNewsMapper.updateByPrimaryKeySelective(news);
        }
        return result;
    }

    @Override
    public int editNewsBySelective(HeadlineNews news) {
        return headlineNewsMapper.updateByPrimaryKeySelective(news);
    }

    @Override
    public int setNewsSort(HeadlineNews news) {
        int result = 0;
        result = headlineNewsMapper.updateByPrimaryKeySelective(news);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("newsSort", news.getNewsSort());
        List<HeadlineNews> list = headlineNewsMapper.queryNewsByPage(paramMap);
        //指定位置后的news sort+1
        for (HeadlineNews headlineNews : list) {
            headlineNews.setNewsSort(headlineNews.getNewsSort() + 1);
            result = headlineNewsMapper.updateByPrimaryKeySelective(headlineNews);
        }
        return result;
    }

}
