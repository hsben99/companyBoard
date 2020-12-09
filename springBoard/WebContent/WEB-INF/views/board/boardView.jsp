<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>boardView</title>
</head>
<body>
<script>
$j(document).ready(function(){
	
	$j('#delete').on('click',function(){
		$j.ajax({
			url :"/board/boardDelete.do" ,
			dataType:"json",
			type: "GET",
			data :{
				boardType: "${board.boardType}",
				boardNum : "${board.boardNum}"
			},
			success:function(data, textStatus, jqXHR){
				alert('삭제성공'); 
				alert(data.success); 
				location.href="/board/boardList.do"; 
			},
			error:function(jqXHR, textStatus, errorThrown){
				alert('삭제실패');
			}
		});//ajax
	});//click
});//readey

</script>
<table align="center">
	<tr>
		<td>
			<table border ="1">
				<tr>
					<td width="120" align="center">
					Title
					</td>
					<td width="400">
					${board.boardTitle}
					</td>
				</tr>
				<tr>
					<td height="300" align="center">
					Comment
					</td>
					<td>
					${board.boardComment}
					</td>
				</tr>
				<tr>
					<td align="center">
					Writer
					</td>
					<td> 
					${userName}
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr> 
		<td align="right">
			<a href="/board/boardList.do">List</a>
			<a href ="/board/${board.boardType}/${board.boardNum}/boardUpdatef.do">update</a>
					<a href="javascript:;" id="delete">delete</a>
		</td>
	</tr>

</table>	
</body>
</html>