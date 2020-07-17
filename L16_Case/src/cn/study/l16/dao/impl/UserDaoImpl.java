package cn.study.l16.dao.impl;

import cn.study.l16.dao.UserDao;
import cn.study.l16.domain.User;
import cn.study.l16.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Harlan
 * @date 2020/7/17 18:29
 */
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<User> selectAll() {
        //使用JDBC操作数据库
        String sql = "SELECT * FROM user";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public boolean insertUser(User user) {
        String sql = "INSERT INTO user (name, gender, age, address, qq , email) VALUES (\""+  user.getName() + "\" , \""+ user.getGender() + "\","+ user.getAge() +",\""+user.getAddress() +"\", \""+ user.getQq()+"\",\""+user.getEmail()+"\")";
        return template.update(sql) == 1;
    }
}
