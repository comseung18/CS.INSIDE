<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: WonSeungJu
  Date: 2022-06-02
  Time: 오후 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User)session.getAttribute("user");
    String nickType = "";
    if(user != null) nickType = ((user.getFixedName())? "고정닉" : "비고정닉");
%>


<div class="main container min-width-1400">
    <div class="row">&nbsp;</div>
    <div class="row">
        <div id="mainBanner" class="col-9">
            Welcome To CS INSIDE
        </div>
        <div class="col-3">

                <c:choose>
                    <c:when test="${empty user}">
                        <div id="loginWrapper">
                            <form method="post" action="/log/in" >
                                <div class="row">
                                    <div class="col-7">
                                        <div class="mb-3">
                                            <input type="text" class="form-control" id="userID" name="userID" aria-describedby="idHelp" placeholder="ID">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-7">
                                        <div class="mb-3">
                                            <input type="password" class="form-control" id="userPasswd" name="userPasswd" placeholder="Password">
                                        </div>
                                    </div>
                                    <div class="col-5">
                                        <button type="submit" class="btn btn-dark">로그인</button>
                                    </div>
                                </div>
                                <hr class="hr-dash" />
                                <div class="row">
                                    <div class="col-4">
                                        <a href="join/agree" class="text-secondary">회원 가입</a>
                                    </div>
                                    <div class="col-8">
                                        <a href="#" class="text-sm-center text-secondary">아이디/비밀번호 찾기</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </c:when>
                    <c:otherwise>

                        <p>닉네임타입 : ${user.getFixedName()? "고정닉" : "비고정닉"}</p>
                        <c:if test="${!user.getFixedName()}">
                            <button class="btn btn-secondary">닉네임 변경하기</button>
                        </c:if>
                        <p>${user.getNickname()} 님 환영합니다.</p>
                        <a class="btn btn-link" href="/log/out">로그아웃</a>
                    </c:otherwise>
                </c:choose>


        </div>
    </div>

    <style>
        #mainBanner
        {
            background-color: rgba(85, 85, 85, 0.71);
            color:white;
            text-align: center;
            height: 600px;
            line-height: 400px;
            font-weight: bold;
            font-size: 30px;
        }

        #loginWrapper
        {
            border: 3px solid #444;
            padding: 15px;
            overflow: hidden;
        }
    </style>
</div>
