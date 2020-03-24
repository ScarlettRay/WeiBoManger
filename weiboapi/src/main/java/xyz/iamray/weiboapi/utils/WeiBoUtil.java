package xyz.iamray.weiboapi.utils;

import java.util.List;

/**
 * @author liuwenrui
 * @since 2018/11/24
 */
public class WeiBoUtil {


    /**
     * 字符串拼接技术
     * @param strs
     * @return
     */
    public static String strjoin(List strs, String substr){
        StringBuilder sb = new StringBuilder();
        strs.forEach(e->sb.append(e+substr));
        return sb.toString().substring(0,
                sb.lastIndexOf(substr)>0?sb.lastIndexOf(substr):0);
    }

    /**
     * 去除html代碼，如果是emojy表情则替换
     * TODO
     * @return
     */
    public static String trimHtml(String text){
        return text;
    }
}