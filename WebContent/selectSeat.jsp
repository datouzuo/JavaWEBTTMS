<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择座位</title>
<style type="text/css">
	#selectseat{
        height: 500px;
        width: 50%;
		float: left;
		font-size: 30px;
	}
	#seat{
		margin: auto;
		width: 530px;
		height: 300px;
	}
	.seat_sale{
		height: 50px;
        width: 50px;
		background-image: url("${pageContext.request.contextPath }/image/seat_sale.png");		
		background-repeat:no-repeat;
		background-size: 35px; 
	}
	.seated{
		height: 50px;
        width: 50px;
		background-image: url("${pageContext.request.contextPath }/image/seat.png");		
		background-repeat:no-repeat;
		background-size: 35px; 
		
	}
	.onseat{
		height: 50px;
        width: 50px;
		background-image: url("${pageContext.request.contextPath }/image/onseat.png");		
		background-repeat:no-repeat; 
		background-size: 35px;
	}
	#movie{
		height: 380px;
        width: 40%;
		margin-top: 30px;
		margin-left: 10px;
		float: left;
		font-size: 25px;
		
	}
	.info{
		margin-top: 50px;
	}
	.color{		
		color: red;
	} 
}
	
</style>




</head>


<body>

<jsp:include page="head.jsp"></jsp:include>
<div id="selectseat">
	<h1 style="text-align: center">
		${stu.studio_name }
	</h1>
	<table border="0" id="seat">
		<c:forEach var="i" begin="1" end="${stu.studio_row_Count}" step="1">
			<tr>
				<td  >第${i }排</td>
				<c:forEach var="j" begin="1" end="${stu.studio_col_Count }" step="1">
					<td class="seated" id="${i }排${j }列"	>						
					</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<div style="text-align: center">
		<img alt="" src="${pageContext.request.contextPath }/image/seat.png">可选座位
		<img alt="" src="${pageContext.request.contextPath }/image/onseat.png">已选座位
		<img alt="" src="${pageContext.request.contextPath }/image/seat_sale.png">不可选座位
	</div>
</div>

<div id="movie"> 
	<div ">
		<div style="float: left; ">
			<img style="height: 140px;width: 100px;" alt="" src="${play.play_image} ">
		</div>
		<div style="float: left; font: 20px/1.5 tahoma,arial,'Hiragino Sans GB','\5b8b\4f53',sans-serif">
			<span >${play.play_name}<span><br/>
			<span >片长：${play.play_length}</span><br/>
			<span  >简介：${play.play_introduction}</span>
		</div>
		<div style="clear: both;"></div>
	</div>
	<div ">
		<table>
			<tr>
				<td>影院：</td>
				<td>52影院</td>
			</tr>
			<tr>
				<td>影厅：</td>
				<td>${stu.studio_name}</td>
			</tr>
			<tr>
				<td>场次：</td>
				<td class="color">${sche.sched_time}</td>
			</tr>
			<tr>
				<td>座位：</td>
				<td id="zuo" class="color">您还未选择座位</td>
			</tr>
			<tr>
				<td>原价：</td>
				<td id="mon" >¥${sche.sched_ticket_price} x 0</td>
			</tr>
			<tr>
				<td>总计：</td>
				<td id="allmon" class="color">¥ 0</td>
			</tr>
		</table>
	</div>
	
	<div style="float: left;" class="infor"><input type="button" style="font-size: 25px; border-radius: 7px; color: white; background-color: red;" id="sub" value="确认信息，下单"/></div>
	<div style="float: left;"><button   style="font-size: 25px; border-radius: 7px; color: white; background-color: red;" onclick="on()">重新选座89	</button></div>
</div>
	
</body>

<script type="text/javascript">	
function on(){
	location.href="${pageContext.request.contextPath}/OutTicketServlet";}  	

	document.getElementById("sub").onclick=function(){		
		var arr=new Array();
		var str=document.getElementById("zuo").innerHTML;
		arr=str.match(/\d+/g); 
		if(arr==null) alert("您还未选择座位！");
		else
			location.href="${pageContext.request.contextPath }/findTicketID?id="+arr+"&scheid="+"${scheid}";
		
	}
	
	var num=0;var i="${ticketNumber}";

	<c:forEach var="i" begin="1" end="${stu.studio_row_Count }" step="1">						
		<c:forEach var="j" begin="1" end="${stu.studio_col_Count }" step="1">
			document.getElementById("${i }排${j }列").onclick=function(){
			if(document.getElementById("${i }排${j }列").className!="seat_sale")
				if(document.getElementById("${i }排${j }列").className=="seated"){
					 
					if(num>=i)	alert("最多可选4个座位！");
					else{
						num++;
						document.getElementById("${i }排${j }列").className="onseat";//变色
						//添加到集合											
						var html=document.getElementById("zuo").innerHTML.replace("您还未选择座位","");
						document.getElementById("zuo").innerHTML=html+"${i }排${j }列&nbsp;&nbsp;&nbsp;";
						
						document.getElementById("mon").innerHTML="¥${sche.sched_ticket_price} x "+num;
						
						document.getElementById("allmon").innerHTML="¥"+parseInt("${sche.sched_ticket_price}")*num;
					}		
				}		
				else {
					document.getElementById("${i }排${j }列").className="seated";//变色
					//从集合中删除
					num--;
					if(num==0 )	document.getElementById("zuo").innerHTML="您还未选择座位";
					else{
						var html=document.getElementById("zuo").innerHTML;
						document.getElementById("zuo").innerHTML=html.replace("${i }排${j }列&nbsp;&nbsp;&nbsp;","");
					}				
					
					document.getElementById("mon").innerHTML="¥${sche.sched_ticket_price} x "+num;
					document.getElementById("allmon").innerHTML="¥"+parseInt("${sche.sched_ticket_price}")*num;				
				}		
			}
		</c:forEach>
	</c:forEach>
	<c:forEach var="i" items="${ticket}">
		document.getElementById("${i.seat_row }排${i.seat_column }列").className="seat_sale";
	</c:forEach>
</script>

</html>