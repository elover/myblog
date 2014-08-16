package cn.myblog.service.impl;

import cn.myblog.dao.CategoryDao;
import cn.myblog.model.Category;
import cn.myblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nanwei on 14-7-5.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategory() {

        return categoryDao.getAllCategory();
    }

    @Override
    public Long getIdByName(String name) {
        return categoryDao.getIdByName(name);
    }
}
