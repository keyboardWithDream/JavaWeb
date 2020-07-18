package cn.study.l7.dao.impl;

import cn.study.l7.dao.UserDao;
import cn.study.l7.domain.User;
import cn.study.l7.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Harlan
 * @date 2020/7/18 15:29
 */
public class UserDaoImpl implements UserDao {

    JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User login(User loginUser) {
        try{
            //编写sql
            String sql = "SELECT * FROM USER WHERE username = ? and password = ?";
            //调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),loginUser.getPassword());
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
