package com.common.wechat.bean.kefu.request;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.gson.annotations.SerializedName;

import com.common.wechat.util.json.WxMpGsonBuilder;

public class WxMpKfSessionRequest implements Serializable {
  private static final long serialVersionUID = -5451863610674856927L;

  /**
   * kf_account 完整客服账号，格式为：账号前缀@公众号微信号
   */
  @SerializedName("kf_account")
  private String kfAccount;
  
  /**
   * openid 客户openid
   */
  @SerializedName("openid")
  private String openid;

  public WxMpKfSessionRequest(String kfAccount, String openid) {
    this.kfAccount = kfAccount;
    this.openid = openid;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }
  
  public String toJson() {
    return WxMpGsonBuilder.INSTANCE.create().toJson(this);
  }

  public String getKfAccount() {
    return this.kfAccount;
  }

  public void setKfAccount(String kfAccount) {
    this.kfAccount = kfAccount;
  }

}
