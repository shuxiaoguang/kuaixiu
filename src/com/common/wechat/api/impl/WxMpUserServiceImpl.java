package com.common.wechat.api.impl;

import java.util.List;

import com.google.gson.JsonObject;

import com.common.wechat.common.exception.WxErrorException;
import com.common.wechat.common.util.http.SimpleGetRequestExecutor;
import com.common.wechat.common.util.http.SimplePostRequestExecutor;
import com.common.wechat.api.WxMpService;
import com.common.wechat.api.WxMpUserService;
import com.common.wechat.bean.WxMpUserQuery;
import com.common.wechat.bean.result.WxMpUser;
import com.common.wechat.bean.result.WxMpUserList;

/**
 * Created by Binary Wang on 2016/7/21.
 */
public class WxMpUserServiceImpl implements WxMpUserService {
  private static final String API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/user";
  private WxMpService wxMpService;

  public WxMpUserServiceImpl(WxMpService wxMpService) {
    this.wxMpService = wxMpService;
  }

  @Override
  public void userUpdateRemark(String openid, String remark) throws WxErrorException {
    String url = API_URL_PREFIX + "/info/updateremark";
    JsonObject json = new JsonObject();
    json.addProperty("openid", openid);
    json.addProperty("remark", remark);
    this.wxMpService.execute(new SimplePostRequestExecutor(), url, json.toString());
  }

  @Override
  public WxMpUser userInfo(String openid, String lang) throws WxErrorException {
    String url = API_URL_PREFIX + "/info";
    lang = lang == null ? "zh_CN" : lang;
    String responseContent = this.wxMpService.execute(new SimpleGetRequestExecutor(), url, "openid=" + openid + "&lang=" + lang);
    return WxMpUser.fromJson(responseContent);
  }

  @Override
  public WxMpUserList userList(String next_openid) throws WxErrorException {
    String url = API_URL_PREFIX + "/get";
    String responseContent = this.wxMpService.execute(new SimpleGetRequestExecutor(), url, next_openid == null ? null : "next_openid=" + next_openid);
    return WxMpUserList.fromJson(responseContent);
  }

  @Override
  public List<WxMpUser> userInfoList(List<String> openidList) throws WxErrorException {
    return userInfoList(new WxMpUserQuery(openidList));
  }

  @Override
  public List<WxMpUser> userInfoList(WxMpUserQuery userQuery) throws WxErrorException {
    String url = API_URL_PREFIX + "/info/batchget";
    String responseContent = this.wxMpService.execute(new SimpleGetRequestExecutor(), url, userQuery.toJsonString());
    return WxMpUser.fromJsonList(responseContent);
  }

}
