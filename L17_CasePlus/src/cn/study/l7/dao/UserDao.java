package cn.study.l7.dao;

import cn.study.l7.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author Harlan
 * @date 2020/7/18 15:25
 */
public interface UserDao {

    /**
     * 查询所有用户信息
     * @return 用户信息
     */
    public List<User> findAll();

    /**
     * 查询用户
     * @param user 用户信息
     * @return 真实用户
     */
    public User login(User user);

    /**
     * 添加用户
     * @param user 用户
     */
    public void addUser(User user);

    /**
     * 删除用户
     * @param id
     */
    public void deleteUser(int id);

    /**
     * 通过id查询用户
     * @param id id
     * @return 用户信息
     */
    public User findUserById(int id);

    /**
     * 通过id查询用户更新信息
     * @param user 用户id
     */
    public void updateUser(User user);

    /**
     * 返回用户数据总条数
     * @return 条数
     * @param conditions
     */
    public int totalCount(Map<String, String[]> conditions);

    /**
     * 分页查询每页记录
     * @param start 开始索引
     * @param rows 条数
     * @param conditions
     * @return 查询的信息
     */
    public List<User> findByPage(int start, int rows, Map<String, String[]> conditions);
}
