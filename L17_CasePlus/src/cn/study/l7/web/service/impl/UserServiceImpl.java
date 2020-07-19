package cn.study.l7.web.service.impl;

import cn.study.l7.dao.UserDao;
import cn.study.l7.dao.impl.UserDaoImpl;
import cn.study.l7.domain.Page;
import cn.study.l7.domain.User;
import cn.study.l7.web.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author Harlan
 * @date 2020/7/18 15:23
 */
public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAll() {
        UserDao userDao = new UserDaoImpl();
        return userDao.findAll();
    }

    @Override
    public User login(User user) {
        UserDao userDao = new UserDaoImpl();
        System.out.println(user);
        return userDao.login(user);
    }

    @Override
    public void addUser(User user) {
        UserDao userDao = new UserDaoImpl();
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        UserDao userDao = new UserDaoImpl();
        userDao.deleteUser(id);
    }

    @Override
    public User findUserById(int id) {
        UserDao userDao = new UserDaoImpl();
        return userDao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        UserDao userDao = new UserDaoImpl();
        userDao.updateUser(user);
    }

    @Override
    public void delUsers(String[] ids) {
        UserDao userDao = new UserDaoImpl();
        for (String id : ids) {
            userDao.deleteUser(Integer.parseInt(id));
        }
    }

    @Override
    public Page<User> findUsersByPage(String _currentPage, String _rows, Map<String, String[]> conditions) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        Page<User> userPage = new Page<>();
        userPage.setCurrentPage(currentPage);
        userPage.setRows(rows);

        UserDao userDao = new UserDaoImpl();

        int totalCount = userDao.totalCount(conditions);
        userPage.setTotalCount(totalCount);

        int start = (currentPage - 1) * rows;
        List<User> userList = userDao.findByPage(start, rows, conditions);
        System.out.println(userList);
        userPage.setList(userList);

        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows + 1);
        userPage.setTotalPage(totalPage);

        return userPage;
    }

}
