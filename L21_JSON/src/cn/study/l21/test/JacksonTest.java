package cn.study.l21.test;

import cn.study.l21.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;


/**
 * @author Harlan
 * @date 2020/7/21 23:09
 */
public class JacksonTest {

    /**
     * Java对象转为Json字符串
     */
    @Test
    public void javaToJson() throws IOException {
        //创建Person对象
        Person p = new Person("张三", 22, "男");

        //1.创建Jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //2.调用方法转换
        /*
            转换方法：
                writeValue(参数1, obj)
                    参数1：
                        File：将obj对象转换为Json字符串，并保存在指定文件中
                        Writer：将obj对象转换为Json字符串，并将数据填充到字符输出流中
                        OutputStream：将obj对象转换为Json字符串，并将数据填充到字节输出流中
                writeValueAsString(obj) - 将对象转为json字符串
         */
        //{"name":"张三","age":22,"gender":"男"}
        String json = mapper.writeValueAsString(p);

        //将数据写到文件中
        mapper.writeValue(new File("E:\\Code\\JavaWeb\\L21_JSON\\src\\json.txt"), p);
    }


    /**
     * JSON字符串转换Java对象
     */
    @Test
    public void jsonToJava() throws IOException {
        String json = "{\"name\":\"张三\",\"age\":22,\"gender\":\"男\"}";
        //创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //调用Read相关方法
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }
}
