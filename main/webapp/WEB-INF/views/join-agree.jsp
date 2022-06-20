<%--
  Created by IntelliJ IDEA.
  User: WonSeungJu
  Date: 2022-06-19
  Time: 오후 4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="includes/common-head.jsp" %>
<body>
<%@ include file="includes/join-header.jsp" %>
<script>
    function agreeBtnClicked()
    {
        let serviceCheked = $('#service_agree').get(0).checked;
        if(!serviceCheked)
        {
            toastr.info('서비스 이용약관에 동의해주세요.');
            return;
        }
        let personalCheked = $('#personal_agree').get(0).checked;
        if(!personalCheked)
        {
            toastr.info("개인정보처리방침에 동의해주세요.");
            return;
        }
        location = 'info';
    }
</script>
<div class="container">
    <div class="row">
        <div class="col-12 d-flex justify-content-center progressWrapper">
            <img class="joinProgress " src="/resources/img/join_progress.png"/>
        </div>
    </div>
    <div class="row">
        <h3>약관 동의</h3>
        <hr>
    </div>
    <div class="row">
        <h4>서비스 이용약관</h4>
        <div class="policy">
        </div>
    </div>
    <div class="float-end">
      <span>
        <input type="checkbox" id="service_agree">
        <label for="service_agree">내용을 확인하였으며, 동의합니다.</label>
      </span>
    </div>
    <div class="clear"></div>
    <hr class="hr-dash" />
    <div class="row">
        <h4>개인정보처리방침</h4>
        <div class="policy">

        </div>
    </div>
    <div class="float-end">
      <span>
        <input type="checkbox" id="personal_agree">
        <label for="personal_agree">내용을 확인하였으며, 동의합니다.</label>
      </span>
    </div>
    <div class="clear"></div>
    <div class="row">&nbsp;</div>
    <button class="btn btn-secondary float-end" onclick="agreeBtnClicked()">다음</button>
</div>
<%@ include file="includes/footer.jsp" %>
<style>
    .joinProgress
    {
        width: 454px;
        height: 398px;
    }
    .progressWrapper
    {
        height: 134px;
        overflow: hidden;
    }
    .policy
    {
        padding: 24px;
        height: 180px;
        overflow-y: scroll;
        border: 1px #bbb solid;

    }
</style>


</body>
</html>
