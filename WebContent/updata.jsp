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
<script type="text/javascript">
window.onload = function(){
var play_lang_id = "${movie.play_lang_id}";
var play_type_id = "${movie.play_type_id}";

var lang = document.getElementById("lang_id").getElementsByTagName("option");
var type = document.getElementById("type_id").getElementsByTagName("option");
for(var i=0;i<lang.length;i++){
	if(play_lang_id==lang[i].value){
		lang[i].selected = true;
	}
}
for(var i=0;i<type.length;i++){
	if(play_type_id ==type[i].value){
		type[i].selected = true;
	}
}
}
</script>
</head>
<body>
	<form action="/TTMS/updataMovieServlet" method="post">
		<input type="hidden" name="play_id" value="${movie.play_id}">
		<div>
			<h1>影片信息</h1>
			<div class="add">
				<table>
					<tr>
						<td class="left">影片语言:</td>
						<td><select name="play_lang_id" id="lang_id">
								
								<c:forEach var="mov" items="${movielang}" >
									<option value="${mov.dict_id}">${mov.dict_value}</option>
								</c:forEach>
						</select></td>

					</tr>
					<tr>
						<td class="left">类型:</td>
						<td><select name="play_type_id" id="type_id">
							
								<c:forEach items="${movietype}" var="ty">

									<option value="${ty.dict_id}">${ty.dict_value}</option>
								</c:forEach>

						</select></td>
					</tr>
					<tr>
						<td class="left">片长:</td>
						<td><input type="text" name="play_length" value="${movie.play_length}" /></td>
					</tr>
					<tr>
						<td class="left">片名:</td>
						<td><input type="text" name="play_name" value="${movie.play_name}" /></td>
					</tr>
					<tr>
						<td class="left">添加海报:</td>
						<td><input type="file" /></td>
					</tr>
					<tr>
						<td class="left" >售价:</td>
						<td><input type="text" name="play_ticket_price" value="${movie.play_ticket_price}"/></td>
					</tr>
					<tr>
						<td class="left">影片描述:</td>
						<td><textarea name="play_introduction" >${movie.play_introduction}</textarea></td>
					</tr>
				</table>
			</div>

			<div class="add">
				<input id="sub" type="submit" value="提交" width="50px" />
			</div>
		</div>
	</form>
</body>
<!-- <script type="text/javascript">
	var sub = document.getElementById("sub");
	sub.onclick = function() {
		alert("成功！");
	}; 
</script>
 -->


</html>