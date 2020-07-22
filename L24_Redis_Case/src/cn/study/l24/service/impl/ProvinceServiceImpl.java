package cn.study.l24.service.impl;

import cn.study.l24.dao.impl.ProvinceDaoImpl;
import cn.study.l24.domain.Province;
import cn.study.l24.jedis.util.JedisPoolUtils;
import cn.study.l24.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import java.util.List;

/**
 * @author Harlan
 * @date 2020/7/22 19:31
 */
public class ProvinceServiceImpl implements ProvinceService {

    ProvinceDaoImpl dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");
        if (province_json == null || province_json.length() == 0){
            System.out.println("缓存中无数据...");
            List<Province> provinces = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(provinces);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",province_json);
            jedis.close();
        }else {
            System.out.println("缓存中有数据...");
        }
        return province_json;
    }
}
