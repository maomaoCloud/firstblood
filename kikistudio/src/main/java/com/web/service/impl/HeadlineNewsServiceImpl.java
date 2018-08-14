/**
 * 
 */
package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.HeadlineNewsMapper;
import com.web.model.HeadlineNews;
import com.web.service.HeadlineNewsService;

/**
 * @author Administrator
 *
 */
@Service
public class HeadlineNewsServiceImpl implements HeadlineNewsService {
	
	@Autowired
	private HeadlineNewsMapper headlineNewsMapper;

	@Override
	public List<HeadlineNews> queryNewsByPage(String typeId, Integer pageNum, Integer pageSize) {
		
		return null;
	}

	@Override
	public HeadlineNews queryNewsById(String newsId) {
		
		return headlineNewsMapper.selectByPrimaryKey(newsId);
	}

}
