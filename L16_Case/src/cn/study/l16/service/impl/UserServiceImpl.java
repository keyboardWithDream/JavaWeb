package cn.study.l16.service.impl;

import cn.study.l16.dao.UserDao;
import cn.study.l16.dao.impl.UserDaoImpl;
import cn.study.l16.domain.User;
import cn.study.l16.service.UserService;

import java.util.List;

/**
 * @author Harlan
 * @date 2020/7/17 18:25
 */
public class UserServiceImpl implements UserService {

    private final UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.selectAll();
    }

    @Override
    public boolean insertUser(User user) {
       return dao.insertUser(user);
    }

}
