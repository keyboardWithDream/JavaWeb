package cn.study.l7.test;

import cn.study.l7.dao.UserDao;
import cn.study.l7.dao.impl.UserDaoImpl;
import cn.study.l7.domain.User;

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
}
