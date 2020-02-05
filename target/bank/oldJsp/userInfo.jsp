<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020/1/22
  Time: 6:18 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body onload="userInfo()">

<div id="userInfos">

</div>
</body>
<script type="text/javascript">
    function userInfo() {
        var xhr;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xhr = new XMLHttpRequest();
        } else {// code for IE6, IE5
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xhr.open("GET", "http://localhost:8080/userManager/checkUserInfo", true);
        xhr.send();
        document.getElementById("userInfos").innerHTML = xhr.responseText;
        console.log(xhr.responseText);
    }
</script>
</html>
