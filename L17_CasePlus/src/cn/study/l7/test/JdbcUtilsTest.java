package cn.study.l7.test;

import cn.study.l7.dao.UserDao;
import cn.study.l7.dao.impl.UserDaoImpl;
import cn.study.l7.domain.User;
import org.junit.Test;

/**
 * @author Harlan
 * @date 2020/7/18 15:55
 */
public class JdbcUtilsTest {

    @org.junit.Test
    public void testLogin(){
        User userLogin = new User();
        userLogin.setUsername("admin");
        userLogin.setPassword("123456");

        UserDao userDao = new UserDaoImpl();
        User user = userDao.login(userLogin);
        System.out.println(user);
    }

    @org.junit.Test
    public void deleteUser() {
        UserDao userDao = new UserDaoImpl();
        userDao.deleteUser(17);
    }

    @Test
    public void finUserById(){
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.findUserById(1));
    }

    @Test
    public void updateUser(){
        UserDao userDao = new UserDaoImpl();
        User user = new User(2,"萧敬腾", "123456","萧敬腾","女", 11, "台湾","1234312","123123@qq.com");
        System.out.println(user);
        userDao.updateUser(user);
    }

    @Test
    public void totalCount(){
        UserDao userDao = new UserDaoImpl();
        int count = userDao.totalCount();
        System.out.println(count);
    }
}
