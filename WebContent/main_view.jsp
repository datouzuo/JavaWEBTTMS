<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

        #lb{	
       
         	width: 100% ;
         	height: 400px;
         	background-image: url(img/02124258b87741212ec228d51f955f90_5746cc007c0af.jpg)
         	text-align: center;
         }
         #dl{
         	background-image: url(img/02124258b87741212ec228d51f955f90_5746cc007c0af.jpg)
         	width: 100%;
            color: #F0FFFF;
         	height: 60px;
         	text-align: center;
         }
          #gl{
         	background-image: url(img/02124258b87741212ec228d51f955f90_5746cc007c0af.jpg)
         	height: 10px;
         	color: red;
         	text-align: right;
         	text-align: end;
         	font-size:10px ;
         	margin-bottom: 10px;
         }
      a{ text-decoration: none;}
     </style>
     <script type="text/javascript">
     	function inti(){
     		setInterval("changone()",1500);
     	}
     	var i= 0;
     	function changone(){
     		i++;
     document.getElementById("one").src="img/view"+i+".jpg";
     document.getElementById("two").src="img/view"+(i+1)+".jpg";
     document.getElementById("three").src="img/view"+(i+2)+".jpg";
     
     	if(i==3){
     	i=0;
     	}
     	}
     	function changcoler(){
     		document.getElementById("dl").color="red";
     	}
     	
     	
     </script>
	<body onload="inti()">	

       <div>
       
       <jsp:include page="/head.jsp"></jsp:include>
       </div>
	
	   <div id="lb"><!--轮播图-->
	   	<img src="img/view1.jpg" width="32%" height="85%" id="one"/>&nbsp;&nbsp;
	 	<img src="img/view3.jpg" width="32%" height="85%" id="two"/>&nbsp;&nbsp;
	   	<img src="img/view5.jpg" width="32%" height="85%" id="three"/>
	   </div>
	   <div id="dl"  ><!--我要购票-->
	   	<a href="" ><button style="border-radius: 12px;background-color: red;width: 150px;height: 50px;border: 0px;"><font color="white">取消订单我要购票返回影我要购票我要购票come in</font>进入我我我我我我我我我《《《《，进入进进入在在在的说法的奋斗反对</button></a>
	   </div>
	   <div id="gl" ><!--管理员登录-->
	    <a href="${pageContext.request.contextPath }/movie_view" id="aa">管理员登录</a>  	
	    </div>
	      <div>
       
       <jsp:include page="/footer.jsp"></jsp:include>
       </div>
	</body>
</html>