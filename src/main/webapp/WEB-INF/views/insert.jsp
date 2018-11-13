<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>    
<layoutTag:layout> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
</head>
<body>


	<div class="container">
		<div class="col-xs-12" style="margin: 15px auto;">
			<label style="font-size:20px;"><span class="glyphicon glyphicon-list-alt">게시글 목록</span></label>
			<button class="btn btn-primary btn-sm" style="float:right;" onclick="location.href='/insert'">글쓰기</button>
		</div>
	
	
		<div class="col-xs-12">
	    <form action="/insertProc" method="post" enctype="multipart/form-data">
	    
	    	
	      <div class="form-group">
	        <label for="subject">제목</label>
	        <input type="text" class="form-control" id="subject" name="subject" placeholder="제목을 입력하세요.">
	      </div>
	      
	      <div class="form-group">
	        <label for="writer">작성자</label>
	        <input type="text" class="form-control" id="writer" name="writer" placeholder="내용을 입력하세요.">
	      </div>
	      
	      <div class="form-group">
	        <label for=content">내용</label>
	        <textarea class="form-control" id="content" name="content" rows="3"></textarea>
	      </div>
	      
	      <div class="form-group">
	      	<label for="file">파일 업로드</label>
	      	<input type="file" name="files" id="files">
	      </div>
	      
	      <button type="submit" class="btn btn-primary btn-sm" style="float:right">작성</button>
	    </form>
		</div>
		
	</div>
</body>
</html>
</layoutTag:layout>