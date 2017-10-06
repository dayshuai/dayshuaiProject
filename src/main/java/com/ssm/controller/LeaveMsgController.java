package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssm.app.service.WebAppService;

/**
 * Created by SuperS on 16/2/28.
 * 访客留言页面 调用多说的API接口
 */
@Controller
@RequestMapping("/leave")
public class LeaveMsgController {
    @Autowired
    private WebAppService  webAppService;
    //显示留言页面
    @RequestMapping(method = RequestMethod.GET)
    public String leavePage(ModelMap model){
        model.addAttribute("webAppDto",webAppService.getWebDtoWebApp(1));

        model.addAttribute("mainPage","layout/content/leave/detail.vm");
        return "index";
    }
}
