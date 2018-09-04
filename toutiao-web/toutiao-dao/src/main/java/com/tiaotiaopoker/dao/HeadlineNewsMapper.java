package com.tiaotiaopoker.dao;

import com.tiaotiaopoker.pojo.HeadlineNews;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Component(value = "headlineNewsMapper")
public interface HeadlineNewsMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table headline_news
     *
     * @mbggenerated Tue Aug 14 12:59:46 CST 2018
     */
    int deleteByPrimaryKey(String newsId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table headline_news
     *
     * @mbggenerated Tue Aug 14 12:59:46 CST 2018
     */
    int insert(HeadlineNews record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table headline_news
     *
     * @mbggenerated Tue Aug 14 12:59:46 CST 2018
     */
    int insertSelective(HeadlineNews record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table headline_news
     *
     * @mbggenerated Tue Aug 14 12:59:46 CST 2018
     */
    HeadlineNews selectByPrimaryKey(String newsId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table headline_news
     *
     * @mbggenerated Tue Aug 14 12:59:46 CST 2018
     */
    int updateByPrimaryKeySelective(HeadlineNews record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table headline_news
     *
     * @mbggenerated Tue Aug 14 12:59:46 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(HeadlineNews record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table headline_news
     *
     * @mbggenerated Tue Aug 14 12:59:46 CST 2018
     */
    int updateByPrimaryKey(HeadlineNews record);

    List<HeadlineNews> queryNewsByPage(Map<String, Object> paramMap);

    int countNewsByCondition(Map<String, Object> paramMap);
}