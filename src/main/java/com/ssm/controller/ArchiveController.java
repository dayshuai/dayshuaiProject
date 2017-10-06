package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssm.app.service.ArticleService;
import com.ssm.app.service.WebAppService;
import com.ssm.bean.dto.ArticleLiteDto;

/**
 * Created by SuperS on 16/2/28.
 * 访客 归档页面
 */
@Controller
@RequestMapping("archive")
public class ArchiveController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private WebAppService webAppService;
     //显示归档页面
    @RequestMapping(method = RequestMethod.GET)
    public String archive(ModelMap model){
        List<ArticleLiteDto> articleLiteDtos = articleService.getArchive();
        model.addAttribute("webAppDto",webAppService.getWebDtoWebApp(1));
        model.addAttribute("articles", articleLiteDtos);
        model.addAttribute("mainPage", "layout/content/archive/detail.vm");
        return "index";
    }
}
