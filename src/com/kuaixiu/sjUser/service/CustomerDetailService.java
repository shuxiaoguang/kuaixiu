package com.kuaixiu.sjUser.service;


import com.alibaba.fastjson.JSONObject;
import com.common.base.service.BaseService;
import com.common.util.SmsSendUtil;
import com.kuaixiu.sjBusiness.entity.AreaBranchOffice;
import com.kuaixiu.sjBusiness.entity.AreaContractBody;
import com.kuaixiu.sjBusiness.entity.AreaManagementUnit;
import com.kuaixiu.sjBusiness.entity.SjCode;
import com.kuaixiu.sjBusiness.service.*;
import com.kuaixiu.sjUser.dao.CustomerDetailMapper;
import com.kuaixiu.sjUser.entity.CustomerDetail;

import com.kuaixiu.sjUser.entity.SjUser;
import com.system.constant.SystemConstant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * CustomerDetail Service
 *
 * @CreateDate: 2019-05-06 上午10:48:12
 * @version: V 1.0
 */
@Service("customerDetailService")
public class CustomerDetailService extends BaseService<CustomerDetail> {
    private static final Logger log = Logger.getLogger(CustomerDetailService.class);

    @Autowired
    private CustomerDetailMapper<CustomerDetail> mapper;
    @Autowired
    private AreaCityCompanyService cityCompanyService;
    @Autowired
    private AreaManagementUnitService managementUnitService;
    @Autowired
    private AreaBranchOfficeService branchOfficeService;
    @Autowired
    private AreaContractBodyService contractBodyService;
    @Autowired
    private SjCodeService codeService;


    public CustomerDetailMapper<CustomerDetail> getDao() {
        return mapper;
    }

    //**********自定义方法***********
    public JSONObject getUserToJsonObject(SjUser sjUser, CustomerDetail customerDetail) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", sjUser.getName());
        jsonObject.put("phone", sjUser.getPhone());
        StringBuilder ascription = new StringBuilder();
        String cityCompany = cityCompanyService.queryById(customerDetail.getCityCompanyId()).getCityCompany();
        ascription.append(cityCompany);
        if (customerDetail.getManagementUnitId() != null) {
            AreaManagementUnit managementUnit1 = managementUnitService.queryById(customerDetail.getManagementUnitId());
            if (managementUnit1 != null) {
                String managementUnit = managementUnit1.getManagementUnit();
                ascription.append("/" + managementUnit);
            }
        }
        if (customerDetail.getBranchOfficeId() != null) {
            AreaBranchOffice branchOffice1 = branchOfficeService.queryById(customerDetail.getBranchOfficeId());
            if (branchOffice1 != null) {
                String branchOffice = branchOffice1.getBranchOffice();
                ascription.append("/" + branchOffice);
            }
        }
        if (customerDetail.getContractBodyId() != null) {
            AreaContractBody contractBody1 = contractBodyService.queryById(customerDetail.getContractBodyId());
            if (contractBody1 != null) {
                String contractBody = contractBody1.getContractBody();
                ascription.append("/" + contractBody);
            }

        }
        jsonObject.put("ascription", ascription.toString());
        jsonObject.put("marketingNo", customerDetail.getMarketingNo());
        return jsonObject;
    }

    /**
     * 获取验证码并保存到session
     *
     * @param request
     * @return
     * @CreateDate: 2016-9-13 下午8:24:41
     */
    public String getRandomCode(HttpServletRequest request, String key) {
        String randomCode = SmsSendUtil.randomCode();
        request.getSession().setAttribute(SystemConstant.SESSION_RANDOM_CODE + key, randomCode);
        //保存验证码到数据库
        SjCode code = codeService.queryById(key);
        if (code == null) {
            code = new SjCode();
            code.setCode(randomCode);
            code.setPhone(key);
            codeService.add(code);
        } else {
            code.setCode(randomCode);
            code.setUpdateTime(new Date());
            codeService.saveUpdate(code);
        }
        return randomCode;
    }
}