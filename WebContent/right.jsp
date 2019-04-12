<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript">
	 function load() {
		 
		var movie = "";
	$.post("${pageContext.request.contextPath}/cus_DisplayMovieServlet",
				null, function(data) {
					if (data.length>0) {
						
						for (var i = 0; i < data.length; i++)
							movie +=("<option value="+data[i].play_id+" >" + data[i].play_name
									+ "</option>")
					}

					$("#sp").append(movie);
				},
				"json");
	
	
	var studio = "";
	
	$.post("${pageContext.request.contextPath}/findScheduleServlet",
			null, function(data) {
				if (data.length>0) {
				
					for (var i = 0; i < data.length; i++)
						studio +=("<option value="+data[i].studio_id+" >" + data[i].studio_name
								+ "</option>")
				}

				$("#sppp").append(studio);
			},
			"json");
	

	} 
	  function onb(play_id){
		  
		  
		  window.parent.right1.location.href="${pageContext.request.contextPath}/play_id_FindSchServlet?play_id="+play_id;;
		 

			} 
		
		 
		 
	
	 
</script>

<style>
			select
       	     {
       	     	width: 100px;
       	     	height: 30px;
       	     }
       	    font.thick
			{
				font-weight: bold;
				font-size: 30px;
				font-family: "楷体";
			}
			option 
			{
				font-weight: bold;
				font-size: 30px;
				font-family: "楷体";
			}
			}
</style>
</head>
<body onload="load()" 
>
	<hr>
	<table  width="80%" height="350px" align="center">
	<form action="${pageContext.request.contextPath}/AddScheduleServlet" target="right1">
        <tr>
       	<td align="center"><font class="thick">电影选择</font></td>
    	<td align="center">
    		<select required="required" size="1" class=thick id="sp" name="play_id" onchange="onb(this.value)">
  			<option>请选择电影</option>
  				
		</select>
    	</td>
		</tr>
      	<tr valign="center">
       	<td align="center"><font class="thick">放映厅选择</font></td>
       	<td align="center">
       		<select size="1" required="required" id="sppp" name="studio_id">
  			<option >请选择演出厅</option>
  		
		   </select>
       	</td>
		</tr>
		<tr valign="center">
		<td align="center"><font class="thick">演出时间选择</font></td>
		<td align="center"><input type="time" name="time1" value="--:--"/></td>
		<tr valign="center">
		<td align="center"><font class="thick">散场时间选择</font></td>
		<td align="center"><input type="time" name="time2" value="--:--"/></td>
	</tr>
	</tr>
	<tr>
		<td colspan="2" rowspan="3" align="center"><input type="submit"></td>
	</tr>
	</form>
	</table>
</body>
</html>
