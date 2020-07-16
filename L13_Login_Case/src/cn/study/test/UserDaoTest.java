package cn.study.test;

import cn.study.dao.UserDao;
import cn.study.domain.User;
import org.junit.Test;

/**
 * 测试类
 * @author Harlan
 * @date 2020/7/14 0:57
 */
public class UserDaoTest {

    @Test
    public void testLogin(){
        User userLogin = new User();
        userLogin.setUsername("admin");
        userLogin.setPassword("123456");

        UserDao userDao = new UserDao();
        User user = userDao.login(userLogin);
        System.out.println(user);
    }
}
