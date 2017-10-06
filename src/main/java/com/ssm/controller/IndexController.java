package com.ssm.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssm.app.service.ArticleService;
import com.ssm.app.service.WebAppService;
import com.ssm.utils.Pager;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private ArticleService articleService;

	@Autowired
	private WebAppService webAppService;

	@RequestMapping(value = "hello")
	public Map<String, Object> login(HttpSession session, ModelMap modelMap, String usercode, String password)
			throws Exception {
		System.out.println("hello function");

		return modelMap;
	}

	@RequestMapping(value = "index")
	public String index(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex, ModelMap modelMap)
			throws Exception {
		String link = "index";
		if (webAppService.getWebAppDtos().size() == 0) {
			link = "redirect:/init";
		} else {
			Pager pager = new Pager(pageIndex, webAppService.getWebDtoWebApp(1).getUserPageArticleSize(),
					articleService.count());
			modelMap.addAttribute("mainPage", "layout/content/article/articlelist.vm");
			modelMap.addAttribute("webAppDto", webAppService.getWebDtoWebApp(1));
			modelMap.addAttribute("articles", articleService.getPageArticles(pager));
			modelMap.addAttribute("pager", pager);
		}
		return link;
	}
}
