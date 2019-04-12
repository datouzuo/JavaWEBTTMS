<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
<form action="/TTMS/addTypeLangServlet" method="post">
	<div>
		<div class="add" >
			添加语言：
			<input type="text" size="40" name="dict_lang" />
		</div><br><br>
		<div class="add">
			添加类型：
			<input type="text" size="40" name="dict_type"  />
		</div>
		<br>
		<div>
		<input type="submit" value="提交"  size="20"/>
		</div>
	</div>
	</form>
</body>
</html>
