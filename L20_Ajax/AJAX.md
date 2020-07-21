# AJAX
> 概念： ASynchronous JavaScript And XML	异步的JavaScript 和 XML
>
> > 异步和同步：客户端和服务器端相互通信的基础上
> > 同步: 客户端必须等待服务器端的响应。在等待的期间客户端不能做其他操作。
> > 异步: 客户端不需要等待服务器端的响应。在服务器处理请求的过程中，客户端可以进行其他的操作。
>
> Ajax 是一种在无需重新加载整个网页的情况下，能够更新部分网页的技术
> 通过在后台与服务器进行少量数据交换，Ajax 可以使网页实现异步更新。这意味着可以在不重新加载整个网页的情况下，对网页的某部分进行更新。
> 传统的网页（不使用 Ajax）如果需要更新内容，必须重载整个网页页面。

* * *

1. 实现方式：
	1. 原生的JS实现方式(了解)
		
		```javascript
		//1.创建核心对象
		var xmlhttp;
		if (window.XMLHttpRequest){
		    // code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp=new XMLHttpRequest();
		}else{
		    // code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
				
		//2. 建立连接
			/*
			参数：
			1. 请求方式：GET、POST
				* get方式，请求参数在URL后边拼接。send方法为空参
				* post方式，请求参数在send方法中定义
			2. 请求的URL：
			3. 同步或异步请求：true（异步）或 false（同步）
			*/
		xmlhttp.open("GET","ajaxServlet?username=tom",true);
		
		//3.发送请求
		xmlhttp.send();
			
		//4.接受并处理来自服务器的响应结果
		//获取方式 ：xmlhttp.responseText
		 //什么时候获取？当服务器响应成功后再获取
		//当xmlhttp对象的就绪状态改变时，触发事件onreadystatechange。
		xmlhttp.onreadystatechange=function(){
			//判断readyState就绪状态是否为4，判断status响应状态码是否为200
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				//获取服务器的响应结果
				var responseText = xmlhttp.responseText;
				alert(responseText);
				}
			}
		```
		
		
	
2. JQuery实现方式
	1. $.ajax()
		* 语法：`$.ajax({键值对});`
			
			```javascript
			//使用$.ajax()发送异步请求
			$.ajax({
				url:"ajaxServlet1111" , // 请求路径
				type:"POST" , //请求方式
				//data: "username=jack&age=23",//请求参数
				data:{"username":"jack","age":23},
				success:function (data) {//响应成功后的回调函数
					 alert(data);
				},
				error:function () {//表示如果请求响应出现错误，会执行的回调函数
					alert("出错啦...")
				},
				dataType:"text"//设置接受到的响应数据的格式
			});
			```
			
			
		
	2. $.get()：发送get请求
		* 语法：`$.get(url, [data], [callback], [type])`
			* 参数：
				* url：请求路径
				* data：请求参数
				* callback：回调函数
				* type：响应结果的类型
		
		```javascript
		$.get("ajaxServlet",{username:"Harlan"},function (data) {
		    alert(data);
		},"text/html");
		```
		
		
		
	3. $.post()：发送post请求
		* 语法：`$.post(url, [data], [callback], [type])`
			* 参数：
				* url：请求路径
				* data：请求参数
				* callback：回调函数
				* type：响应结果的类型
		
		```javascript
		$.post("ajaxServlet",{username:"Harlan"},function (data) {
		    alert(data);
		},"text/html");
		```
		
		