<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
        <style type="text/css">
            input{
                width: 100px;
                height: 50px;
                font-size: 25px;
            }
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
        </style>
    </head>
   <body>
       <div id="bg">
           <table>
               <tr id="bt">
                   <th class="id">id</th>
                   <th class="pm">片名</th>
                   <th class="sj">上映时间</th>
                   <th >评分</th>
                   <th class="yt">放映厅</th>
                   <th class="sj">售价（元）</th>
                   <th class="cz">操作</th>
               </tr>
               <tr >
                    <td class="id">1</td>
                    <td>复仇者联盟3：无限战争</td>
                    <td>2018.5.17</td>
                    <td>8.8分</td>
                    <td>3号放映厅</td>
                    <td>30</td>
                   <td> <div><input type="button" value="修改" id="mod"/><input type="button" value="删除" id="del"/></div></td>
                </tr>
               <tr class="yp">
                   <td class="id">2</td>
                   <td>超时空同居 </td>
                   <td>2018.5.17</td>
                   <td>暂无评分</td>
                   <td>3号放映厅</td>
                   <td>30</td>
                   <td> <div><input type="button" value="修改" id="mod"/><input type="button" value="删除" id="del"/></div></td>
               </tr>
               <tr >
                    <td class="id">3</td>
                    <td>寂静之地</td>
                    <td>2018.5.17</td>
                    <td>暂无评分</td>
                    <td>3号放映厅</td>
                    <td>30</td>
                    <td> <div><input type="button" value="修改" id="mod"/><input type="button" value="删除" id="del"/></div></td>
                </tr>
               <tr class="yp">
                   <td class="id">4</td>
                   <td>后来的我们</td>
                   <td>2018.5.17</td>
                   <td>7.8分</td>
                   <td>3号放映厅</td>
                   <td>30</td>
                   <td> <div><input type="button" value="修改" id="mod"/><input type="button" value="删除" id="del"/></div></td>                   
               </tr>
               <tr >
                    <td class="id">5</td>
                    <td>我是你妈</td>
                    <td>2018.5.17</td>
                    <td>8.3分</td>
                    <td>3号放映厅</td>
                    <td>30</td>
                    <td> <div><input type="button" value="修改" id="mod"/><input type="button" value="删除" id="del"/></div></td>                                  
                </tr>
               <tr class="yp">
                   <td class="id">6</td>
                   <td>幕后玩家</td>
                   <td>2018.5.17</td>
                   <td>8.2分</td>
                   <td>3号放映厅</td>
                   <td>30</td>
                   <td> <div><input type="button" value="修改" id="mod"/><input type="button" value="删除" id="del"/></div></td>                                   
               </tr>
               <tr >
                    <td class="id">7</td>
                    <td>头号玩家</td>
                    <td>2018.5.17</td>
                    <td>9.0分</td>
                    <td>3号放映厅</td>
                    <td>30</td>
                   <td> <div><input type="button" value="修改" id="mod"/><input type="button" value="删除" id="del"/></div></td>                            
                </tr>
           </table>
       </div> 
   </body>
   <script>
       var mod=document.getElementById("mod");
       mod.onclick=function(){
        window.location.href="add.html";
       };

       var del=document.getElementById("del");
       del.onclick=function(){         
           alert("删除成功！");
       };
   </script>



</html>