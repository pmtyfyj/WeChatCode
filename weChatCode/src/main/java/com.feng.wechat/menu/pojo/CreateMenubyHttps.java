package com.feng.wechat.menu.pojo;

/**
 * @author: PMTY
 * @create: 2018-08-11 16:39
 **/
public class CreateMenubyHttps {

    public static String createMenubyHttpsMeth(String access_token, String requestData)
    {
        // 返回报文
        String strResp = "";
        String path = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + access_token;
        try
        {
            strResp = HttpClientUtil.doPostJson(path,requestData);
        } catch (Exception e)
        {
            System.out.println(e);
        }
        finally
        {}
        return strResp;

    }
}