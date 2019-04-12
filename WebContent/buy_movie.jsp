<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">
	function load() {
		
		var movie = "";
	$.post("${pageContext.request.contextPath}/cus_DisplayMovieServlet",
				null, function(data) {
					if (data.length>0) {
						
						for (var i = 0; i < data.length; i++)
							movie +=("<a href='/TTMS/buy_DisplayMovieServlet?play_id="+data[i].play_id+"' >" + data[i].play_name
									+ "</a>&nbsp;&nbsp;&nbsp;&nbsp;")
					}

					$("#sp").html(movie);
				},
				"json");

	}
</script>

<style type="text/css">
#zhu {
	width: 100%;
	height: 100%;
}

#bt {
	height: 500px;
	background-image: url(img/11.jpg);
	color: #F0FFFF;
	background-size: 1480px;
	margin-bottom: 5 px;
} 	

#img {
	padding-left: 100px;
	width: 400px;
	height: 250px;
	float: left;
}

#span1 {
	width: 300px;
	height: 250px;
	float: left;
	color: #F0FFFF;
	font-size: 20px;
	padding-left: 20px;
}

#span2 {
	width: 400px;
	height: 250px;
	float: left;
	font-size: 20px;
	margin-left: 180px;
}

#xbt {
	height: 130px;
}

#cs {
	font-size:30px;
	padding-left: 350px; 
	margin-bottom: 20px;
}

#lj {
	color: #F0FFFF;
	height: 150px;
	font-size: 20px;
	text-align: center;
	background-color: black;
}
tbody tr th{
text-align：center;
font-size:25px;
}
a{ text-decoration: none;}
</style>
<script type="text/javascript" src="js/jquery.js" ></script>

<body onload="load()">
	<!--主屏-->
	<div id="zhu">
		<!--影院信息-->
		<div id="bt">
			<br />
			
			<marquee><span style="font-weight: bolder;font-size: 40px;color: white;">Welcom 52国际影城!</span></marquee>
             <c:if test="${empty user}">
			<a href="/TTMS/Custer_Login.jsp"
				style="font-size: 30px; color: #FF0000; margin-left: 1300px;">登录
			</a> 
			<a href="/TTMS/cus_sign.jsp"
				style="font-size: 30px; color: #FF0000; margin-left: 1300px;">注册
			</a> 
			<br /> 
			<br /> 
			<br />
			<br>
			</c:if>
			<c:if test="${!empty user}">
			<br>
			<br>
			<text style="font-size: 30px; color: #FF0000; margin-left:1100px;">
			你好，欢迎${user.usename}
			<div>
			<a href="/TTMS/outLogin"  style="font-size: 30px; color: #FF0000; margin-left:1100px;">用户注销</a>
		</div>
			</text>
			
			</c:if>
			<br>
			<br>
			<div id="img">
				<img src="img/timg.jpg" width="400px" height="250px" />

			</div>
			
			<div id="span1"> 
			<div>地理位置:西安邮电大学安美北楼1407</div>
			
			<div>电话号码：13529449192</div>
			
			
			<div>营业日期：9:00-21:00"</div>
			
			
			<div>影院信息</div>
			</div>
			<div id="span2">
				地理位置<br /> <br /> <img src="img/33c.jpg" width="350px"
					height="200px" />

			</div>
			
		</div>
		<!--小标题选择影片-->
		<div id="xbt">
			<div id="div1"
				style="padding-left: 10px; height: 50px; font-size: 25px;font-family:微软雅黑;text-align:center">
				今日影片：<br /><HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
				&nbsp;&nbsp;&nbsp;&nbsp;<span id="sp"></span>
				<hr>
			</div>


		</div>
		<!-- 展示-->
		<div style=" heigth:100px;">
		<h3 class="movie-name">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${movie.play_name}</h3>
		<img  alt="" src="${movie.play_image}" width="250px" height="300px" style="float: left;padding-left: 50px;">
		<div id="cs">
		<div>
       
        <span class="score sc">8.7</span>
     </div>
	<br>
     <div class="movie-desc">
      <div>
        <span class="key">时长 :</span>
        <span class="value">${movie.play_length}</span>
       </div>
      <div>
      <br>
        <span class="key">类型 :</span>
        <span class="value">${movie.dict_value} </span>
      </div>
          <div>
      <br>
        <span class="key">电影简介 :</span>
        <span class="value" style="width:600px;">${movie.play_introduction} </span>
      </div>
     </div>
    </div>
   
</div>


<table class="plist"  style="padding-left: 50px;border-collapse:collapse;border: 1px solid beige;margin: 0 auto;;width: 100%;">
  <tr style="background-color:aliceblue;height: 40px;" >
    <tr style="background-color:aquamarine;height: 60px; font-size:100px;">
      <th>放映时间</th>
      <th>语言版本</th>
      <th>放映厅</th>
      <th>售价（元）</th>
      <th>选座购票</th>
    </tr>
   

 <c:forEach items="${schedules}" var="sch"> 
  <tbody style="font-size:30px"  id="tbody">
  
    <tr style="background-color:khaki;height: 60px; ">
     <th width="30%">
        <span class="begin-time">${sch.sched_time}</span>
        <br>
        
      </th>
     <th>
        <span class="lang">${movie.dict_value1}</span>
      </th>
     <th>
        <span class="hall">${sch.studio_name}</span>
      </th>
     <th>
        <span class="sell-price"><span class="stonefont">${movie.play_ticket_price}</span></span>
      </th>
     <th>
   
     
       <a href="/TTMS/ifLogin?sched_id=${sch.sched_id}" style="font-size:30px; color:red;">选座购票</a>
          <br>
     
      </th>
    </tr>
    
    
    
    
	</tbody>
	</c:forEach> 
	</table>
	<br><br>
	
		
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>