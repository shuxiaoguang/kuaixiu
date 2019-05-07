package com.shangji.user.controller;

import com.common.base.controller.BaseController;
import com.shangji.user.service.MenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MenuRole Controller
 *
 * @CreateDate: 2019-05-06 上午10:45:46
 * @version: V 1.0
 */
@Controller
public class MenuRoleController extends BaseController {

    @Autowired
    private MenuRoleService menuRoleService;

    /**
     * 列表查询
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/menuRole/list")
    public ModelAndView list(HttpServletRequest request,
                              HttpServletResponse response) throws Exception {
        
        String returnView ="menuRole/list";
        return new ModelAndView(returnView);
    }
}
