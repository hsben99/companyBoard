<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>list</title>
</head>
<body>
	<table align="center">
		<tr>
		<td >
			<c:if test="${logId==null}">
				<a href="/member/login.do">login</a> 
				<a href="/member/join.do">join</a>
			</c:if>
			<c:if test="${logId!=null}">
				${logName}
			</c:if>
			<span style="float: right;">
				total : ${totalCnt}
			</span>
		</td>
		</tr>
		<tr>
			<td>
				<table id="boardTable" border="1">
					<tr>
						<td width="80" align="center">Type</td>
						<td width="40" align="center">No</td>
						<td width="300" align="center">Title</td>
					</tr>
					<c:forEach items="${boardList}" var="list">
						<tr>
							<td align="center">
							<c:forEach items="${boardTypeList}"	var="typeList">
									<c:if test="${list.boardType==typeList.CODE_ID}">${typeList.CODE_NAME}</c:if>
								</c:forEach></td>
							<td>${list.boardNum}</td>
							<td><a href="/board/${list.boardType}/${list.boardNum}/boardView.do">${list.boardTitle}</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
		<td align="right">
			<a href="/board/boardWrite.do">글쓰기</a>
			<c:if test="${logId != null}">
				<a href="/member/logout.do">로그아웃</a>
			</c:if>
			</td>
		</tr>
		<tr>
			<td>
				<form action="/board/boardList.do" id="checkForm">
					<input type="checkbox" name="searchCheck" id="checkAll"	>전체
					<c:forEach items="${boardTypeList}"	var="typeList">
					 	<input type="checkbox" name="searchCheck"value="${typeList.CODE_ID}" class="check">${typeList.CODE_NAME}
					</c:forEach>
					<!--걍해보는거-->
						<input type="hidden" name="pageNo"value="1" >
					<!--걍해보는거-->
					<input type="submit" value="조회" id="searchBtn">
				</form>
			</td>
			
		</tr>
	</table>
	
	
	
	<!--페이징 로직  
	1. 검색 조건에 맞는 total 게시물 수를 구한다.
	2. 한 페이지당 보여줄 페이징의 개수를 정한다
	3. 현재페이지 로 Spage, Epage, lastPage 를구한다
	
		ex)1~5까지 보여준다고 할때
		
	    sPage = ((currPage - 1) / 5) * 5 +1
	    
	    int ePage=5; 
	    	if(ePage > lastPage){
	    		ePage = lastPage;
	    	} else{
	    		ePage = sPage + hmiPage -1;
	    	}
	    
	    lastpage = (int)math.ceil(total / (double)currPageLow);
	    	ex) 100 / 10 = 10
	    	ex) 101 / 10 = 10.??? = 11
	-->
	
	
	<script type="text/javascript">
		$j(document).ready(function() {
			$j("#checkAll").change( // 체크박스 전체체크, 해제 기능
			function() {
				if (this.checked) {
					$j("#checkForm").children("input").prop("checked", true);
					
				} else {
					$j("#checkForm").children("input").prop("checked", false);
				}
			});//change
			
			$j('.check').click(function(){
				$j("#checkAll").prop("checked", false);
			});
			
		});//readey
	</script>


</body>
</html>