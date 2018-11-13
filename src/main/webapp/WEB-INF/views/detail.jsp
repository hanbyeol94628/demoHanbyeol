<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>      
    
<layoutTag:layout> 
	<div class="container">
		<div class="col-xs-12" style="margin: 15px auto;">
			<label style="font-size:20px;"><span class="glyphicon glyphicon-edit">&nbsp;글 보기</span></label>
		</div>
	 
		<div class="cos-xs-12">
		    <form action="/insertProc" method="post">
		      <dl class="dl-horizontal">
		        <dt>제목</dt>
		        <dd>${detail.subject}</dd>
		        
		        <dt>제목</dt>
		        <dd>${detail.writer}</dd>
		      
		        <dt>작성 날짜</dt>
		        <dd>
		        	<fmt:formatDate value="${detail.regDate}" pattern="yyyy.MM.dd HH:mm:ss" />
		        </dd>
		        
		        <dt>첨부파일</dt>
		        <dd><a href="/fileDown/${files.no}">${files.fileOrigName}</a></dd>
		        
		        <dt>내용</dt>
		        <dd>${detail.content}</dd>
		       </dl>
		    </form>
				    
			 <div class="btn-group btn-group-sm" role="group" style="float:right;">
				 <button class="btn btn-default" onclick="location.href='/update/${detail.no}'">수정</button>
				 <button class="btn btn-default" onclick="location.href='/delete/${detail.no}'">삭제</button>
				 <button class="btn btn-default" onclick="location.href='/list'">목록</button>
			 </div>
		</div>
		
		
		<!-- 댓글 -->
		<div class="container">
			<label for="content">comment</label>
			<form name="commentInsertForm">
				<div class="input-group">
					<input type="hidden" name="no" value="${detail.no}"/>
					<input type="text" class="form-control" id="content" name="content" placeholder="내용을 입력하세요">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button" name="commentAddBtn">등록</button>
					</span>
				</div>
			</form>
		</div>
	
		<div class="container">
			<div class="commentList"></div>
		</div>
	</div>
<%@ include file="commentS.jsp" %>	
</layoutTag:layout>