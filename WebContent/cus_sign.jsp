<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	 <style type="text/css">
		 	
		 
		
	
         #sign{
         	 padding-top: 25px;
         	height: 520px;
         	margin-bottom: 20px;
         	background-image: url(img/titleview.jpg);
         	background-size:1000px 600px;
         	
         }
       
         #sign table{
         	margin-top: 30px;
         	border: 5px solid gray;
				width: 550px;
				height: 450px;
                margin-left: 700px;
         	
         }
         label.error{
				background:url(img/unchecked.gif) no-repeat 10px 3px;
				padding-left: 30px;
				font-family:georgia;
				font-size: 15px;
				font-style: normal;
				color: red;
			}
			
			label.success{
				background:url(img/checked.gif) no-repeat 10px 3px;
				padding-left: 30px;
			}

		
		</style>
		<script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
		<!--引入validate插件js文件-->
		<script type="text/javascript" src="js/jquery.validate.min.js" ></script>
		<!--引入国际化js文件-->
		<script type="text/javascript" src="js/messages_zh.js" ></script>	<script>
		
		
		function check(){
			 
			document.getElementById("che").src="/TTMS/checkImage?"+Math.random();
			
		}
		
		
		$.validator.addMethod(
				//规则的名称
				"checkUsername",
				//校验的函数
				function(value,element,params){
					
					//定义一个标志
					var flag = false;
					
					//value:输入的内容
					//element:被校验的元素对象
					//params：规则对应的参数值
					//目的：对输入的username进行ajax校验
					$.ajax({
						"async":false,
						"url":"${pageContext.request.contextPath}/checkUsername",
						"data":{"usename":value},
						"type":"POST",
						"dataType":"json",
						"success":function(data){
							flag = data.isExist;
						}
					});
					
					
					//返回false代表该校验器不通过
					return !flag;
				}
				
			);

		
		
		
			$(function(){
				$("#registForm").validate({
					rules:{
						usename:{
							required:true,
							"checkUsername":true,
							minlength:3
							
						},
						password:{
							required:true,
							digits:true,
							minlength:6
						},
						repassword:{
							required:true,
							equalTo:"[name='password']"
						},
						email:{
							required:true,
							email:true
						},
						username:{
							required:true,
							maxlength:5
						},
						sex:{
							required:true
						}
					},
					messages:{
						usename:{
							required:"用户名不能为空!",
							minlength:"用户名不得少于3位!",
							"checkUsername":"用户名已存在!"
						},
						password:{
							required:"密码不能为空!",
							digits:"密码必须是整数!",
							minlength:"密码不得少于6位!"
						},
						repassword:{
							required:"确认密码不能为空!",
							equalTo:"两次输入密码不一致!"
						},
						email:{
							required:"邮箱不能为空!",
							email:"邮箱格式不正确!"
						},
						username:{
							required:"姓名不能为空!",
							maxlength:"姓名不得多于5位!"
						},
						sex:{
							required:"性别必须勾选!"
						}
					},
					errorElement: "label", //用来创建错误提示信息标签,validate插件默认的就是label
					success: function(label) { //验证成功后的执行的回调函数
						//label指向上面那个错误提示信息标签label
						label.text(" ") //清空错误提示消息
							.addClass("success"); //加上自定义的success类
					}
				});
			});
		/*	$(function){
			$("suc").success(
				{
				alter("注册成功");
				}
			)
		}*/
		
		
		
		
		
		
		</script>
		
		
		
	</head>
<body>
<body>

		<!--整个面板 -->
		<div id="zhu">
				<jsp:include page="head.jsp"></jsp:include>
			 <!-- 注册表单-->
			 <form action="/TTMS/sign_Servlet" method="post" id="registForm">
			  <div id="sign">
			  	<table  border="0px" width="100%" height="100%" align="center" cellpadding="0px" cellspacing="0px" bgcolor="white">
								<tr>
									<td colspan="2" >
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<font size="5">用户注册</font>&nbsp;&nbsp;&nbsp; 
										<div style="color:red;  font-size:20px; " >${error}</div>
									</td>
								</tr>
								<tr>
									<td width="180px">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;
										<label for="user" >用户名</label>
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="text" name="usename" size="35px" id="usename"/>
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										密码
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="password"  name="password" size="35px" id="password" />
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										确认密码
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="password" name="repassword" size="35px"/>
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										Email
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="text" name="email" size="35px" id="email"/>
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										姓名
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="text" name="name" size="35px"/>
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										性别
									</td>
									<td>
										<span style="margin-right: 155px;">
											<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="男"/>男
											<input type="radio" name="sex" value="女"/>女<em></em>
											<label for="sex" class="error" style="display: none;"></label>
										</span>
										
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										出生日期
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="text" name="briday"  size="35px"/>
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;
										验证码
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="text" name="checkimg" />
										<img src="/TTMS/checkImage" style="height: 25px;width: 85px;" onclick="check()" id="che" />
									</td>
								</tr>
								<tr>
									<td colspan="2">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										
										<input type="submit" value="注      册" height="50px" id="suc"/>
									</td>
								</tr>
							</table>

			  </div>
			  </form>
		<jsp:include page="footer.jsp"></jsp:include>
		</div>

</body>
</html>