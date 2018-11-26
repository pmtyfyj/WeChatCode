package com.feng.wechat.menu;

import com.alibaba.fastjson.JSONObject;
import com.feng.wechat.menu.pojo.AccessToken;
import com.feng.wechat.menu.pojo.Constant;
import com.feng.wechat.menu.pojo.CreateMenubyHttps;
import com.feng.wechat.menu.pojo.HttpClientUtil;

/**
 * 创建菜单
 * @author: PMTY
 * @create: 2018-08-11 14:30
 **/
public class CreateMenu {
    public static void main(String[] args) {
        boolean menu = createMenu();
        System.out.println(menu);
    }

    /**
     * 创建菜单
     *
     * @return
     */
    public static boolean createMenu() {
        AccessToken accessToken = getAccessToken();

        String createMenuUrl = Constant.CREATE_MENU;

        // 组建菜单
//        String menuJsonStr = HttpClientUtil.doGet(createMenuUrl.replace("ACCESS_TOKEN", accessToken.getAccess_token()));
        String menuJsonStr = HttpClientUtil.doPost(createMenuUrl.replace("ACCESS_TOKEN", accessToken.getAccess_token()));
        System.out.println(menuJsonStr);
        // 请求调用
        String result = CreateMenubyHttps.createMenubyHttpsMeth(accessToken.getAccess_token(), SetMenuII.menu);
        return true;
    }

    /**
     * 获取token
     *
     * @return
     */
    public static AccessToken getAccessToken() {

        String accesstokenUrl = Constant.GET_ACCESSTOKEN;

        String requestUrl = accesstokenUrl.replace("APPID", Constant.APP_ID).replace("APPSECRET", Constant.APP_SECRET);

        //获取token
//        String tokenJsonStr = HttpClientUtil.doGet(requestUrl);
        String tokenJsonStr = HttpClientUtil.doPost(requestUrl);

        System.out.println(tokenJsonStr);
        AccessToken accessToken = JSONObject.parseObject(tokenJsonStr, AccessToken.class);


        return accessToken;
    }


}