package com.web.service;

import java.util.List;

import com.web.model.HeadlineNews;

public interface HeadlineNewsService {

	public List<HeadlineNews> queryNewsByPage(String typeId, Integer pageNum, Integer pageSize);
	
	public HeadlineNews queryNewsById(String newsId);
}
