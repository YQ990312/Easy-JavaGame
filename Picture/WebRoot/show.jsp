<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <div class="PageOne">
        <div class="title">
            <h1>浪哩个烧</h1>
        </div>
        <div class="simpletitle">
            <span>欢迎每一个顾客的到来，我们以最好的服务迎接你们，欢迎加入浪哩个烧大家庭！</span>
        </div>
        <div class="picture">
            <img src="<%=session.getAttribute("WeChat") %>" alt="" class="showtrue" id="myimgshow">
        </div>
        <a href="<%=session.getAttribute("WeChat") %>" class="showPicture">查看大图</a>  
    </div>
    <script src="./style.js"></script>
</body>

</html>