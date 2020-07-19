package cn.study.l7.dao.impl;

import cn.study.l7.dao.UserDao;
import cn.study.l7.domain.User;
import cn.study.l7.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Harlan
 * @date 2020/7/18 15:29
 */
public class UserDaoImpl implements UserDao {

    JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库
        String sql = "SELECT * FROM user";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
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

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO user VALUES(null,?,?,?,?,?,?,?,?)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getUsername(),user.getPassword());
    }

    @Override
    public void deleteUser(int id) {
        String sql = "DELETE FROM user WHERE id = ?";
        template.update(sql, id);
    }

    @Override
    public User findUserById(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE user SET name = ?, gender = ?, age = ?, address = ?, qq = ? ,email = ? WHERE id = ?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public int totalCount(Map<String, String[]> conditions) {
        String sql = "SELECT COUNT(*) FROM user WHERE 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> params = new ArrayList<>();
        for (String key : conditions.keySet()) {
            String value = conditions.get(key)[0];
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            if (value != null && !"".equals(value)){
                sb.append(" AND " + key + " LIKE ?");
                params.add("%"+value+"%");
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);
        return template.queryForObject(sb.toString() , Integer.class, params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> conditions) {
        String sql = "SELECT * FROM user WHERE 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> params = new ArrayList<>();
        for (String key : conditions.keySet()) {
            String value = conditions.get(key)[0];
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            if (value != null && !"".equals(value)){
                sb.append(" AND " + key + " LIKE ?");
                params.add("%"+value+"%");
            }
        }
        sb.append(" LIMIT ? , ?");
        params.add(start);
        params.add(rows);
        return template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}
