package com.tiaotiaopoker.service.impl;


import com.tiaotiaopoker.StringUtils;
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

}
