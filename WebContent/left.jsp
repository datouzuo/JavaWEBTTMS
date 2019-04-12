<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="dtree.css" type="text/css" />
</head>
<body style="background-color: #DDEDFB">
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	
	<script type="text/javascript" src="dtree.js"></script>
	<script type="text/javascript">
	
	d = new dTree('d');
		d.add('01',-1,'系统菜单树'); //01代表本级节点的编号  -1代表根节点
		d.add('0102','01','影片管理','','','right');//0102代表本级节点的编号   01代表父级节点
		d.add('010201','0102','查看影片','findMovieAllServlet','','right');
	    d.add('010202','0102','增加信息','addtypelang.jsp','','right'); 
		d.add('010203','0102','增加影片','showAddMovieServlet','','right');
		d.add('0104','01','演出厅管理');
		d.add('010401','0104','演出厅管理','studio_web','','right');
		d.add('0105','01','演出计划管理');
		d.add('010501','0105','演出计划管理','sche.html','','right');
		d.add('0106','01','购买历史');
		d.add('010601','0106','购买历史','findSaleServlet','','right');
		document.write(d);
		
	</script>
</div>	</td>
  </tr>
</table>


</body>
</html>