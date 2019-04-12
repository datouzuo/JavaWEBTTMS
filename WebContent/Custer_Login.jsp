<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
 #log{
           
         	background-image:  url(img/11.jpg);;
         	background-size:1000px 600px;
         	height: 430px;
         	
         	padding-left: 800px;
         	padding-top: 40px;
         	 margin-bottom: 20px;
         }
         </style>
 <script type="text/javascript">
 
	function check(){
		 
		document.getElementById("che").src="/TTMS/checkImage?"+Math.random();
		
	}
 
 </script>        
         
         
<body>
<div>
<jsp:include page="head.jsp"></jsp:include>
</div>
<div id="log">
				<form action="/TTMS/custer_LoginServlet" method="post" id="aform">
				<table border="0px" cellspacing="0" cellpadding="0"  bgcolor="white" style="border: 5px solid burlywood">
					<tr height="100px">
						<th width="450px" colspan="2" style="font-size: 50px;">用户登录
						<div style="color:red;  font-size:20px; " >${error}</div>
						</th>
						
					</tr>
					<tr height="50px">
						<th  width="100px" style="font-size: 25px;">用户：</th>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" size="30" style="height:30px "  name="usename" id="usename"/>
						</td>
					</tr>
					<tr  height="50px">
					<th  width="100px" style="font-size: 25px;">密码:</th>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="password" size="30" style="height:30px "  name="password" id="password"/>
					</td>
				
					</tr>
					<tr  height="50px">
					<th  width="100px" style="font-size: 25px;">验证码 </th>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="text" size="15" style="height:30px "  name="checkimg" id="password" />
						<img src="/TTMS/checkImage" onclick="check()" id="che">
					</td>
				
					</tr>
					<tr height="50px">
                    <th colspan="2"> <input type="submit" size="30"  value="登录" /></th>
						
					</tr>
					
				<!-- <tr>
					    <th  width="100px" style="font-size: 15px;">
					<input type="checkbox" name="object" value="object" >自动登录
					    </th>
					</tr>	 -->			
					</table>
				<div style="color:white;"><input type="checkbox" name="object" value="object" style="color:white;">自动登录</div>
					</form>	
			</div>

<div>
<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>