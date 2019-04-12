<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<table style="border-collapse: collapse; border: 1px solid beige; text-align: center; margin: 0 auto; height: 100%; width: 800px;">
		<tr style="background-color: aliceblue; height: 70px;">
			<th
				style="border: 1px solid beige; font-size: medium; font-family: '微软雅黑';">电影名</th>
			<th
				style="border: 1px solid beige; font-size: medium; font-family: '微软雅黑';">用户名</th>
			<th
				style="border: 1px solid beige; font-size: medium; font-family: '微软雅黑';">购买时间</th>
				<th
				style="border: 1px solid beige; font-size: medium; font-family: '微软雅黑';">售后id</th>
		</tr>
	
		<tr height="50px">
			<td style="border: 1px solid beige">
						<c:forEach items="${saleall}" var="sale">
							<tr height="35px">
							<td style="border: 1px solid beige">
								<table border="0" align="center">
									<tr>
										
										<td style=""><font
											style="font-weight: 400; font-family: '微软雅黑';font-size:larger">${sale.play_name}</font><br>
										</td>
									</tr>
								</table>
							</td>
							<td style="border: 1px solid beige"><font
								style="font-family: '微软雅黑'; font-size: larger">${sale.usename}</font><br>
							</td>
							<td style="border: 1px solid beige"><font
								style="font-family: '微软雅黑'; font-size: larger">${sale.sale_time}</font>
							</td>
							<td style="border: 1px solid beige"><font
								style="font-family: '微软雅黑'; font-size: larger">${sale.sale_item_id}</font>
							</td>
						</tr>
					</c:forEach>


				
		</tr>
</body>
</html>

