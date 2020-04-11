<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./style.css">
    <title>浪哩个烧</title>
    
</head>

<body>
<s:property value="#session.Wechat"/>
    <div class="PageOne">
        <div class="title">
            <h1>æµªå©ä¸ªç§</h1>
        </div>
        <div class="simpletitle">
            <span>æ¬¢è¿æ¯ä¸ä¸ªé¡¾å®¢çå°æ¥ï¼æä»¬ä»¥æå¥½çæå¡è¿æ¥ä½ ä»¬ï¼æ¬¢è¿å å¥æµªå©ä¸ªç§å¤§å®¶åº­ï¼</span>
        </div>
        <div class="picture">
            <div class="add">

            </div>
            <img src="" alt="" class="show" id="myimg">
        </div>
      <form action="WeChat.action" method="post" enctype="multipart/form-data">
        <input type="file" class="showpicture" id="fileinput" name="file" accept="image/png,image/jpg,image/jpeg" onchange="changeToop();">
        <button class="suresubmit" type="submit">ç¡®è®¤æäº¤</button>
      </form>  
    </div>
    <script src="./style.js"></script>
</body>

</html>