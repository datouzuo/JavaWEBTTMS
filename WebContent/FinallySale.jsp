<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 <script type="text/javascript">   
/* 
function load(){
	alert("12"); */
	 var price=${play.play_ticket_price};   
	
/* var num="${fn:length(seat) }";  
	  document.getElementById("price1").innerHTML="zlw";
 var sumprice=parseInt(price)*parseInt(num); 
	document.getElementById("price1").innerHTML="zlw";
	document.getElementById("price2").innerHTML="实付款：&yen;"+sumprice;   */

	 function on(){
		location.href="${pageContext.request.contextPath}/OutTicketServlet";}  	

 function onc(){
	location.href="${pageContext.request.contextPath}/buyticket";}  
	 var maxtime = 60 * 5; //一个小时，按秒计算，自己调整!   
	function CountDown() {
	    if (maxtime >= 0) {
	        minutes = Math.floor(maxtime / 60);
	        seconds = Math.floor(maxtime % 60);
	        msg = "锁票时间还剩下" + minutes + "分" + seconds + "秒";
	        document.all["timer"].innerHTML = msg+"请勿刷新网页";
	        if (maxtime == 5*60)alert("注意：锁票只有五分钟购票中请勿刷新网页");
	            --maxtime;
	    } else{
	        clearInterval(timer);
	        alert("时间超时，购票失败");
	    }
	}
	timer = setInterval("CountDown()", 1000); 
	

                        
</script>
</head>
<style type="text/css">
		#bt{
					
  
       	height: 70px;
       	color: #F0FFFF;
     	font-size: 35px;
     	font-family: "bodoni mt";
       	padding-top: 25px;
     	padding-left: 60px;
     	margin-bottom: 20px;
     	background-image: url(../img/titleview2.jpg);
         }
         </style>
<body onload="load()" >
<div id="bt"><!--标题-->
	  	  欢迎来到52号电影院
	    </div>
	
	 <%  request.getSession().setAttribute("ticket", request.getAttribute("ticket"));
		
	 %> 
	<hr />
		<table style="border: 1;margin: 0 auto;margin: 0 auto;width: 750px;height: 100%;">
			<tr>
				<td align="right";colspan="5">
				<div id="timer" style="color:red"></div>
				<div id="warring" style="color:red"></div>
				</td>
			</tr>
			</table>
		<table style="border-collapse:collapse;border: 1px solid beige;text-align: center;margin: 0 auto;height: 350px;width: 1200px;">
			<tr style="background-color:aliceblue;height: 70px;">
				<th style="border: 1px solid beige;font-size:30px;font-family: '楷体';">电影</th>
				<th style="border: 1px solid beige;font-size:30px;font-family: '楷体';">场次</th>
				<th style="border: 1px solid beige;font-size:30px;font-family: '楷体';">票数/座位</th>
				<th style="border: 1px solid beige;font-size:30px;font-family: '楷体';">金额小计</th>
				<th style="border: 1px solid beige;font-size:30px;font-family: '楷体';">接收电子码的电子邮</th>
			</tr>
			<tr height="100%">
				<td style="border: 1px solid beige">
					<table border="0">
						<tr>
							<td><img src="${play.play_image}" height="200px" weight="120px"/></td>
							<td style="1px solid beige">
								<font style="font-weight:600;font-family:'新宋体'">${play.play_name}</font><br>
								<font style="font-family: '仿宋';font-size: small">时长:${play.play_length}分钟</font>
		
							</td>
						</tr>
					</table>
				</td>
				<td style="border: 1px solid beige">
								<p style="font-family:'仿宋';">52号影院</p>
								<p style="font-family:'仿宋';">${studio.studio_name}</p>
								<p><font color="red">${schedule.sched_time}</font></p>
						</td>
				<td style="border: 1px solid beige">
								<p>${fn:length(tickID)}张</p>
								<c:forEach items="${seat}" var="s">
									<table style="border-collapse:collapse;border: 1px solid beige;text-align: center;margin: 0 auto;">
										<tr><td><font color=darkgray>${s.seat_row }排${s.seat_column }列</font></td></tr>
									</table>
									<br />
								</c:forEach>
								
				</td>
				<td id="price1" style="border: 1px solid beige"><font   color="red">${sale}元</font></td>
				<td style="border: 1px solid beige">${user.email }箱<div style="color:red; font-size:10px;"
				
				>购买票后将发送电子码到该邮箱
				</div></td>
			</tr>
		</table>
		<table style="border: 1;margin: 0 auto;margin: 0 auto;width: 750px;height: 150px;">
			<tr><td id="price2" align="right";colspan="5"><font style="color: red;font-weight: 700;font-size:larger"></font></td></tr>
			<tr>
			<td align="right";colspan="5"><button  id="sub" style="border-radius: 12px;background-color: red;width: 150px;height: 50px;border: 0px;" onclick="on()"><font color="white">取消订单，返回影院</font></button></td>
			<td align="right";colspan="5"><button  id="sub" style="border-radius: 12px;background-color: red;width: 150px;height: 50px;border: 0px;" onclick="onc()"><font color="white">确认订单，立即支付</font></button></td></tr>
		</table>
		
		
</body>
</html>