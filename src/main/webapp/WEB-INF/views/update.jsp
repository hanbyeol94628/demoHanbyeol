<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>    
<layoutTag:layout> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>
	<div class="container">
	    <form action="/updateProc/${detail.no}" method="post">
	    
	      <div class="form-group">
	        <label for="subject">제목</label>
	        <input type="text" class="form-control" id="subject" name="subject" value="${detail.subject}">
	      </div>
	      
	      <div class="form-group">
	        <label for="content">내용</label>
	        <textarea class="form-control" id="content" name="content" rows="3">${detail.content}</textarea>
	      </div>
	      
	      <input type="hidden" name="no" value="${detail.no}"/>
	      <button type="submit" class="btn btn-primary">수정</button>
	    </form>
	</div>

	 <%@ include file="bootstrap.jsp" %>
</body>
</html>
</layoutTag:layout>