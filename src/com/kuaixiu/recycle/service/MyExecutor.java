package com.kuaixiu.recycle.service;

import com.alibaba.fastjson.JSONObject;
import com.common.wechat.common.util.StringUtils;
import com.kuaixiu.recycle.entity.RecycleCheckItems;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MyExecutor {

    private ExecutorService executor = Executors.newCachedThreadPool();

    public void fun(JSONObject j, String openId, String loginMobile, String items,
                    String productId, String selectBrandId, String selectBrandName,
                    String selectModelName, String price,RecycleCheckItemsService recycleCheckItemsService) throws Exception {

        executor.submit(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    //新增
                    RecycleCheckItems t = new RecycleCheckItems();
                    RecycleCheckItems r = new RecycleCheckItems();
                    if (StringUtils.isNotBlank(loginMobile)) {
                        r.setLoginMobile(loginMobile);
                        t.setLoginMobile(loginMobile);
                    }
                    if (StringUtils.isNotBlank(openId)) {
                        r.setWechatId(openId);
                        t.setWechatId(openId);
                    }
                    List<RecycleCheckItems> list = recycleCheckItemsService.queryList(r);
                    if (!list.isEmpty()) {
                        RecycleCheckItems checkItems = list.get(0);
                        t.setLastPrice(checkItems.getPrice());
                    }
                    t.setItems(items);
                    t.setPrice(new BigDecimal(price));
                    t.setProductId(productId);
                    t.setBrand(selectBrandName);
                    t.setBrandId(selectBrandId);
                    t.setRecycleModel(selectModelName);
                    t.setQuoteId(j.getString("quoteid"));
                    recycleCheckItemsService.add(t);

//                    //将quoteid转为string
//                    if (StringUtil.isNotBlank(jsonResult.getString("datainfo"))) {
//                        JSONObject j = (JSONObject) jsonResult.get("datainfo");
//                        j.put("quoteid", j.getString("quoteid"));
//                        String price = j.getString("price");
//                        if (price.equals("0")) {
//                            price = "5";
//                        }
//                        request.getSession().setAttribute(j.getString("quoteid"), price);
//                        //如果openId存在则修改检测项和上次评估价
//                        if (StringUtils.isNotBlank(openId)) {
//                            RecycleCheckItems r = new RecycleCheckItems();
//                            r.setWechatId(openId);
//                            List<RecycleCheckItems> list = recycleCheckItemsService.queryList(r);
//                            if (!list.isEmpty()) {
//                                RecycleCheckItems checkItems = list.get(0);
//                                checkItems.setItems(items);
//                                checkItems.setLastPrice(checkItems.getPrice());
//                                checkItems.setQuoteId(j.getString("quoteid"));
//                                recycleCheckItemsService.saveUpdate(checkItems);
//                            }
//                        }
//
//                        //查询该手机号是否有存储过
//                        if (StringUtils.isNotBlank(loginMobile)) {
//                            // 得到当前session中品牌名称  品牌id  机型名称
//                            String selectBrandId = (String) request.getSession().getAttribute("selectBrandId");
//                            String selectBrandName = (String) request.getSession().getAttribute("selectBrandName");
//                            String selectModelName = (String) request.getSession().getAttribute("selectModelName");
//
//                            //新增
//                            RecycleCheckItems t = new RecycleCheckItems();
//                            t.setLoginMobile(loginMobile);
//                            t.setItems(items);
//                            t.setPrice(new BigDecimal(price));
//                            t.setProductId(productId);
//                            t.setBrand(selectBrandName);
//                            t.setBrandId(selectBrandId);
//                            t.setRecycleModel(selectModelName);
//                            t.setQuoteId(j.getString("quoteid"));
//                            recycleCheckItemsService.add(t);
//                        }
//                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("报错啦！！");
                }
            }
        });
    }

}