package cn.study.l24.test;

import cn.study.l24.dao.ProvinceDao;
import cn.study.l24.dao.impl.ProvinceDaoImpl;
import cn.study.l24.domain.Province;

import java.util.List;

/**
 * @author Harlan
 * @date 2020/7/22 19:40
 */
public class DaoTest {

    @org.junit.Test
    public void findAllTest(){
        ProvinceDao dao = new ProvinceDaoImpl();
        List<Province> provinces = dao.findAll();
        System.out.println(provinces);
    }
}
