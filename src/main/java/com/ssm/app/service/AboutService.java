package com.ssm.app.service;

import java.util.List;

import com.ssm.bean.About;
/**
 * Created by SuperS on 16/1/7.
 */
public interface AboutService {
    public About getAbout(Integer id);
    public void upDate(About about);
    public void save(About about);
    public void delete(Integer id);
    public int count();
    public List<About> list();
}
