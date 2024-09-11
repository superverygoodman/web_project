<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	div.reply div {
		margin: auto;
		
	}
	div.reply ul {
		list-style-type:none;
	}
	div.reply span{
		display: inline-block;
	}
</style>
<script>

	const bno = '${board.boardNo}';
	const writer = '${logid}';
</script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="js/replyService.js"></script>
<script src = "js/replyBoard.js"></script> 

<h3>글 상세 페이지 </h3>
<p>${sc},${kw}</p>

	<% 
	BoardVO board = (BoardVO)request.getAttribute("board");
	%>
<p>${bno}</p>
<p>${writer}</p>
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
<input type="button" onclick="location.href='boardList.do?keyword=${kw}&searchCondition=${sc}&page=${page}'" value ="목록으로">

<input type="button" ${board.writer ne logid ? 'disabled' : ''} onclick="location.href='modifyBoard.do?keyword=${kw}&searchCondition=${sc}&page=${page}&bno=${bno}'" value ="수정버튼">
<a class="btn btn-secondary" href = "modifyBoard.do?keyword=${kw}&searchCondition=${sc}&page=${page}&bno=${bno}">수정버튼a</a>


<a class ="btn btn-danger " onclick= "form_submit('removeBoard.do')" >삭제버튼 a</a>
<input type="button" onclick="location.href='removeBoard.do?keyword=${kw}&searchCondition=${sc}&page=${page}&bno=${bno}'" value ="삭제인풋버튼">
<c:if test="${!empty message}">
	<span style="color:red;">${message}</span>
</c:if>

<div class="container reply">
	<!-- 댓글 등록 -->
	<div class="header">
		<input type="text" id="reply" class="col-sm-8">
		<button id="addReply" class="btn btn-primary" data-page=1>댓글등록</button>
	</div>
	<!-- 댓글 목록 -->
	<div class="content">
		<ul>
			<li>
				<span class="col-sm-2">글번호</span>
				<span class="col-sm-5">댓글내용</span>
				<span class="col-sm-2">작성자</span>								
				<span class="col-sm-2">삭제</span>				
			</li>
			<li>
				<hr/>
			</li>
			<li id="template" style="display:none">
				<span class="col-sm-2">24</span>
				<span class="col-sm-5">테스입니다</span>
				<span class="col-sm-2">user01</span>								
				<span class="col-sm-2"><button class="btn btn-danger">삭제</button></span>				
			</li>
		</ul>
	</div>
	<!-- 댓글 페이징 -->
	<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item disabled">
      <a class="page-link">Previous</a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#">Next</a>
    </li>
  </ul>
</nav>
</div>


<script>
	function form_submit(uri) {
		document.forms.actForm.action=uri;
		document.forms.actForm.submit();
	}
</script>

