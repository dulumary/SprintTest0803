<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
		<label>제목</label>
		<input type="text" class="form-control" id="titleInput">
		
		<label class="mt-3">주소</label>
		<div class="d-flex">
			<input type="text" class="form-control" id="urlInput">
		
		</div>
	
		<button type="button" id="addBtn" class="btn btn-success btn-block mt-3">추가</button>
	</div>
	
	<script>
		$(document).ready(function() {
			
			$("#addBtn").on("click", function() {
				
				let title = $("#titleInput").val();
				let url = $("#urlInput").val();
				
				// 유효성 검사
				// validation
				if(title == "") {
					alert("제목을 입력하세요");
					return ;
				}
				
				if(url == "") {
					alert("주소를 입력해주세요");
					return ;
				}
				
				if(!(url.startsWith("http://") || url.startsWith("https://"))) {
					alert("주소 형식이 잘못되었습니다");
					return ;
				}
				
				// api 호출
				// ajax 사용
				$.ajax({
					type:"post"
					, url:"/ajax/favorite/add"
					, data:{"name":title, "url":url}
					, success:function(data) {
						
						// 	} or {"result":"fail"}
						if(data.result == "success") {
							location.href = "/ajax/favorite/list";
						} else {
							alert("저장 실패!!");
						}
						
					}
					, error:function() {
						alert("에러발생!");
					}
				});
				
				
				
			});
		});
	
	</script>

</body>
</html>