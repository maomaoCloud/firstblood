package com.web.controller;

import com.web.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.web.model.HeadlineNews;
import com.web.service.HeadlineNewsService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("news")
@Scope("prototype")
public class HeadlineNewsController extends BaseController {

    @Autowired
    private HeadlineNewsService headlineNewsService;

    @RequestMapping("{typeId}/{pageNum}/{pageSize}")
    public JsonResult newsList(@PathVariable(name = "typeId") String typeId,
                               @PathVariable(name = "pageNum") Integer pageNum,
                               @PathVariable(name = "pageSize") Integer pageSize) {
        PageHelper.startPage( pageNum, pageSize );

        List<HeadlineNews> newsList;
        try {
            newsList = new ArrayList<>();//根据业务查询新闻列表
        } catch (Exception e) {
            //output log
            return JsonResult.FAILED();
        }

        addResult( "hasMore", false );//是否还有更多数据
        addResult( "data", typeId );//查询出的数据结果

        return JsonResult.SUCCESS( "success", getResultMap() );
    }

    @RequestMapping("newsById/{newsId}")
    public JsonResult newsById(@PathVariable(name = "newsId") String newsId) {
        HeadlineNews headlineNews;
        try {
            headlineNews = headlineNewsService.queryNewsById( newsId );
        } catch (Exception e) {
            //output log
            return JsonResult.FAILED( "系统繁忙" );
        }

        return JsonResult.SUCCESS( "success", headlineNews );
    }

}
