<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h3>게시글 목록</h3>
<div class="center">
	<form action="boardList.do">
		<div class="row">
			<!-- 검색조건(title, writer 검색) -->		
			<div class="col-sm-4">
				<select name="searchCondition" class="form-control">
					<option value="">선택하세요</option>
					<option value="T" ${sc eq 'T'? 'selected' : ''}>제목</option>					
					<option value="W"${sc eq 'W'? 'selected' : ''}>작성자</option>
					<option value="TW"${sc eq 'TW'? 'selected' : ''}>제목 & 작성자</option>
				</select>			
			</div>
			<!-- 검색키워드 -->
			<div class="col-sm-5">
				<input type="text" value="${kw}"name="keyword" class="form-control">
			</div>
			<!-- 조회버튼 -->
			<div class="col-sm-2">
				<input type="submit" value="조회" class="btn btn btn-primary">
			</div>
		</div> <!--  end of div.row -->
	</form>
</div><!--  end of div.center -->

<c:choose>
	<c:when test="${!empty message}">
		<p>${message}</p>
	</c:when>
	
	<c:otherwise>
		<table class = "table">
			<thead>
				<tr>
					<th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th>
				</tr>
			</thead>
			<tbody> <!-- for (BoardVO board : list ) -->
				<c:forEach var = "board" items = "${list}">
				<tr>
					<td><c:out value="${board.boardNo}"/></td> <!-- 속성을 불러와서 하는것처럼 보이지만 아님 게터가 없으면 작동이 안됨. @data대신 @setter쓰면 안됨 -->
					<td><a href="getBoard.do?keyword=${kw}&searchCondition=${sc}&page=${paging.page}&bno=${board.boardNo}">${board.title}</a></td> 
					<td>${board.writer}</td>
					<td><fmt:formatDate value="${board.creationDate}" pattern="YYYY.MM.dd HH:mm:ss"/></td>
				</tr>
				</c:forEach>
			</tbody>
		
		</table>
			<!-- 페이징 -->
		<nav aria-label="...">
		  <ul class="pagination">
		    <li class="page-itme ${paging.prev ? '' : 'disabled'} ">
		      <a class="page-link" href="boardList.do?keyword=${kw}&searchCondition=${sc}&page=${paging.startPage-1}">Previous</a>
		    </li>
		    <c:forEach var = "pg" begin="${paging.startPage}" end="${paging.endPage}">
		    <c:choose>
		    	<c:when test="${paging.page==pg}"> <!--  현재 페이징 -->
		    		<li class="page-item active" aria-current="page">
		    		<a class="page-link" href="boardList.do?keyword=${kw}&searchCondition=${sc}&page=${pg}">${pg}</a></li>    	
		    	</c:when>
		    	
		    	<c:otherwise> <!-- 현재 페이지 아닌 경우. -->
		    		<li class="page-item"><a class="page-link" href="boardList.do?keyword=${kw}&searchCondition=${sc}&page=${pg}">${pg}</a></li>
		    	</c:otherwise>
		    </c:choose>
		    </c:forEach>
		    <li class="page-item ${paging.next ? '' : 'disabled'}">
		      <a class="page-link" href="boardList.do?keyword=${kw}&searchCondition=${sc}&page=${paging.endPage+1}">Next</a>
		    </li>
		  </ul>
		</nav>
		<p>${paging}</p>
	</c:otherwise>
</c:choose>




<!--  
<p>${'문자열, 숫자, boolean null'}</p> el표현식
<p>${3+5}</p>
<p>${3+5>10}</p>
<p>${3+5>10 ? '참입니다':'거짓입니다'}</p>
 내장되어져있는 객체를 표현할때 가장 많이씀 el은
<p>${requestScope}</p>
<p>${msg} </p>


<%
	String name = "hong";
%>
<c:set var="name" value="Hongkildong"></c:set>
<c:out value="${name}"></c:out>
<c:set var="age" value="20"></c:set>
<c:out value="${age>=20?'성인':'미성년'}"></c:out>
<c:if test="${name == 'Hongkildong'}">
	<p>맞습니다.</p>
</c:if>
<c:if test="${name eq 'Hongkildong'}">
	<p>맞습니다.</p>
</c:if>
<c:if test="${name != 'Hongkildong'}">
	<p>아닙니다.</p>
</c:if>
<c:if test="${name ne 'Hongkildong'}">
	<p>아닙니다.</p>
</c:if>
-->



