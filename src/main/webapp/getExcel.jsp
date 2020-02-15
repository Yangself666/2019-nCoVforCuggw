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
        .msg{
            color: red;
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
<h4>如果您的浏览器不能选择日期，请手动输入。日期格式如：2020-02-13</h4>
<h4 class="msg">${dMsg}</h4>

<form action="${pageContext.request.contextPath }/getExcel" method="get">
    <input type="date" name="tDate"/>
    <input type="submit" value="确定下载">
</form>
<h4>微信，QQ请点击右上角菜单，使用浏览器打开。</h4>
<h4>请使用电脑下载，使用手机下载有可能会出现文件损坏的问题，正在解决中...</h4>


</body>
</html>

