<%--
  Created by IntelliJ IDEA.
  User: WonSeungJu
  Date: 2022-06-20
  Time: 오전 1:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="includes/common-head.jsp" %>
<body>
<%@ include file="includes/join-header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-12 d-flex justify-content-center progressWrapper">
            <img class="joinProgress " src="/resources/img/join_progress.png"/>
        </div>
    </div>
    <div class="row">
        <h3>가입 완료</h3>
        <hr>
    </div>
    <div class="row">
        &nbsp;
    </div>
    <div class="row">
        <h1>가입이 완료되었습니다!</h1>
    </div>
</div>
<%@ include file="includes/footer.jsp" %>
<style>
    .joinProgress
    {
        position: relative;
        width: 454px;
        height: 398px;
        top: -268px;
    }
    .progressWrapper
    {
        height: 134px;
        overflow: hidden;
    }
</style>
</body>
</html>
