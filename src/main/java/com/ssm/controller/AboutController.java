package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.app.service.AboutService;
import com.ssm.app.service.WebAppService;

/**
 * Created by SuperS on 16/2/28.
 * 访客About页面
 */
@Controller
public class AboutController {
    @Autowired
    private AboutService aboutService;
    @Autowired
    private WebAppService webAppService;

    //显示about页面
    @RequestMapping("/about")
    public String aboutPage(ModelMap model){
        model.addAttribute("webAppDto",webAppService.getWebDtoWebApp(1));
        model.addAttribute("mainPage","layout/content/about/about.vm");
        if(aboutService.list().size() > 0) {
            model.addAttribute("about", aboutService.getAbout(aboutService.list().get(0).getId()));
        }
        return "index";
    }
}
