package cn.study.l7.test;

import cn.study.l7.dao.UserDao;
import cn.study.l7.dao.impl.UserDaoImpl;
import cn.study.l7.domain.User;


/**
 * @author Harlan
 * @date 2020/7/18 16:05
 */
public class UserServiceTest {

    @org.junit.Test
    public User login(User user) {
        UserDao userDao = new UserDaoImpl();
        System.out.println(user);
        return userDao.login(user);
    }
}
