package com.web.controller;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiekang on 2018/8/16.
 */
public class BaseController {
    /**
     * Store JSON API result item
     */
    private Map<String, Object> resMap;

    @PostConstruct
    public void init() {
        resMap = new HashMap<>();
    }

    /**
     * return the JSON API result Map
     */
    public Map getResultMap() {
        return resMap;
    }

    /**
     * Put a json item
     */
    public void addResult(String key,
                          Object value) {
        resMap.put( key, value );
    }

}
