<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>글 상세 페이지 </h3>
<p>${sc},${kw}</p>

	<% 
	BoardVO board = (BoardVO)request.getAttribute("board");
	%>
<table class="table">

	<tr>
		<th>글번호 : </th><td>${board.boardNo}</td>
	</tr>
	<tr>
		<th>제목 : </th><td>${board.title}</td>
	</tr>
	<tr>
		<th>글쓴이 : </th><td>${board.writer}</td>
	</tr>
	<tr>
		<th>글내용 : </th><td>${board.content}</td>
	</tr>
	<tr>
		<th>조회수 : </th><td>${board.viewCnt}</td>
	</tr>
	<tr>
		<th>작성일 : </th><td>${board.creationDate}</td>
	</tr>
	<tr>
		<th>이미지 : </th><td><img width="150px" src="images/${board.image}"></td>
	</tr>
	

</table>

<form action="removeBoard.do" name="actForm">
	<input type="hidden" name="keyword" value="${kw}">
	<input type="hidden" name="searchCondition" value="${sc}">
	<input type="hidden" name="page" value="${page}">		
	<input type="hidden" name="bno" value="${board.boardNo}">	
</form>

<a class ="btn btn-danger " onclick= "form_submit('boardList.do')" >목록으롷 a</a>
<input type="button" onclick="location.href='boardList.do?page=${page}'" value ="목록으로">
<input type="button" ${board.writer ne logid ? 'disabled' : ''} onclick="location.href='modifyBoard.do?page=${page}&bno=${bno}'" value ="수정버튼">
<a class ="btn btn-danger " onclick= "form_submit('removeBoard.do')" >삭제버튼 a</a>
<input type="button" onclick="location.href='removeBoard.do?keyword=${kw}&searchCondition=${sc}&page=${page}&bno=${bno}'" value ="삭제인풋버튼">
<c:if test="${!empty message}">
	<span style="color:red;">${message}</span>
</c:if>

<script>
	function form_submit(uri) {
		document.forms.actForm.action=uri;
		document.forms.actForm.submit();
	}
</script>
<jsp:include page="../includes/footer.jsp"></jsp:include>
