package cn.myblog.service.impl;

import cn.myblog.dao.AuthorDao;
import cn.myblog.model.Author;
import cn.myblog.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nanwei on 14-8-3.
 */
@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorDao authorDao;

    @Override
    public List<Author> selectAllAuthor() {
        return authorDao.selectAllAuthor();
    }

    @Override
    public Author selectAuthorById(Long id) {
        return authorDao.selectAuthorById(id);
    }

    @Override
    public String getPasswordByloginName(String loginName) {
        return authorDao.getPasswordByloginName(loginName);
    }
}
