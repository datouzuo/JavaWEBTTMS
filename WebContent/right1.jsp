<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		<style>
  			table
  			{
  				width:100%;
  			}

			th
  			{
  				height:50px;
  			}
  			.tdd
  			{
  				text-align:center;
  				font-weight: bold;
  				font-family: "楷体";
  				font-size: 25px;
  			
		</style>
		 <script type="text/javascript">
		 function del(sched_id){
        	  var isdel = confirm("是否确定删除");
        	  if(isdel){
        		  location.href="${pageContext.request.contextPath}/deleteScheServlet?sched_id="+sched_id;
        	  }
          }
		 </script>
	</head>
	<body >
		<hr>
		<table border="1" width="100%" height="300px">
  			<tr>
    			<th>电影</th>
    			<th>放映厅</th>
    			<th>时间</th>
    			<th>操作</th>
     		</tr>
     		 <c:forEach items="${schedules}" var="sch"> 
  			<tr>
    			<td class="tdd">${movie.play_name}</td>
    		    <td class="tdd">${sch.studio_name}</td>
    		    <td class="tdd">${sch.sched_time}</td>
    		    <td class="tdd">
    		    
    					<input type="button"  onclick="del('${sch.sched_id}')"  value="删除">
					
    		    </td>
  			</tr>
  	
  		</c:forEach> 
  	
		</table>
	</body>
</html>
