package cn.myblog.dao;

import cn.myblog.model.Category;

import java.util.List;

/**
 * Created by nanwei on 14-7-5.
 */
public interface CategoryDao {
    /**
     * 获取所有类别
     */
    public List<Category> getAllCategory();

    public Long getIdByName(String name);
}
