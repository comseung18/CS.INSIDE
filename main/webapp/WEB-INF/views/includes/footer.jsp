<%--
  Created by IntelliJ IDEA.
  User: WonSeungJu
  Date: 2022-06-02
  Time: 오후 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid footer">
    <div class="infoPolicy">
        <a href="#">사이트 소개</a>
        <a href="#">이용약관</a>
        <a href="#">컨택트</a>
        <a href="#">개인정보처리방침</a>
    </div>
    <div class="projInfo">
        Koreatech 원승주 BCSD 회고 프로젝트
    </div>

    <style>
        .infoPolicy
        {
            margin-top: 100px;
            text-align: center;
        }

        .infoPolicy a::before
        {
            content: " | ";
        }

        .infoPolicy a:first-child::before
        {
            content: "";
        }

        .projInfo
        {
            text-align: center;
        }
    </style>
</div>
