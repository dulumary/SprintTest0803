<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		<h1>공인중개사 추가</h1>
		
		<form method="get" action="/jsp/realtor/add">
			<label for="office" class="w-50">상호명 <input type="text" id="office" name="office" class="form-control"></label> <br>
			<label for="phoneNumber" class="w-50">전화번호 <input type="text" id="phoneNumber" name="phoneNumber" class="form-control"></label> <br>
			<label for="address" class="w-50">주소 <input type="text" id="address" name="address" class="form-control"></label> <br>
			<label for="grade" class="w-50">등급 <input type="text" id="grade" name="grade" class="form-control" placeholder="안심중개사, 일반중개사, 프리미엄중개사 "></label> <br>
			<input type="submit" value="추가" class="btn btn-primary">
		</form>
	</div>
</body>
</html>