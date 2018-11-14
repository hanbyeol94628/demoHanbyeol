<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	
	var no = '${detail.no}'
	
	$('[name=commentAddBtn]').click(function(){
		var insertData = $("[name=commentAddForm]").serialize();
		commentAdd(insertData);
	});
	
	
	
	
	
	
	// 댓글 목록
	function commentList(){
		$.ajax({
			url:'/comment/list',
			type : 'get',
			data : {'no':no},
			success : function(data){
				var a = '';
				$.each(data, function(key, value){
					a += '<div class="commentArea" style="margin-bottom:15px;">';
					a += '<div class="commentInfo'+value.cno+'">'+'작성자:<b>'+value.writer+'</b>';
				 	a += '<a onclick="commentUpdate('+value.cno+',\''+value.content+'\');"> 수정 </a>';
	                a += '<a onclick="commentDelete('+value.cno+');"> 삭제 </a> </div>';
	                a += '<div class="commentContent'+value.cno+'">'+value.content +'</p>';
	                a += '</div></div>';
				});
				
				$(".commentList").html(a);
			}
		});
	}
	
	// 댓글 등록
	function commentAdd(insertData){
		$.ajax({
			url : '/comment/add',
			type : 'post',
			data : insertData,
			success : function(data){
				if(data == 1){
					commentList();
					$('[name=content]').val('');
				}
			}
		});
	}

	// 댓글 수정 - input 폼
	function commentUpdate(cno, content){
		var a ='';
		
		a += '<div class="input-group">';
		a += '<input type="text" class="form-control" name="content_'+cno+'"value="'+content+'"/>';
		a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdateProc('+cno+');">수정</button> </span>';
	    a += '</div>';
		
	    $('.commentContent'+cno).html(a);
	}

	
	// 댓글 수정
	function commentUpdateProc(cno){
		var updateContent = $('[name=content_'+cno+']').val();
		$.ajax({
			url : '/comment/update/'+cno,
		    type : 'post',
		    data : {'content' : updateContent, 'cno' : cno},
		    success : function(data){
		    	if(data == 1) commentList(no); //댓글 수정후 목록 출력 
		    }
		});
	}
	

	
	//댓글 삭제 
	function commentDelete(cno){
	    $.ajax({
	        url : '/comment/delete/'+cno+'/'+no,
	        type : 'post',
	        success : function(data){
	            if(data == 1) commentList(no); //댓글 삭제후 목록 출력 
	        }
	    });
	}
	 
	$(document).ready(function(){
	    commentList(); //페이지 로딩시 댓글 목록 출력 
	});
	
	
</script>