package com.shangji.user.controller;

import com.common.base.controller.BaseController;
import com.shangji.user.service.ConstructionCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ConstructionCompany Controller
 *
 * @CreateDate: 2019-05-06 上午10:51:22
 * @version: V 1.0
 */
@Controller
public class ConstructionCompanyController extends BaseController {

    @Autowired
    private ConstructionCompanyService constructionCompanyService;

    /**
     * 列表查询
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/constructionCompany/list")
    public ModelAndView list(HttpServletRequest request,
                              HttpServletResponse response) throws Exception {
        
        String returnView ="constructionCompany/list";
        return new ModelAndView(returnView);
    }
}
