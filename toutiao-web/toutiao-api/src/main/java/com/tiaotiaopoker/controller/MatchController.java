package com.tiaotiaopoker.controller;

import com.tiaotiaopoker.JsonResult;
import com.tiaotiaopoker.pojo.MatchWithBLOBs;
import com.tiaotiaopoker.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiekang on 2018/9/9.
 */
@RestController()
@RequestMapping("match")
@Scope("prototype")
public class MatchController  extends  BaseController {
    @Autowired
    private MatchService matchService;

    @RequestMapping(value = "add",
                    method = RequestMethod.POST)
    public JsonResult addMatch(@RequestBody MatchWithBLOBs data) {
        try {
            matchService.saveMatch( data );
            return JsonResult.SUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.FAILED( "添加失败！" );
        }
    }
}
