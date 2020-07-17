package cn.study.l16.dao;

import cn.study.l16.domain.User;

import java.util.List;

/**
 * 用户操作的Dao
 * @author Harlan
 * @date 2020/7/17 18:27
 */
public interface UserDao {

    /**
     * 查询所有用户信息
     * @return 用户信息LIST
     */
    public List<User> selectAll();

    /**
     * 添加用户
     * @param user 用户
     * @return 用户信息List
     */
    public boolean insertUser(User user);
}
