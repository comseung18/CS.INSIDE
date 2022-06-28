<%--
  Created by IntelliJ IDEA.
  User: WonSeungJu
  Date: 2022-06-19
  Time: 오후 5:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="includes/common-head.jsp" %>
<body>
<%@ include file="includes/join-header.jsp" %>
<div class="container min-width-1400">
    <script>
        let validId = false;
        function idCheck()
        {
            let id = $('#joinInfoId').get(0).value;
            let url = "/user/exist-id";
            $.get(url, {id:id}).done((data)=>{
                if(data)
                {
                    toastr.error('이미 존재하는 ID 입니다.');
                    validId = false;
                }
                else
                {
                    toastr.success('사용가능한 ID 입니다.')
                    validId = true;
                }
            });
        }

        let validNickname = false;
        function  nicknameCheck()
        {
            let nickname = $('#joinInfoNick').get(0).value;
            if(nickname.length < 2)
            {
                $("#isNicknameValid").text('닉네임이 너무 짧습니다.');
                validNickname = false;
                return;
            }

            if(($('#joinInfoFixed').get(0).value) != "fixed")
            {
                $('#isNicknameValid').text('사용가능한 닉네임입니다.');
                validNickname = true;
                return;
            }


            let url = "/user/exist-nickname";
            $.get(url, {nickname:nickname}).done((data)=>{
                if(data)
                {
                    $("#isNicknameValid").text('이미 사용 중인 닉네임입니다.');
                    validNickname = false;
                }
                else
                {
                    $('#isNicknameValid').text('사용가능한 닉네임입니다.');
                    validNickname = true;
                }
            });
        }

        function submitForm()
        {
            // 아이디 검사
            if(!validId)
            {
                toastr.error('아이디 중복확인을 해주세요.');
                return false;
            }

            // 비밀번호 검사
            let pw = $('#joinInfoPw').get(0).value;
            let pw2 = $('#joinInfoPwRe').get(0).value;
            if(pw != pw2)
            {
                toastr.error('비밀번호가 일치하지 않습니다.');
                return false;
            }

            // 닉네임 검사
            if(!validNickname)
            {
                toastr.error('닉네임을 확인 해주세요.');
                return false;
            }


            const url = '/join/info';
            const post_data = JSON.stringify({
                id : $('#joinInfoId').get(0).value,
                passwd : pw,
                nickname : $('#joinInfoNick').get(0).value,
                email : $('#joinInfoEmail').get(0).value,
                fixedName : $('#joinInfoFixed').get(0).value == 'fixed'
            });
            $.ajax({
                url: url,
                type: "POST",
                data : post_data,
                contentType:"application/json; charset=utf-8",
                // dataType:"text",
                success: function(d){
                    console.log(d);
                    $('html').html(d);
                }
            });
            return false;
        }

        function nextBtnClicked()
        {
            $('#joinSubmit').get(0).click();
        }
    </script>
    <div class="row">
        <div class="col-12 d-flex justify-content-center progressWrapper">
            <img class="joinProgress " src="/resources/img/join_progress.png"/>
        </div>
    </div>
    <div class="row">
        <h3>정보 입력</h3>
        <hr>
    </div>
    <div class="row infoBox">
        <div class="container joinFormBox">
            <form action="/join/info" method="POST" id="joinForm" onsubmit="return submitForm();">
                <fieldset>
                    <div class="row mb-4">
                        <div class="col-3 joinFormLeft">
                            아이디
                        </div>
                        <div class="col-7">
                            <input type="text" placeholder="아이디를 입력해 주세요." required id="joinInfoId" name="joinInfoId" onchange="validId = false;">
                        </div>
                        <div class="col-2">
                            <button type="button" class="btn btn-secondary" onclick="idCheck()">중복 확인</button>
                        </div>
                    </div>
                    <div class="row mb-4">
                        <div class="col-3 joinFormLeft">
                            비밀번호 입력
                        </div>
                        <div class="col-9 mb-1">
                            <input type="password" placeholder="비밀번호를 입력해 주세요." id="joinInfoPw" name="joinInfoPw" required>
                        </div>
                        <div class="offset-3 col-9">
                            <input type="password" placeholder="비밀번호를 재확인해 주세요." id="joinInfoPwRe" name="joinInfoPwRe" required>
                        </div>

                    </div>
                    <div class="row mb-4">
                        <div class="col-3 joinFormLeft">
                            닉네임
                        </div>
                        <div class="col-4">
                            <input type="text" placeholder="닉네임을 입력해 주세요." id="joinInfoNick" name="joinInfoNick" required onchange="validNickname = false;">
                        </div>
                        <div class="col-2">
                            <select id="joinInfoFixed" name="joinInfoFixed" onchange="validNickname = false;">
                                <option value="fixed">
                                    고정닉
                                </option>
                                <option value="noFixed">
                                    비고정닉
                                </option>
                            </select>
                        </div>
                        <div class="col-3 d-flex justify-content-center">
                            <button type="button" class="btn btn-secondary" onclick="nicknameCheck()">닉네임 확인</button>
                        </div>
                        <div class="offset-3 col-9 infoTip">
                            2~20자 닉네임을 입력해 주세요.(띄어쓰기는 할 수 없습니다.)
                        </div>
                        <div class="offset-3 col-9 infoTip text-primary" id="isNicknameValid">

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-3 joinFormLeft">
                            이메일
                        </div>
                        <div class="col-9">
                            <input type="email" placeholder="이메일을 입력해 주세요." name="joinInfoEmail" id="joinInfoEmail" required>
                        </div>
                    </div>
                </fieldset>
                <button type="submit" id="joinSubmit" hidden />
            </form>
        </div>

    </div>
    <div class="row">&nbsp;</div>
    <button class="btn btn-secondary float-end" onclick="nextBtnClicked()">다음</button>
</div>
<%@ include file="includes/footer.jsp" %>
<style>
    .joinProgress
    {
        position: relative;
        width: 454px;
        height: 398px;
        top: -134px;
    }
    .progressWrapper
    {
        height: 134px;
        overflow: hidden;
    }
    .infoBox
    {
        border: 1px #cecdce solid;
        border-radius: 5px;
    }
    .joinFormBox
    {
        width: 703px;
        padding: 49px 0 48px;
    }
    .joinFormBox input
    {
        width: 100%;
    }
    .joinFormLeft
    {
        font-size: 14px;
        font-weight: bold;
    }
    .infoTip
    {
        font-size: 12px;
        color: #999;
    }
</style>
</body>
</html>
