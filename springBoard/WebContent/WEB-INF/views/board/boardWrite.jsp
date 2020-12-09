<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="/WEB-INF/views/common/common.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>boardWrite</title>
</head>
<script type="text/javascript"> 

	$j(document).ready(function(){
		
		$j("#submit").on("click",function(){
			if($j('#boardTitle').val() == '' ||$j('#boardComment').val() == '' ){
				alert('제목 또는 내용을 입력하세요');
				return false;
			}
			
			var $frm = $j('.boardWrite :input');
			var param = $frm.serialize();
			
			$j.ajax({
			    url : "boardWriteAction.do",
			    dataType: "json",
			    type: "POST",
			    data : param,
			    success: function(data, textStatus, jqXHR)
			    {
					alert("작성완료");
					alert("메세지:"+data.success);
					location.href = "boardList.do";
			    },
			    error: function (jqXHR, textStatus, errorThrown)
			    {
			    	alert("실패");
			    }
			});
		});
	});
	

</script>
<body>
<form class="boardWrite">
	<table align="center">
		<tr>
			<td align="right">
			<input id="submit" type="button" value="작성">
			<input id="" type="button" value="행추가">
			</td>
		</tr>
		<tr>
			<td>
				<table border ="1"> 
				<tr>
						<td width="120" align="center">
						Type
						</td>
						<td width="400">
							<select name="boardType" >
							<c:forEach items="${typeList}" var="typeList" >
								<option value="${typeList.CODE_ID}">${typeList.CODE_NAME}</option>
							</c:forEach>
								
							</select>												 
						</td>
					</tr>
					
					<tr>
						<td width="120" align="center">
						Title
						</td>
						<td width="400">
						<input name="boardTitle" type="text" size="50" value="${board.boardTitle}" id="boardTitle"> 
						</td>
					</tr>
					<tr>
						<td height="300" align="center">
						Comment
						</td>
						<td valign="top">
						<textarea name="boardComment"  rows="20" cols="55" id="boardComment">${board.boardComment}</textarea>
						</td>
					</tr>
					<tr>
						<td align="center">
						Writer
						</td>
						<td>
						${logName}
						<input type="hidden" value="${logId}" name="creator">
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="right">
				<a href="boardList.do">List</a>
			</td>
		</tr>
	</table>
</form>	
</body>
</html>