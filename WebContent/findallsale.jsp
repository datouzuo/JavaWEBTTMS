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
                   <th class="hb">售后id</th>
                   <th class="pm">用户名</th>
                   <th class="sj">片名</th>
                   <th >时间</th>
                   
                  
               </tr>
               <c:forEach items="${saleall}" var="mov" varStatus="vs">
               <tr >
                    <td class="id">${vs.count }</td>
                    <td><img src="${mov.sale_item_id}"></td>
                    <td>${mov.usename }</td>
                    <td>${mov.play_name}</td>
                    <td>${mov.sale_time}</td>
                   
                   
                      
                </tr>
               </c:forEach>
           </table>
       </div> 
   </body>

</html>