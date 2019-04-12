<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="${pageContext.request.contextPath }/addstudioServlet" method="post">
			<table width="650px">				<tr>
					<td>
						<font size="5">演出厅名称</font>
					</td>
					<td>
						<input type="text" name="name">
					</td>
				</tr>
				<tr>
					<td>
						<font size="5">座位行数</font>
					</td>
					<td>
						<input type="text" name="row">
					</td>
				</tr>
				<tr>
					<td>
						<font size="5">座位列数</font>
					</td>
					<td>
						<input type="text" name="col">
					</td>
				</tr>
				<tr>
					<td>
						<font size="5">演出厅介绍</font>
					</td>
					<td>
						<textarea rows="20" cols="50" name="intro"></textarea>
					</td>
				</tr>
				<tr>
				<td colspan="2"align="right">
				<input type="submit" value="确定">
				</td>
				</tr>
			</table>
			
		</form>
	</div>
</body>
</html>