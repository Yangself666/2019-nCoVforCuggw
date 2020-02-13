<%--
  Created by IntelliJ IDEA.
  User: yangself
  Date: 2020/2/13
  Time: 10:40 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>获取数据</title>
    <style>
        h4{
            text-align: center;
        }
        form{
            width: 300px;
            margin: 20px auto;
            text-align: center;
        }
    </style>
</head>
<body>
<h4>请选择想要下载的数据日期</h4>
<h4>${dMsg}</h4>

<form action="${pageContext.request.contextPath }/getExcel" method="get">
    <input type="date" name="tDate"/>
    <input type="submit" value="确定下载">
</form>


</body>
</html>

