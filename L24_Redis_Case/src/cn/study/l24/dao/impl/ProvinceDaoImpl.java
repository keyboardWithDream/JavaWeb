package cn.study.l24.dao.impl;

import cn.study.l24.dao.ProvinceDao;
import cn.study.l24.domain.Province;
import cn.study.l24.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

/**
 * @author Harlan
 * @date 2020/7/22 19:29
 */
public class ProvinceDaoImpl implements ProvinceDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        String sql = "SELECT * FROM province";
        return template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
    }
}
