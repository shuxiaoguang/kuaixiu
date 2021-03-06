package com.kuaixiu.groupSMS.service;

import com.common.util.SmsSendUtil;
import com.kuaixiu.groupSMS.entity.*;
import com.kuaixiu.recycle.entity.RecycleCoupon;
import com.kuaixiu.recycle.service.RecycleSystemService;
import com.system.basic.user.entity.SessionUser;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class GroupMobileExecutor {

    private ExecutorService executor = Executors.newCachedThreadPool();

    public void fun(SessionUser su, List<HsGroupMobile> groupMobiles, HsGroupCouponRole hsGroupCouponRole,
                    HsGroupMobileRecordService hsGroupMobileRecordService,
                    HsGroupMobileSms hsGroupMobileSms,HsGroupMobileService hsGroupMobileService,
                    HsGroupMobileBatchRecord groupMobileBatchRecord,RecycleSystemService recycleSystemService) throws Exception {

        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
//                    Thread.sleep(1000);

                    for (HsGroupMobile groupMobile : groupMobiles) {
                        RecycleCoupon recycleCoupon = hsGroupMobileRecordService.receiveCoupon(hsGroupCouponRole, groupMobile.getMobile(), su);
                        HsGroupMobileRecord groupMobileRecord = new HsGroupMobileRecord();
                        groupMobileRecord.setId(UUID.randomUUID().toString().replace("-", ""));
                        groupMobileRecord.setBatchId(groupMobileBatchRecord.getId());
                        groupMobileRecord.setCouponId(recycleCoupon.getId());
                        groupMobileRecord.setCouponCode(recycleCoupon.getCouponCode());
                        groupMobileRecord.setMobile(groupMobile.getMobile());
                        groupMobileRecord.setCreateUserid(su.getUserId());
                        groupMobileRecord.setSmsId(hsGroupMobileSms.getId());
                        hsGroupMobileRecordService.add(groupMobileRecord);
                        Thread.sleep(200);  //一分钟300条
                        SmsSendUtil.groupMobileSendCoupon(hsGroupMobileSms.getSmsTemplate(), groupMobile.getMobile(),recycleSystemService);
                    }
                    hsGroupMobileService.getDao().deleteNull();
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("发送短信，系统异常！！");
                }
            }
        });
    }

}
