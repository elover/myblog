package cn.myblog.service;

import cn.myblog.model.Author;

import java.util.List;

/**
 * Created by nanwei on 14-8-3.
 */
public interface AuthorService {
    public List<Author> selectAllAuthor();
    public Author selectAuthorById(Long id);
    public String getPasswordByloginName(String loginName);
}
