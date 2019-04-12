<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<script type="text/javascript">
	<c:forEach var="i" items="${allstu}">
		document.getElementById("mod${i.studio_id }").oncilck=function(){
		window.location="${pageContext.request.contextPath }/addstudio?id=";
		}
	</c:forEach>
</script>
<body>


	<div id="studio">
		<table width="1100px" height="100%" align="center">
			<tr>
				
				<th>
					<font size="5">演出厅</font>
				</th>
				<th>
					<font size="5">座位行数</font>
				</th>
				<th>
					<font size="5">座位列数</font>
				</th>
				<th>
					<font size="5">演出厅简介</font>
				</th>
				<th>
					<font size="5">操作</font>
				</th>
			</tr>		
			<c:forEach var="i" items="${allstu}">
				<tr align="center" height="50px">
					
					<td>
						<font size="5">${i.studio_name }</font>
					</td>
					<td>
						<font size="5">${i.studio_row_Count }</font>
					</td>
					<td>
						<font size="5">${i.studio_col_Count }</font>
					</td>
					<td>
						<font size="5">${i.studio_introduction }
					</td>
					<td>
				<%-- 	<input type="button" value="修改" onclick="location.href='${pageContext.request.contextPath }/modstudio.jsp?id='+'${i.studio_id }'"> --%>
					 <input type="button" style="width:50px;heigth:50px;" value="删除" onclick="location.href='${pageContext.request.contextPath }/delstudioServlet?id='+'${i.studio_id }'"> 
					</td>
				</tr>
			</c:forEach>
			
		</table>
		<input type="button" id="add" value="增加" onclick="location.href='${pageContext.request.contextPath }/addstudio.jsp'">
	</div>
</body>

</html>