package cn.study.l24.dao;

import cn.study.l24.domain.Province;

import java.util.List;

/**
 * @author Harlan
 * @date 2020/7/22 19:27
 */
public interface ProvinceDao {

    /**
     * 查询所有城市
     * @return 所有城市的List
     */
    public List<Province> findAll();
}
