package com.zy.shirozy.common;

import java.util.Random;

/**
 *@Author feri
 *@Date Created in 2018/10/12 14:49
 */
public class TokenUtil {
    //生成令牌
    public static String createToken(int uid){
        String r=uid+"_"+System.currentTimeMillis()+"_"+new Random().nextInt();
        return PassUtil.base64EN(r);
    }
    //刷新令牌
    public static String refesh(String token){
        String r=PassUtil.base64DE(token);
        String[] arr=r.split("_");
        String rn=arr[0]+"_"+System.currentTimeMillis()+"_"+arr[1];
        //String rn=createToken(Integer.parseInt(arr[0]));
        return PassUtil.base64EN(rn);
    }
    //校验令牌
    public static boolean checkToken(String token){
        String r=PassUtil.base64DE(token);
        String[] arr=r.split("_");
        Long oldtime=Long.parseLong(arr[1]);
        if((System.currentTimeMillis()-oldtime)/1000>30*60){
            //令牌的空闲时间超出30分钟
            return false;
        }else {
            return true;
        }
    }


}
