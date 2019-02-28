package com.onlinechese.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: huang yuan li
 * @Description:
 * @date: Create in 下午 9:19 2018/10/3 0003
 * @Modifide by:
 */
public class CookieUtils {
    public static void writeCookie(String cookieName, String value, HttpServletResponse response){
        Cookie cookie = new Cookie(cookieName,value);
        cookie.setMaxAge(60*24*30);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    public static void writeCookie(String cookieName, String value, HttpServletResponse response,
                                   int seconds){
        Cookie cookie = new Cookie(cookieName,value);
        cookie.setMaxAge(seconds);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
