<%--
  Created by IntelliJ IDEA.
  User: WonSeungJu
  Date: 2022-06-19
  Time: 오후 5:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="includes/common-head.jsp" %>
<body>
<h1>잘못된 접근이거나 유효하지 않은 페이지입니다.</h1>
<span id="timer">5</span> 초 후 메인페이지로 이동합니다.
</body>
<script>
    let t = 5;
    setInterval(()=>{
        $('#timer').get(0).innerText = --t + "";
        if(t==0) location = "/";
    }, 1000);
</script>
</html>
