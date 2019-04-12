<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.add {
	margin: 50px 200px;
}

.left {
	width: 200px;
}

table {
	font-family: 微软雅黑;
	font-size: 30px;
}

input {
	width: 400px;
	height: 40px;
	font-size: 20px;
}

select {
	width: 400px;
	height: 40px;
	font-size: 20px;
}

textarea {
	width: 400px;
	height: 350px;
	font-size: 20px;
}

h1 {
	margin-left: 200px;
}
</style>
</head>
<body>
	<form action="/TTMS/addMovieServlet" method="post" enctype="multipart/form-data">
		<div>
			<h1>影片信息</h1>
			<div class="add">
				<table>
					<tr>
						<td class="left">影片语言:</td>
						<td><select name="play_lang_id">
								<option>请选择影片语言</option>
								<c:forEach var="mov" items="${movielang}" >
									<option value="${mov.dict_id}">${mov.dict_value}</option>
								</c:forEach>
						</select></td>

					</tr>
					<tr>
						<td class="left">类型:</td>
						<td><select name="play_type_id">
								<option>请选择电影类型</option>
								<c:forEach items="${movietype}" var="ty">

									<option value="${ty.dict_id}">${ty.dict_value}</option>
								</c:forEach>

						</select></td>
					</tr>
					<tr>
						<td class="left">片长:</td>
						<td><input type="text" name="play_length" /></td>
					</tr>
					<tr>
						<td class="left">片名:</td>
						<td><input type="text" name="play_name" /></td>
					</tr>
					<tr>
						<td class="left">添加海报:</td>
						<td><input type="file" name="load"/></td>
					</tr>
					<tr>
						<td class="left">售价:</td>
						<td><input type="text" name="play_ticket_price" /></td>
					</tr>
					<tr>
						<td class="left">影片描述:</td>
						<td><textarea name="play_introduction"></textarea></td>
					</tr>
				</table>
			</div>

			<div class="add">
				<input id="sub" type="submit" value="提交" width="50px" />
			</div>
		</div>
	</form>
</body>


</html>