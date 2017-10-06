package com.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssm.app.service.WebAppService;
import com.ssm.bean.dto.UserDto;
import com.ssm.bean.dto.WebAppDto;

/**
 * Created by SuperS on 16/2/29.
 * 显示Manage主页
 */
@Controller
@RequestMapping("/manage")
public class ManageController {
    @Autowired
    private WebAppService webAppService;

    @RequestMapping(method = RequestMethod.GET)
    public String manageHome(ModelMap model, HttpSession session) {
        WebAppDto webAppDto = webAppService.getWebDtoWebApp(1);
        webAppDto.setArticleViews(webAppService.getArticlesView());
        model.addAttribute("mainPage", "admin/home/home.vm");
        model.addAttribute("user", (UserDto) session.getAttribute("currentUser"));
        model.addAttribute("webAppDto",webAppDto);
        model.addAttribute("cssStyle","admin");
        return "admin/index";
    }
}
