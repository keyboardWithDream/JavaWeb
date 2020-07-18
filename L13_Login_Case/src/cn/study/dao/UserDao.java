package cn.study.dao;

import cn.study.domain.User;
import cn.study.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中USER表的类
 * @author Harlan
 * @date 2020/7/14 0:43
 */
public class UserDao {

    /**
     * 声明JdbcTemplate公用
     */
    private final JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user包含所有的用户信息
     */
    public User login(User loginUser){
        try{
            //编写sql
            String sql = "SELECT * FROM USER WHERE username = ? and password = ?";
            //调用query方法
            var user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
