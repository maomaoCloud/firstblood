package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.web.model.HeadlineNews;
import com.web.service.HeadlineNewsService;

@RestController()
@RequestMapping("headlineNews")
public class HeadlineNewsController {
	
	@Autowired
	private HeadlineNewsService headlineNewsService;

	@RequestMapping("news/{typeId}/{pageNum}/{pageSize}")
	public JSONObject newsList(@PathVariable(name = "typeId") String typeId,
			@PathVariable(name = "pageNum") Integer pageNum, @PathVariable(name = "pageSize") Integer pageSize) {
		PageHelper.startPage(1, 1);
		
		return null;
	}
	
	@RequestMapping("newsById/{newsId}")
	@ResponseBody
	public HeadlineNews newsById(@PathVariable(name = "newsId") String newsId) {
		
		return headlineNewsService.queryNewsById(newsId);
	}
}
