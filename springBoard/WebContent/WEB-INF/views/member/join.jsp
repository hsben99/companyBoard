<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script>
	var idCheck = false;
	var pwCheck = false;
	var pcCheck =false;
	var nameCheck = false;
	var phoneCheck = false;
	var postNoCheck = false;

	$j(function() { 
		
		
		//중복확인
		$j('#idCheckBtn').click(function(){
			USER_ID = $j('#id').val();	
			if($j('#id').val() !=''){//notNull일때
				$j.ajax({
					url:"/member/idCheck.do",
					type:"POST",
					data : {USER_ID:USER_ID},
					success:function(data){
						if(data =="1"){
								alert('가입가능한 아이디입니다');
								idCheck=true;
						}else{ 
							alert('이미 있는 아이디입니다.');
							$j('#id').focus();
							idCheck=false;
						}
					},
					error:function(data){
						alert(data);
					}
				});//ajax
			}else{
				alert('아이디를 입력하세요');
				$j('#id').focus();
			}	
		});//click
		
		//id 값이 바뀌면
		$j('#id').on("change",function(){
			idCheck=false;
		});
			
		
		//id 한글안되게
		$j('#id').on("propertychange change keyup paste input", function() {
			var id = $j('#id').val();
			$j(this).val($j(this).val().replace(/[ㄱ-ㅎ]|[ㅏ-ㅣ]|[가-힇]/g,''));
			
			//id 영어랑 특수문자만 가능하게 해야하나??(한자 같은거 안들어가게)
			//로직: 영어나 숫자나 특수문자를 제외한것을 입력하면 alert 뜨고 idCheck=false; 
			var check_all = /[^0-9a-zA-Z~!@#$%^&*()_+|<>?:{}]/g; //세개다
			
			$j(this).val(
					$j(this).val().replace(check_all,'')
			);
			 
			//--------------
				
			 
			
			
		});
		
		

			
		
		$j('#pw').on("propertychange change keyup paste input", function() {
			//패스워드 글자수
			var pw1 = $j('#pw').val();
			if (pw1.length < 6 || pw1.length > 12) {
				$j('#pwMsg').html('비밀번호는6~12자리로 입력하세요');
			}else{
				$j('#pwMsg').html('');
				pwCheck= true;
			}
		});
		
		$j('#pwCheck').on("propertychange change keyup paste input",
				function() {
					//패스워드와 체크값이 같은지 확인
					var pwCheck1 = $j('#pw').val();
					var pwCheck2 = $j('#pwCheck').val();
					
					if(pwCheck2 ==''){
						$j('#pwCheckMsg').html('pwCheck을 입력해주세요');
					}					
					else if (pwCheck1 != pwCheck2) {
						$j('#pwCheckMsg').html('패스워드와 동일한 값을 입력하세요');
						pcCheck = false;
					} else {
						$j('#pwCheckMsg').html('');
						pcCheck = true; 
					}
				});//pwCheck on
				
				//name
				$j('#name').on("propertychange change keyup paste input", function() {
					var name = $j('#name').val();
					if(name==''){//name이 Null일때
						nameCheck = false;
					}else{
						nameCheck=true;
					}
					
					//name 한글만 되게
					$j(this).val(
					  $j(this).val().replace(/[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\ \\]|[\'"' \"'"]/g,'')
					);
				});
				
				//phone 
				$j('#phone2').on("propertychange change keyup paste input focusout", function() {
					//숫자만 들어가게
					$j(this).val($j(this).val().replace(/[^0-9]/g,''));
					//4글자  미만 안되게
					if($j(this).val().length<4){
						$j('#phoneMsg').html('핸드폰번호 각 칸은 4자리입니다');
						phoneCheck=false;
					}
				});//phone2
				
				$j('#phone3').on("propertychange change keyup paste input focusout", function() {
					$j(this).val($j(this).val().replace(/[^0-9]/g,''));
					//4글자  미만 안되게
					if($j(this).val().length<4){
						$j('#phoneMsg').html('핸드폰번호 각 칸은 4자리입니다');
						phoneCheck=false;
					}
				});//phone3
				
				$j('.phone').on("propertychange change keyup paste input focusout", function() {
					if($j('#phone2').val().length == 4 && $j('#phone3').val().length == 4 ){
						$j('#phoneMsg').html('');
						phoneCheck=true;
					}
				});//phones

				//postNo
					$j('#postNo').on("propertychange change keyup paste input", function() {
						//숫자랑 -만 입력되게
							$j(this).val($j(this).val().replace(/[^0-9-]/g,''));
						//형식맞는지 확인
						if($j(this).val() != $j(this).val().replace(/^\d{3}-\d{3}$/g,'')
							//아예입력안하면
							|| $j(this).val() ==''){
							$j('#postNoMsg').html('');
							postNoCheck = true;
						}else{
							$j('#postNoMsg').html('xxx-xxx 형식으로 입력하세요');
							postNoCheck = false;
						}
						//postNo 자동 '-' 추가			      
			            $j('#postNo').keydown(function (event) {
			             var key = event.charCode || event.keyCode || 0;
			             $text = $j(this); 
			             if (key !== 8 && key !== 9) {
			                 if ($text.val().length === 3) {
			                     $text.val($text.val() + '-');
			                 }
			             }
			       	  }); //자동 '-'추가
					}); //pontNo on
	});//ready

	
	function inCheck() {
		
		if(idCheck == false){ //id조건 불충족시
			alert('id중복체크 하세요');
			$j('#id').focus();
			return false;
		}
		
		if(pwCheck == false){ //pw조건 불충족시
			alert('password는 6~12자리입니다.'); 
			$j('#pw').focus();
			return false;
		}
		
		if(pcCheck == false){//pc 조건 불충족시
			var pwCheck2 = $j('#pwCheck').val();
			if(pwCheck2 ==''){
				alert('pwCheck을 입력해주세요');
				$j('#pwCheck').focus();
			}else{
				alert('pwCheck 가 password 와 다릅니다.');
				$j('#pwCheck').focus();
			}				
			return false;
		}
		if(nameCheck == false){ //name조건 불충족시
			alert('이름을 입력하세요');
			$j('#name').focus();
			return false;
		}
		
		if(phoneCheck ==false){ //phone 조건 불충족시
			//phone2 공백 
			if($j('#phone2').val() ==''){
				alert('phone입력 안된곳이 있습니다 ');
				$j('#phone2').focus();
				return false;
			}
			//phone2 length
			if($j('#phone2').val().length < 4){
				alert('phone은 4글자씩 입력하세요');
				$j('#phone2').focus();
				return false; 
			}
			//phone3  공백 
			if($j('#phone3').val() =='' ){
				alert('phone입력 안된곳이 있습니다 ');
				$j('#phone3').focus();
				return false;
			}
			//phone3 length
			if($j('#phone3').val().length < 4 ){
				alert('phone은 4글자씩 입력하세요');
				$j('#phone3').focus();
				return false; 
			}
		}
		
		if(postNoCheck == false){//postNo 불충족시
			if($j('#postNo').val() ==''){
				alert('postNo를 입력하세요');
				$j('#postNo').focus();
				return false;
			}else {
				alert('postNo 형식을 준수하세요');
				$j('#postNo').focus();
				return false;
			}
		}
		
		if (idCheck == true && pwCheck == true && pcCheck==true&&nameCheck == true
				&& phoneCheck == true && postNoCheck == true){
			//조건이 다 만족되면
			alert('조건만족');
			$j.ajax({
				url:"/member/joinAction.do", 
				type:"GET",
				data:$j('#formData').serialize(),
				success:function(data){
					alert(data+"건 성공");
					location.href="/board/boardList.do"; 
				},
				error:function(){
					
				}
				
			});//ajax
			
		}//if
		else{// incheck 조건 불충족시
			alert('조건불충족입니다');
		}
		}//inCheck
		
</script>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="" id="formData">
		<table>
			<tr>
				<td align="left"><a href="/board/boardList.do">List</a>
					<table border="1">
						<tr>
							<td width="100" align="center">id</td>
							<td width="300" align="left"><input type="text" name="USER_ID"
								id="id" required="required" maxlength="14"> <input
								type="button" value="중복확인" id="idCheckBtn"> <span
								id="idCheckMsg"></span></td>
						</tr>
						<tr>
							<td width="100" align="center">pw</td>
							<td width="300" align="left"><input type="password"
								name="USER_PW" id="pw" maxlength="15"><br> <span id="pwMsg"></span></td>
						</tr>
						<tr>
							<td width="100" align="center">pw check</td>
							<td width="300" align="left"><input type="password"
								name="pwCheck" id="pwCheck"> <br> <span
								id="pwCheckMsg"></span></td>

						</tr>
						<tr>
							<td width="100" align="center">name</td>
							<td width="300" align="left"><input type="text" name="USER_NAME"
								id="name" maxlength="5"></td>
						</tr>
						<tr>
							<td width="100" align="center">phone</td>
							<td width="300" align="left">
							<select name="USER_PHONE1">	
									<c:forEach items="${phoneList}" var="phoneList">
										<option value="${phoneList.CODE_ID}">${phoneList.CODE_NAME}</option>
									</c:forEach>
							</select> - 
							<input type="text" name="USER_PHONE2" id="phone2" class="phone"
								style="width: 42px" maxlength="4">- <input type="text"
								name="USER_PHONE3" id="phone3" class="phone" style="width: 42px"
								maxlength="4"> <br> <span id="phoneMsg"></span></td>
						</tr>

						<tr>
							<td width="100" align="center">postNo</td>
							<td width="300" align="left"><input type="text"
								name="USER_ADDR1" id="postNo" maxlength="7"> <br> <span
								id="postNoMsg"></span></td>
						</tr>
						<tr>
							<td width="100" align="center">address</td>
							<td width="300" align="left"><input type="text"
								name="USER_ADDR2" id="address" maxlength="29"></td>
						</tr>
						<tr>
							<td width="100" align="center">company</td>
							<td width="300" align="left"><input type="text"
								name="USER_COMPANY" id="company" maxlength="19"></td>
						</tr>
					</table>
				<td>
			</tr>
			<tr>
				<td align="right"><a href="javascript:;" onclick="inCheck()">join</a></td>
			</tr>
		</table>
	</form>
</body>
</html>