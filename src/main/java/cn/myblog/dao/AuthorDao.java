package cn.myblog.dao;

import cn.myblog.model.Author;

import java.util.List;

/**
 * Created by nanwei on 14-7-12.
 */
public interface AuthorDao {
    public List<Author> selectAllAuthor();
    public Author selectAuthorById(Long id);
    public String getPasswordByloginName(String loginName);
}
