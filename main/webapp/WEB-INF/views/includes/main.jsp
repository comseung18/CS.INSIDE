<%--
  Created by IntelliJ IDEA.
  User: WonSeungJu
  Date: 2022-06-02
  Time: 오후 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="main container min-width-1400">
    <div class="row">&nbsp;</div>
    <div class="row">
        <div id="mainBanner" class="col-9">
            Welcome To CS INSIDE
        </div>
        <div class="col-3">
            <div id="loginWrapper">
                <form>
                    <div class="row">
                        <div class="col-7">
                            <div class="mb-3">
                                <input type="text" class="form-control" id="userID" aria-describedby="idHelp" placeholder="ID">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-7">
                            <div class="mb-3">
                                <input type="password" class="form-control" id="userPasswd" placeholder="Password">
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
