package com.tiaotiaopoker.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.tiaotiaopoker.JsonResult;
import com.tiaotiaopoker.StringUtils;
import com.tiaotiaopoker.common.Pagination;
import com.tiaotiaopoker.pojo.HeadlineNews;
import com.tiaotiaopoker.service.HeadlineNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("news")
@Scope("prototype")
public class HeadlineNewsController {

    @Autowired
    private HeadlineNewsService headlineNewsService;

    @RequestMapping("addAndEditPage")
    public ModelAndView addAndEditPage(ModelAndView mv) {

        mv.setViewName( "admin/headLineNews/addPage" );
        return mv;
    }

    @RequestMapping("listPage")
    public ModelAndView listPage(ModelAndView mv,
                                 @ModelAttribute(value = "page") Pagination page,
                                 @ModelAttribute(value = "headlineNews") HeadlineNews news) {

        PageHelper.startPage( page.getPage(), page.getRows() );
        List<HeadlineNews> list = headlineNewsService.queryNewsByCondition( news, page );
        mv.addObject( "news", news );
        mv.addObject( "page", page );
        mv.addObject( "list", list );
        mv.setViewName( "admin/headlineNews/listPage" );
        return mv;
    }

    /*
     * 头条新闻列表
     * Created by maojian
     * @date 2018/8/24 10:43
     */
    @RequestMapping(value = "{typeId}/{pageNum}/{pageSize}",
                    method = RequestMethod.GET)
    public JsonResult newsList(@PathVariable(name = "typeId") String typeId,
                               @PathVariable(name = "pageNum") Integer pageNum,
                               @PathVariable(name = "pageSize") Integer pageSize) {
        PageHelper.startPage( pageNum, pageSize );
        JsonResult jsonResult;
        Map<String, Object> resultMap;
        try {
            resultMap = headlineNewsService.queryNewsByPage( typeId, pageNum, pageSize );
            jsonResult = JsonResult.SUCCESS( "success", resultMap );
        } catch (Exception e) {
            jsonResult = JsonResult.FAILED( "头条新闻列表接口异常" );
            e.printStackTrace();
        }
        return jsonResult;
    }

    @RequestMapping(value = "setTop",
                    method = RequestMethod.POST)
    public JsonResult setTop(HeadlineNews news) {

        JsonResult jsonResult;
        try {
            if( StringUtils.isBlank( news.getNewsId() ) || null == news.getNewsSort() ) {
                jsonResult = JsonResult.FAILED( "参数缺失" );
            } else {
                int result = headlineNewsService.setNewsSort( news );
                if( result > 0 ) {
                    jsonResult = JsonResult.SUCCESS();
                } else {
                    jsonResult = JsonResult.FAILED();
                }
            }
        } catch (Exception e) {
            jsonResult = JsonResult.FAILED( "置顶接口异常" );
            e.printStackTrace();
        }
        return jsonResult;

    }

    /*
     * 头条新闻（id）
     * Created by maojian
     * @date 2018/8/24 10:40
     */
    @RequestMapping(value = "{newsId}/new",
                    method = RequestMethod.GET)
    public JsonResult newsById(@PathVariable(name = "newsId") String newsId) {
        JsonResult jsonResult;
        try {
            if( StringUtil.isEmpty( newsId ) ) {
                jsonResult = JsonResult.FAILED( "id缺失" );
            } else {
                HeadlineNews news = headlineNewsService.queryNewsById( newsId );
                jsonResult = JsonResult.SUCCESS( "success", news );
            }
        } catch (Exception e) {
            jsonResult = JsonResult.FAILED( "头条新闻(id)异常" );
            e.printStackTrace();
        }
        return jsonResult;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public JsonResult newsAdd(HeadlineNews news) {
        JsonResult jsonResult;
        try {
            int result = headlineNewsService.addAndUpdateNews( news );
            if( result > 0 ) {
                jsonResult = JsonResult.SUCCESS( "success" );
            } else {
                jsonResult = JsonResult.FAILED( "插入失败" );
            }
        } catch (Exception e) {
            jsonResult = JsonResult.FAILED( "新增头条新闻异常" );
            e.printStackTrace();
        }
        return jsonResult;
    }

    @RequestMapping("update")
    public JsonResult newsUpdate(HeadlineNews news) {
        JsonResult jsonResult;
        try {
            if( StringUtils.isBlank( news.getNewsId() ) ) {
                jsonResult = JsonResult.FAILED( "id缺失" );
            } else {
                int result = headlineNewsService.addAndUpdateNews( news );
                if( result > 0 ) {
                    jsonResult = JsonResult.SUCCESS( "更新成功" );
                } else {
                    jsonResult = JsonResult.FAILED( "更新失败" );
                }
            }
        } catch (Exception e) {
            jsonResult = JsonResult.FAILED( "更新接口异常" );
            e.printStackTrace();
        }
        return jsonResult;
    }
}
