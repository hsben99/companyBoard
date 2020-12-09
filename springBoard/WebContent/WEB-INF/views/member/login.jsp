<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title> 
<script>

	function login() {
		var id = $j('#id').val();
		var pw = $j('#pw').val();

		$j.ajax({
			url:"/member/loginAction.do",
			data:{
				USER_ID:id,
				USER_PW:pw
				},
			type:"GET",
			success:function(data){
				if(data =='0'){//id실패
					
					if(id.length == 0){
						alert('아이디 입력이 안되었습니다.');
						$j('#id').focus();
					}else{
						alert('아이디가 틀렸습니다.');
						$j('#id').focus();
					}
					 
				}else if(data =='2'){
					alert('로그인 성공'); 
					location.href='/board/boardList.do';
				}else if(data =='3'){
					if(pw.length == 0){
						alert('비밀번호를 입력해주세요.');
						$j('#pw').focus();
					}else{
					alert('비밀번호가 틀립니다.');
					$j('#pw').focus();
					}
				}
			},//success
			error:function(){ 
				alert('서버에러: 잠시 후 다시 시도하세요');
			}
		});//ajax
	}//login
</script>
</head>
<body>
	<form action="" id="formData">
		<table>
			<tr>
				 
				<td align="left">
				<!-- 리스트로 이동!!
				<a href="/board/boardList.do">List</a>--> 
				
					<table border="1">
						<tr>
							<td width="100" align="center">id</td>
							<td width="200" align="left"><input type="text" name="USER_ID"
								id="id" required="required"></td>
						</tr>
						<tr>
							<td width="100" align="center">pw</td>
							<td width="200" align="left"><input type="password"
								name="USER_PW" id="pw"><br></td>
						</tr>

					</table>
				<td>
			</tr>
			<tr>
				<td align="right"><a href="javascript:;" onclick="login()">login</a></td>
			</tr>
		</table>
	</form>


</body>
</html>