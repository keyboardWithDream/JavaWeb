package cn.study.l24.service.impl;

import cn.study.l24.dao.impl.ProvinceDaoImpl;
import cn.study.l24.domain.Province;
import cn.study.l24.service.ProvinceService;

import java.util.List;

/**
 * @author Harlan
 * @date 2020/7/22 19:31
 */
public class ProvinceServiceImpl implements ProvinceService {
    @Override
    public List<Province> findAll() {
        ProvinceDaoImpl dao = new ProvinceDaoImpl();
        return dao.findAll();
    }
}
