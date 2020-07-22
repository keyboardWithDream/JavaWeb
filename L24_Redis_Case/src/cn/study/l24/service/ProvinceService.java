package cn.study.l24.service;

import cn.study.l24.domain.Province;

import java.util.List;

/**
 * @author Harlan
 * @date 2020/7/22 19:30
 */
public interface ProvinceService {

    /**
     * 查询所有城市
     * @return 所有城市的List
     */
    public List<Province> findAll();
}
