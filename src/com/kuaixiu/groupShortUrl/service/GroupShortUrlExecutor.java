package com.kuaixiu.groupShortUrl.service;

import com.common.util.SmsSendUtil;
import com.kuaixiu.groupShortUrl.entity.HsGroupShortUrlBatchRecord;
import com.kuaixiu.groupShortUrl.entity.HsGroupShortUrlMobile;
import com.kuaixiu.groupShortUrl.entity.HsGroupShortUrlRecord;
import com.kuaixiu.groupShortUrl.entity.HsGroupShortUrlSms;
import com.kuaixiu.recycle.service.RecycleSystemService;
import com.system.basic.user.entity.SessionUser;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class GroupShortUrlExecutor {

    private ExecutorService executor = Executors.newCachedThreadPool();

    public void fun(SessionUser su, List<HsGroupShortUrlMobile> groupMobiles,
                    HsGroupShortUrlRecordService hsGroupShortUrlRecordService,
                    HsGroupShortUrlSms hsGroupShortUrlSms, HsGroupShortUrlMobileService hsGroupShortUrlMobileService,
                    HsGroupShortUrlBatchRecord groupShortUrlBatchRecord,RecycleSystemService recycleSystemService) throws Exception {

        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

                    for (HsGroupShortUrlMobile groupMobile : groupMobiles) {
                        HsGroupShortUrlRecord groupMobileRecord = new HsGroupShortUrlRecord();
                        groupMobileRecord.setId(UUID.randomUUID().toString().replace("-", ""));
                        groupMobileRecord.setBatchId(groupShortUrlBatchRecord.getId());
                        groupMobileRecord.setMobile(groupMobile.getMobile());
                        groupMobileRecord.setCreateUserid(su.getUserId());
                        groupMobileRecord.setSmsId(hsGroupShortUrlSms.getId());
                        hsGroupShortUrlRecordService.add(groupMobileRecord);

                        SmsSendUtil.groupMobileSendCoupon(hsGroupShortUrlSms.getSmsTemplate(), groupMobile.getMobile(),recycleSystemService);
                    }
                    hsGroupShortUrlMobileService.getDao().deleteNull();
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("发送短信，系统异常！！");
                }
            }
        });
    }

}
