package cn.study.l16.service;

import cn.study.l16.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 * @author Harlan
 * @date 2020/7/17 18:23
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return 用户信息List
     */
    public List<User> findAll();

    /**
     * 添加用户
     * @param user 用户
     * @return 是否成功添加
     */
    public boolean insertUser(User user);
}
