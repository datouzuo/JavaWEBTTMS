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
		<form action="${pageContext.request.contextPath }/modstudioServlet" method="post" >
			<table>
				<tr>
					<td>
						演出厅名称：
					</td>
					<td>
						<input type="text" name="name">
						<input type="text" style="display: none;" name="id" value="${param.id}" >
					</td>
				</tr>
				<tr>
					<td>
						座位行数：
					</td>
					<td>
						<input type="text" name="row">
					</td>
				</tr>
				<tr>
					<td>
						座位列数：
					</td>
					<td>
						<input type="text" name="col">
					</td>
				</tr>
				<tr>
					<td>
						演出厅名称：
					</td>
					<td>
						<textarea rows="10" cols="10" name="intro"></textarea>
					</td>
				</tr>
			</table>
			<input type="submit" value="确定">
		</form>
	</div>
</body>
</html>