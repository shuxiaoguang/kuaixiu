package com.common.wechat.util.http;

import com.common.wechat.common.bean.result.WxError;
import com.common.wechat.common.exception.WxErrorException;
import com.common.wechat.common.util.http.RequestExecutor;
import com.common.wechat.common.util.http.Utf8ResponseHandler;
import com.common.wechat.bean.result.WxMediaImgUploadResult;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.File;
import java.io.IOException;

/**
 * @author miller
 */
public class MediaImgUploadRequestExecutor implements RequestExecutor<WxMediaImgUploadResult, File> {
  @Override
  public WxMediaImgUploadResult execute(CloseableHttpClient httpclient, HttpHost httpProxy, String uri, File data) throws WxErrorException, IOException {
    HttpPost httpPost = new HttpPost(uri);
    if (httpProxy != null) {
      RequestConfig config = RequestConfig.custom().setProxy(httpProxy).build();
      httpPost.setConfig(config);
    }
    if (data != null) {
      HttpEntity entity = MultipartEntityBuilder
        .create()
        .addBinaryBody("media", data)
        .setMode(HttpMultipartMode.RFC6532)
        .build();
      httpPost.setEntity(entity);
      httpPost.setHeader("Content-Type", ContentType.MULTIPART_FORM_DATA.toString());
    }
    try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
      String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
      WxError error = WxError.fromJson(responseContent);
      if (error.getErrorCode() != 0) {
        throw new WxErrorException(error);
      }
      return WxMediaImgUploadResult.fromJson(responseContent);
    }
  }
}