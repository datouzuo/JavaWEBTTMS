<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<style type="text/css">
            tr{
                text-align: center;
                font-size: 30px;
            }
            td{
                width: 280px;
                height: 80px;
            }
            #bt{
                background-color: blue;  
            }
            th{
                color: white;
                background-image: url("image/bj.png");
            }
            .yp{
                background-color: #F1F1F1;
            }
            img{
                width: 150px;
                height: 200px;
            }
            .id{
                width: 50px;
            }
             input{
                width: 100px;
                height: 50px;
                font-size: 25px;
            }
            
        </style>
        <script type="text/javascript">
          function del(play_id){
        	  var isdel = confirm("是否确定删除");
        	  if(isdel){
        		  location.href="${pageContext.request.contextPath}/deleteMovieServlet?play_id="+play_id;
        	  }
          }
          function updata(play_id){
        	  
        		  location.href="${pageContext.request.contextPath}/showUpdataMovieServlet?play_id="+play_id;
        	  
          }
        </script>
       
    </head>
<body>

 <div id="bg">
           <table>
               <tr id="bt">
                   <th class="id">id</th>
                   <th class="hb">用户</th>
                   <th class="pm">片名</th>
                   <th class="sj">影片类型</th>
                   <th >时间</th>
                   <th class="yt">影片语言</th>
                   <th class="sj">售价（元）</th>
                   <th class="cz">操作</th>
               </tr>
               <c:forEach items="${listmovie.movieall}" var="mov" varStatus="vs">
               <tr >
                    <td class="id">${vs.count }</td>
                    <td><img src="${mov.play_image}"></td>
                    <td>${mov.play_name }</td>
                    <td>${mov.dict_value}</td>
                    <td>${mov.play_length }</td>
                    <td>${mov.dict_value1 }</td>
                    <td>${mov.play_ticket_price }</td>
                      <td> <div><input type="button" value="修改" onclick="updata('${mov.play_id }')"/>
                      <input type="button" value="删除" id="del" onclick="del('${mov.play_id }')"/></div></td>
                </tr>
               </c:forEach>
           </table>
       </div> 


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet"
	media="screen">
<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet"
	media="screen">
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<div class="pagination">
		<ul>
				<li>
					<a href="/findMovieAllServlet?id=${listmovie.currentPage}">Prev</a>
				</li>
				<c:forEach  var="x"   begin="1"    end="${listmovie.page}" >
					<li>
						<a href="/findMovieAllServlet?id=${x+listmovie.currentPage}" id="${x+listmovie.currentPage}">${x+number}</a>
					</li>
				</c:forEach>
				<li>
					<a href="/findMovieAllServlet?id=${listmovie.currentPage+1}">Next</a>
				</li>
		</ul>
	</div>






</body>
</html>