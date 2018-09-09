package com.tiaotiaopoker.service.impl;

import com.tiaotiaopoker.Constants;
import com.tiaotiaopoker.StringUtils;
import com.tiaotiaopoker.dao.MatchMapper;
import com.tiaotiaopoker.pojo.MatchWithBLOBs;
import com.tiaotiaopoker.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

/**
 * Created by xiekang on 2018/9/9.
 */
@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchMapper matchMapper;
    @Value("${match.banner.default}")
    private String      MATCH_BANNER_DEFAULT;

    @Override
    public void saveMatch(@RequestBody MatchWithBLOBs data) {
        data.setId( StringUtils.generateShortUUID() );
        data.setIsDelete( Constants.DataBaseCommon.IS_DELETE_FALSE );
        if( StringUtils.isBlank( data.getBannerImg() ) ) {
            data.setBannerImg( MATCH_BANNER_DEFAULT );
        }
        data.setAddTime( new Date() );
        matchMapper.insertSelective( data );
    }
}
