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