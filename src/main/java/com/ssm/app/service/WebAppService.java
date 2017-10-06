package com.ssm.app.service;

import java.util.List;

import com.ssm.bean.WebApp;
import com.ssm.bean.dto.WebAppDto;

/**
 * Created by SuperS on 16/3/16.
 */
public interface WebAppService {
    public void saveWebApp(WebApp webApp);
    public void updateWebApp(WebApp webApp);
    public WebAppDto getWebDtoWebApp(Integer id);
    public Integer getArticlesView();
    public boolean webAppNotNull();
    public List<WebApp> getWebAppDtos();
}
