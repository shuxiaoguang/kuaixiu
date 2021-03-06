package com.kuaixiu.groupSMS.controller;

import com.common.base.controller.BaseController;
import com.common.paginate.Page;
import com.kuaixiu.groupSMS.entity.HsGroupMobileSms;
import com.kuaixiu.groupSMS.service.HsGroupMobileSmsService;
import com.system.api.entity.ResultData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * HsGroupMobileSms Controller
 *
 * @CreateDate: 2019-06-20 下午03:44:16
 * @version: V 1.0
 */
@Controller
public class HsGroupMobileSmsController extends BaseController {

    @Autowired
    private HsGroupMobileSmsService hsGroupMobileSmsService;

    @RequestMapping(value = "groupSms/toSmsList")
    public ModelAndView toAddressList(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        String returnView = "groupSms/smsList";
        return new ModelAndView(returnView);
    }

    @RequestMapping(value = "groupSms/smsListForPage")
    public void smsListForPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Page page = getPageByRequest(request);
        HsGroupMobileSms groupMobileSms = new HsGroupMobileSms();
        groupMobileSms.setPage(page);
        List<HsGroupMobileSms> hsGroupMobileSms = hsGroupMobileSmsService.queryListForPage(groupMobileSms);
        page.setData(hsGroupMobileSms);
        this.renderJson(response, page);
    }

    @RequestMapping(value = "groupSms/toAddSms")
    public ModelAndView toAddAddress(HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {

        String returnView = "groupSms/createSms";
        return new ModelAndView(returnView);
    }

    @RequestMapping("/groupSms/addSms")
    @ResponseBody
    public ResultData addAddress(HttpServletRequest request, HttpServletResponse response) {
        ResultData result = new ResultData();
        try {
            String nameLabel = request.getParameter("nameLabel");
            String smsTemplate = request.getParameter("smsTemplate");//优惠券名称
            if (StringUtils.isBlank(smsTemplate) || StringUtils.isBlank(nameLabel)) {
                return getSjResult(result, null, false, "2", null, "参数不完整");
            }
            HsGroupMobileSms groupMobileSms = hsGroupMobileSmsService.getDao().queryByNameLabel(nameLabel);
            if (groupMobileSms != null) {
                return getSjResult(result, null, false, "3", null, "地址名字重复");
            }
            HsGroupMobileSms groupMobileSms1 = new HsGroupMobileSms();
            groupMobileSms1.setId(UUID.randomUUID().toString().replace("-", ""));
            groupMobileSms1.setNameLabel(nameLabel);
            groupMobileSms1.setSmsTemplate(smsTemplate);
            hsGroupMobileSmsService.add(groupMobileSms1);

            getSjResult(result, null, true, "0", null, "创建成功");
        } catch (Exception e) {
            e.printStackTrace();
            getSjResult(result, null, false, "5", null, "系统异常请稍后再试");
        }
        return result;
    }

    @RequestMapping(value = "groupSms/toEditSms")
    public ModelAndView toEditCouponRole(HttpServletRequest request,
                                         HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        HsGroupMobileSms groupMobileSms = hsGroupMobileSmsService.queryById(id);
        request.setAttribute("groupMobileSms", groupMobileSms);
        String returnView = "groupSms/editSms";
        return new ModelAndView(returnView);
    }

    @RequestMapping("/groupSms/editSms")
    @ResponseBody
    public ResultData editCouponRole(HttpServletRequest request, HttpServletResponse response) {
        ResultData result = new ResultData();
        try {
            String id = request.getParameter("id");
            String nameLabel = request.getParameter("nameLabel");
            String smsTemplate = request.getParameter("smsTemplate");//优惠券名称
            if (StringUtils.isBlank(id) || StringUtils.isBlank(smsTemplate) || StringUtils.isBlank(nameLabel)) {
                return getSjResult(result, null, false, "2", null, "参数不完整");
            }
            HsGroupMobileSms groupMobileSms = hsGroupMobileSmsService.queryById(id);
            HsGroupMobileSms hsGroupMobileSms = hsGroupMobileSmsService.getDao().queryByNameLabel(nameLabel);
            if (hsGroupMobileSms != null) {
                if (!groupMobileSms.getNameLabel().equals(hsGroupMobileSms.getNameLabel())) {
                    return getSjResult(result, null, false, "3", null, "规则名字重复");
                }
            }
            groupMobileSms.setNameLabel(nameLabel);
            groupMobileSms.setSmsTemplate(smsTemplate);
            hsGroupMobileSmsService.saveUpdate(groupMobileSms);

            getSjResult(result, null, true, "0", null, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            getSjResult(result, null, false, "5", null, "系统异常请稍后再试");
        }
        return result;
    }

    @RequestMapping("/groupSms/delSms")
    @ResponseBody
    public ResultData delAddress(HttpServletRequest request, HttpServletResponse response) {
        ResultData result = new ResultData();
        try {
            String id = request.getParameter("id");

            if (StringUtils.isBlank(id)) {
                return getSjResult(result, null, false, "2", null, "参数为空");
            }
            HsGroupMobileSms groupMobileSms = hsGroupMobileSmsService.queryById(id);
            if (groupMobileSms == null) {
                return getSjResult(result, null, false, "2", null, "规则不存在");
            }
            hsGroupMobileSmsService.getDao().deleteByIsDel(id);
            getSjResult(result, null, true, "0", null, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            getSjResult(result, null, false, "5", null, "系统异常请稍后再试");
        }
        return result;
    }
}
