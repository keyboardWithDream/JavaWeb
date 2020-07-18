package cn.study.l7.web.service.impl;

import cn.study.l7.dao.UserDao;
import cn.study.l7.dao.impl.UserDaoImpl;
import cn.study.l7.domain.User;
import cn.study.l7.web.service.UserService;

import java.util.List;

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

}
