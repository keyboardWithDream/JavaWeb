package cn.study.l7.web.service;

import cn.study.l7.domain.User;

import java.util.List;

/**
 * @author Harlan
 * @date 2020/7/18 15:21
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return 用户List
     */
    public List<User> findAll();


    /**
     * 用户登录
     * @return 完整用户
     */
    public User login(User user);

    /**
     * 添加用户
     * @param user 用户
     */
    public void addUser(User user);

    /**
     * 删除用户
     * @param id 用户ID
     */
    public void deleteUser(int id);

    /**
     * 通过id查询用户
     * @param id 用户id
     * @return 用户信息
     */
    public User findUserById(int id);
}
