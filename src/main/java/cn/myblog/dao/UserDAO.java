package cn.myblog.dao;

import cn.myblog.model.User;


public interface UserDAO {

    /**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertUser(User user);


}
