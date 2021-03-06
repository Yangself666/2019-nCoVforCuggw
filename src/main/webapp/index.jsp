<%--
  Created by IntelliJ IDEA.
  User: yangself
  Date: 2020/2/13
  Time: 12:50 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>2016级工程2队体温统计</title>
    <style>
        body {
            background-color: #f5f6f7;
        }

        h2 {
            text-align: center;
        }
        h4{
            color: red;
        }

        form {
            padding: 20px;
            width: 300px;
            margin: 10px auto;
            text-align: center;
        }
        .link{
            display: block;
            text-align: center;
        }
    </style>
</head>

<body>
<!--可以进行多次提交，多次提交以最后一次为准-->
<h2>2016级工程二队体温统计系统</h2>
<form action="${pageContext.request.contextPath }/submitForm" method="post">
    <h4>${msg }</h4>
    姓名：<input type="text" name="tName" value="${tName }" required="required"><br>
    专业：<select name="major" id="major" onchange="changeMajor(this.selectedIndex)"></select><br>
    班级：<select name="mClass" id="mClass"></select><br>
    你的体温：<input type="text" name="myTemp" value="${myTemp } "><br>
    父亲体温：<input type="text" name="faTemp" value="${faTemp } "><br>
    母亲体温：<input type="text" name="moTemp" value="${moTemp } "><br>
    身体状况：<input type="radio" name="state" value="正常" checked="checked"/>正常
            <input type="radio" name="state" value="发烧"/>发烧
            <input type="radio" name="state" value="咳嗽"/>咳嗽
    <input class="subButton" type="submit" value="提交信息">
</form>
<br>
<br>
<br>
<br>
<a class="link" href="${pageContext.request.contextPath }/getTempList.jsp">数据下载</a>
<div class="link">本项目已开源，代码已上传至<a href="https://github.com/Yangself666/2019-nCoVforCuggw">Github</a>。</div>


<script type="text/javascript">
    var majors = ["请选择专业", "电气工程及其自动化", "计算机科学与技术", "电子信息工程"];
    var classes = [
        ["请选择班级"],
        ["电气1601", "电气1602", "电气1603", "电气1604"],
        ["计算机1601", "计算机1602", "计算机1603", "计算机1604"],
        ["电子1601"]
    ];
    window.onload = function () {
        var major = document.getElementById("major");
        var mClass = document.getElementById("mClass");
        var index = 0;
        //创建好后加入到列表中
        for (var i in majors) {
            var option = document.createElement("option");
            option.text = majors[i];
            option.value = majors[i];
            major.appendChild(option);
        }
        var option = document.createElement("option");
        option.text = classes[index];
        option.value = classes[index];
        mClass.appendChild(option);
    }

    function changeMajor(selectedIndex) {
        var mClass = document.getElementById("mClass");
        mClass.options.length = 0;
        for (var i in classes[selectedIndex]) {
            var option = document.createElement("option");
            option.text = classes[selectedIndex][i];
            option.value = classes[selectedIndex][i];
            mClass.appendChild(option);
        }
    }
</script>
</body>

</html>