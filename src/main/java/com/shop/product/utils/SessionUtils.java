package com.shop.product.utils;

import java.util.Map;

/**
 * Created by lorne on 2017/6/12.
 */
public class SessionUtils {

    public static String getName(Map<String,Object> sessionUser){
        return  (String)sessionUser.get("name");
    }


    public static String getPwd(Map<String,Object> sessionUser){
        return  (String)sessionUser.get("pwd");
    }
}
