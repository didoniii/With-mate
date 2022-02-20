<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>같이 가치</title>
</head>
<body>
	<div class="container flex-column">
		
	<!-- header -->
		<div class="align-end head">
			<div class="col-md-9">
				<img id="logo" alt="" src="${logo}" height="100">
			</div>
			<div class="align-center" style="margin-bottom: 15px;">
				<span style="color: gray;"> 이미 가입하셨나요? </span>
				<a href="${_member}/loginForm.do" class="btn btn-lg btn link">로그인하기</a>
			</div>
		</div>
	
	<!-- body -->
	<div class="col-md-5 mg-auto box">
		<form action="${_member}/join.do" method="post" name="frm">
			<div class="form-group">
				<label for="m_id">이메일을 입력하세요</label>
				<div class="input-group">
					<input type="email" id="m_id" name="m_id" class="form-control" 
					required="required" placeholder="이메일">
					<span class="input-group-btn">
						<button id="idChkBtn" class="btn btn-primary" type="button">확인</button>
					</span>
				</div>
				<div class="msg err"></div>
			</div>
			<div id="aCollapse" class="form-group collapse">
				<label for="auth">본인확인을 위해 이메일로 보낸 인증번호를 입력해주세요.</label>
				<div class="input-group">
					<input type="text" id="auth" class="form-control" 
					required="required" placeholder="인증번호">
					<span class="input-group-btn">
						<button id="authChkBtn" class="btn btn-primary" type="button"> 확인 </button>	
					</span>
				</div>
				<div class="msg err"></div>
			</div>
			<div id="pCollapse" class="collapse">
				<div class="form-group">
					<label for="password">비밀번호를 입력하세요.</label>
					<input type="password" id="password" name="password" class="form-control"
					required="required" placeholder="비밀번호">
				</div>
				<div class="form-group">
					<label for="passwordChk">비밀번호를 확인해주세요.</label>
					<input type="password" id="passwordChk" name="passwordChk" class="form-control" 
					required="required" placeholder="비밀번호 확인">
					<div class="msg err"></div>
				</div>
			</div>
			<div id="nCollapse" class="collapse">
				<div class="form-group">
					<label for="nickname">사용하실 닉네임을 입력하세요.</label>
					<input type="text" id="nickname" name="nickname" class="form-control"
					required="required" placeholder="닉네임">
					<div class="j-between">
						<div class="msg err"></div>
						<button type="submit" class="btn btn-primary mg-t-5" disabled="disabled">가입하기</button>
					</div>
				</div>
			</div>
			
		</form>
	</div>
	</div>	
	
	<div class="modal fade" id="myModal">
		<div class="modal-dialog j-center">
			<div class="modal-content col-md-8 pd-0">
				<div class="modal-header bg-info" style="border-top-left-radius: 5px; border-top-right-radius: 5px;">
					<h3 id="profileTitle" class="modal-title align-end" style="font-famaily: 'Noto Sans KR'">
						<i class="material-icons-outlined mg-r-5" style="font-size: 32px;">celebration</i>
						가입을 축하드립니다 !
					</h3>
				</div>
				<div class="modal-body" style="font-family: 'Noto Sans KR'">
					<p class="lead mg-b-5">원한다면<strong class="mg-r-5 mg-l-5">프로필 정보</strong>입력을 통해</p>
					<p class="lead mg-b-5">당신을 더욱 표현해보세요 ! 원활한 매칭에 더욱 도움이 됩니다.</p>
				</div>
				<div class="modal-footer">
					<button id="profileForm" class="btn btn-primary">GO!</button>
					<button id="loginForm" class="btn btn-default">건너뛰기</button>
				</div>
			</div>	
		</div>
	</div>
	
	<div id="background"></div>
	<script type="text/javascript" src="${script}"></script>
	<script type="text/javascript">
	
		document.querySelector('#idChkBtn').addEventListener('click', idChk);
		document.querySelector('#authChkBtn').addEventListener('click', authUser);
		frm.password.addEventListener('change', passwordChk);
		frm.passwordChk.addEventListener('change', passwordChk);
		frm.nickname.addEventListener('change', nickChk);
		
		// form안에서 keydown event가 발생했을 때 그 key code가 13(enter)이면 submit막기, 현재 커서부분 블러 처리 >> onchange 이벤트 발생
		frm.addEventListener("keydown", function(event)  {
		    if ((event.keyCode || event.which) === 13) {
		    	event.target.blur();
		    	event.preventDefault();
		    }
		});
		
		// 아이디 중복체크
		async function idChk(event){
			var id = document.querySelector('#m_id').value,
			msg = document.questySelectorAll('.msg')[0],
			sendData = 'm_id='+id,
			regExp = new RegExp('^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$', 'i');
			
			// 입력한 아이디가 이메일 형식을 만족하지 않는 경우
			if(regExp.test(id)){
				var result = await fetch('${_member}/idChk.do',{
					method : 'POST',
					body : sendData,
					headers : {
						'Content-Type': 'application/x-www-form-urlencoded'
					}
				}).then(function(response){
					return response.text();
				})
				
				if(result == '1'){
					msg.innerHTML = '사용 가능한 이메일입니다.';
					msg.classList.replace('err','ok');
					
					//인증부분 열기
					$('#aCollapse').collapse('show');
					
					authMailSend(id);
					return;
					
				}else if(result != '1'){
					msg.innerHTML = '중복된 이메일입니다.';
				}
				
			}else {
				msg.innerHTML = '이메일 형식과 맞지 않습니다';
			}
			
			msg.classList.replace('ok','err');
			
			// 비밀번호 부분이 열려있으면 비밀번호, 비밀번호 확인 input의 값을 지우고 닫음
			if ($('#aCollapse').hasClass('in')){
				$('#pCollapse').collapse('hide');
				document.querySelector('auth').value = '';
				document.querySelectorAll('.msg')[1].innerHTML = '';
			}
			if ($('#pCollapse').hasClass('in')){
				$('#pCollapse').collapse('hide');
				document.querySelector('#password').value = '';
				document.querySelector('#passwordChk').value = '';
				document.querySelectorAll('.msg')[2].innerHTML = '';
			}
			
			// 이메일 부분이 열려있으면 이메일 input값을 지우고 닫음
			if ($('nCollapse').hasClass('in')){
				$('nCollapse').collpase('hide');
				document.querySelector('#nickname').value = '';
				document.querySelectorAll('.msg')[3].innerHTML = '';
				document.querySelector('button[type="submit"]').setAttribute('dusabled', 'disabled');
			}
		}
		var num = '';
		
		function authUser(){
			var auth = document.querySelector('#auth'),
				msg = document.querySelectorAll('.msg')[1];
			
			// 입력한 번호랑 인증번호가 일치하는 경우
			if (auth.value ==num){
				msg.classList.replace('err','ok');
				msg.innerHTML = '인증번호가 일치합니다.';
				
				$('#pCollapse').collapse('show');
				return;
				
			}else{
				msg.classList.replace('ok','err');
				msg.innerHTML = '인증번호가 일치하지 않습니다';
				
				if ($('#pCollapse').hasClass('in')){
					$('#pCollapse').collapse('hide');
					document.querySelector('#password').value = '';
					document.querySelector('#passwordChk').value = '';
					document.querySelectorAll('.msg')[2].innerHTML = '';
					
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>