package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.app.service.ArticleService;
import com.ssm.app.service.CategoryService;
import com.ssm.app.service.WebAppService;
import com.ssm.bean.Category;
import com.ssm.bean.dto.ArticleLiteDto;
import com.ssm.bean.dto.CategoryDto;
import com.ssm.utils.StringUtil;

/**
 * Created by SuperS on 16/2/28.
 * 访客 分类页面
 */
@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private WebAppService webAppService;


    //全部list
    @RequestMapping("list")
    public String list(ModelMap model) {
        model.addAttribute("webAppDto",webAppService.getWebDtoWebApp(1));
        List<CategoryDto> categories = categoryService.getCategories();
        model.addAttribute("mainPage", "layout/content/category/categoryList.vm");
        model.addAttribute("categories", categories);
        return "index";
    }

    //详情
    @RequestMapping("{categoryId:[0-9]+}")
    public String detail(@PathVariable("categoryId") Integer categoryId, ModelMap model) {
        model.addAttribute("webAppDto",webAppService.getWebDtoWebApp(1));

        Category category = categoryService.getCategory(categoryId);
        model.addAttribute("mainPage", "layout/content/category/detail.vm");
        if (StringUtil.isNotEmpty(category.getName())) {
            List<ArticleLiteDto> articles = articleService.getArticlesByCategory(categoryId);
            if (articles.size() == 0) {
                articles = null;
            }
            model.addAttribute("category", category);
            model.addAttribute("articles", articles);
        } else {
            model.addAttribute("error", "找不到该分类");
        }
        return "index";
    }


}
