package com.web.controller;

import com.web.model.ResponseJson;
import com.web.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.web.model.HeadlineNews;
import com.web.service.HeadlineNewsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("headlineNews")
public class HeadlineNewsController {

    @Autowired
    private HeadlineNewsService headlineNewsService;

    @RequestMapping("news/{typeId}/{pageNum}/{pageSize}")
    @ResponseBody
    public ResponseJson newsList(@PathVariable(name = "typeId") String typeId,
                                 @PathVariable(name = "pageNum") Integer pageNum, @PathVariable(name = "pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        ResponseJson responseJson = new ResponseJson();
        Map<String, Object> resultMap = new HashMap<>();
        try {
            resultMap = headlineNewsService.queryNewsByPage(typeId, pageNum, pageSize);
            responseJson.setSuccess(true);
            responseJson.setCode(Constant.RESPOBSE_STATUS_SUCCESS);
            responseJson.setMsg(Constant.RESPOBSE_MSG_SUCCESS);
            responseJson.setResData(resultMap);
        } catch (Exception e) {
            responseJson.setSuccess(false);
            responseJson.setCode(Constant.RESPOBSE_STATUS_ERROR);
            responseJson.setMsg(Constant.RESPOBSE_MSG_ERROR);
            responseJson.setResData(null);
            e.printStackTrace();
        }
        return responseJson;
    }

    @RequestMapping("newsById/{newsId}")
    @ResponseBody
    public HeadlineNews newsById(@PathVariable(name = "newsId") String newsId) {

        return headlineNewsService.queryNewsById(newsId);
    }
}
