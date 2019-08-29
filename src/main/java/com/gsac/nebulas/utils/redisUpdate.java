package com.gsac.nebulas.utils;

import com.gsac.nebulas.model.UserVo;

public class redisUpdate {

    public void updateJedis(String name){
        UserVo userVo = CookieUtil.getCookie(name,UserVo.class);
        userVo.getId();
    }
}
