package com.common.wechat.common.bean.result;

import com.common.wechat.common.util.json.WxGsonBuilder;

import java.io.Serializable;

public class WxMediaUploadResult implements Serializable {
  private static final long serialVersionUID = 330834334738622341L;

  private String type;
  private String mediaId;
  private String thumbMediaId;
  private long createdAt;

  public static WxMediaUploadResult fromJson(String json) {
    return WxGsonBuilder.create().fromJson(json, WxMediaUploadResult.class);
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getMediaId() {
    return mediaId;
  }

  public void setMediaId(String mediaId) {
    this.mediaId = mediaId;
  }

  public long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(long createdAt) {
    this.createdAt = createdAt;
  }

  public String getThumbMediaId() {
    return thumbMediaId;
  }

  public void setThumbMediaId(String thumbMediaId) {
    this.thumbMediaId = thumbMediaId;
  }

  @Override
  public String toString() {
    return "WxUploadResult [type=" + type + ", media_id=" + mediaId + ", thumb_media_id=" + thumbMediaId
            + ", created_at=" + createdAt + "]";
  }

}