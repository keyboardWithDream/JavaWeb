# JSON

> JavaScript Object Notation - JavaScript对象表示法
>
> JSON 多用于存储和交换文本信息的语法, 类似XML
>
> JSON 比 XML 更小, 更快, 更容易解析

***

1. 语法

   1. 基本规则
      * 数据在名称 / 值对中 : json数据是由键值对构成的
      * 数据由逗号分隔
      * 花括号保存对象
      * 方括号保存数组

   ```json
   //1.定义Json
   const person = {"name":"张三", "age":23, "gender":true};
   alert(person);
   //2.嵌套格式
   const persons = {
       "person":[
           {"name":"张三", "age":23, "gender":true},
           {"name":"李四", "age":21, "gender":true},
           {"name":"王五", "age":20, "gender":false}
       ]
   };
   alert(persons);
   ```

   

2. 获取数据

   1. `json对象.键名`
   2. `json对象["键名"]`
   3. `数组对象[索引]`

   ```json
   //1.定义Json
   const person = {"name":"张三", "age":23, "gender":true};
   
   //遍历
   for (let key in  person){
   	document.write(person[key]+"<br>");
   }
   
   document.write("<hr>");
   
   //2.嵌套格式
   const persons = {
   	"person":[
   		{"name":"张三", "age":23, "gender":true},
   		{"name":"李四", "age":21, "gender":true},
   		{"name":"王五", "age":20, "gender":false}
   		]
   };
   
   //遍历
   for (let key in persons.person){
   	document.write(persons.person[key].name + "<br>");
   }
   ```



3. JSON数据和Java对象的相互转换

   * JSON解析器
     * 常见解析器: Jsonlib, Gson, fastjson, jackson(Spring MVC默认json解析器)
     * 使用步骤
       1. 导入`jackson`的jar包 - https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
       2. 创建Jackson核心对象 `ObjectMapper`
       3. 调用`ObjectMapper`的相关方法进行转换

   1. JSON对象 -> Java对象：Read相关方法

      

   2. Java对象 -> JSON对象：Write相关方法

      1. 注解：
         1. `@JsonIgnore`：排除属性
         2. `@JsonFormat`：属性值格式化
      2. 复杂的Java对象的转换
         1. List：Json数组
         2. Map：Json键值对

      ```java
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
      }
      ```

      

      