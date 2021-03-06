package com.tiaotiaopoker.controller.ext;

import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiekang on 2018/6/3.
 */
public class SpecialDateEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Date date = null;
        try {
            //防止空数据出错
            if( StringUtils.isNotBlank( text ) ) {
                date = format.parse( text );
            }
        } catch (ParseException e) {
            format = new SimpleDateFormat( "yyyy-MM-dd" );
            try {
                date = format.parse( text );
            } catch (ParseException e1) {
                format = new SimpleDateFormat( "yyyy-MM" );

                try {
                    date = format.parse( text );
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        setValue( date );
    }
}
