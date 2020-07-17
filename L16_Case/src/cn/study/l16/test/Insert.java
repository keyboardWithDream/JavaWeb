package cn.study.l16.test;

import cn.study.l16.dao.UserDao;
import cn.study.l16.dao.impl.UserDaoImpl;
import cn.study.l16.domain.User;
import org.junit.Test;

/**
 * @author Harlan
 * @date 2020/7/17 21:29
 */
public class Insert {

    @Test
    public void insertDao(){
        User user = new User(0, "name", "男", 12,"重庆","123123","123123");
        UserDao userDao = new UserDaoImpl();
        boolean flag = userDao.insertUser(user);
        System.out.println(flag);
    }
}
