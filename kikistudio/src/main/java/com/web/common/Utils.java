package com.web.common;

import java.util.UUID;

/**
 * Created by xiekang on 2018/8/16.
 */
public class Utils {
    private static String[] chars = new String[]{ "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

    /**
     * 生成8位随机字符，包括大小写字母和数字
     * 此代码是由阿里提供
     */
    public static String gen8Key() {
        StringBuffer stringBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace( "-", "" );
        for( int i = 0; i < 8; i++ ) {
            String str = uuid.substring( i * 4, i * 4 + 4 );
            int strInteger = Integer.parseInt( str, 16 );
            stringBuffer.append( chars[strInteger % 0x3E] );
        }
        return stringBuffer.toString();
    }
}
