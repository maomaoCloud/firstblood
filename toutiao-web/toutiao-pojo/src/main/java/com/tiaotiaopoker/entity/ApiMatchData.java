package com.tiaotiaopoker.entity;

import com.tiaotiaopoker.pojo.Match;
import org.joda.time.DateTime;

/**
 * Created by xiekang on 2018/9/10.
 */
public class ApiMatchData {
    private String  id;
    private String  theme;
    private String  startDate;
    private String  location;
    private Integer applyCount;
    private Integer fee;
    private String  bannerImg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public static ApiMatchData genFromMatch(Match md) {
        ApiMatchData res = new ApiMatchData();
        res.setId( md.getId() );
        res.setApplyCount( 0 );
        res.setBannerImg( md.getBannerImg() );

        try {
            res.setFee( Integer.parseInt( md.getFee().toString() ) );
        } catch (Exception e) {
            res.setFee( 0 );
        }

        String location = md.getProvince();
        if( !md.getProvince().equals( md.getCity() ) ) {
            location += md.getCity();
        }
        location += md.getArea();
        res.setLocation( location );
        res.setStartDate( new DateTime( md.getStartDate() ).toString( "yyyy-MM-dd HH:mm" ) );
        res.setTheme( md.getTheme() );

        return res;
    }
}

