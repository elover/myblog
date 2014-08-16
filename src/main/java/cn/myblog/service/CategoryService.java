package cn.myblog.service;

import cn.myblog.model.Category;

import java.util.List;

/**
 * Created by nanwei on 14-7-5.
 */
public interface CategoryService {
    public List<Category> getAllCategory();
    public Long getIdByName(String name);
}
