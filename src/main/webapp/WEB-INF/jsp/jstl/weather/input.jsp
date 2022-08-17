<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력화면</title>
    
        <!-- bootstrap CDN link -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        
        <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
        
        
        <style>
        	.main-menu {
        		
        		background-color:cornflowerblue;
        	}
        	
        	
        	footer {
        		height:100px;	
        	}
        	
        	.input-lable {
        		width:120px;
        	}
        
        </style>
        
</head>
<body>
	<div class="container">
		<div class="d-flex">
		
			<nav class="main-menu col-2">
				<div class="d-flex mt-2">
					<div class="col-2">
						<img width="25" src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Emblem_of_the_Government_of_the_Republic_of_Korea.svg/800px-Emblem_of_the_Government_of_the_Republic_of_Korea.svg.png" >
					</div>
					<h4 class="text-white col-10">기상청</h4>
				</div>
				
				 <ul class="nav flex-column mt-4">
                    <li class="nav-item"><a href="/jstl/weather/list" class="nav-link text-white">날씨</a></li>
                    <li class="nav-item"><a href="/jstl/weather/input" class="nav-link text-white">날씨입력</a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-white">테마날씨</a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-white">관측 기후</a></li>
                </ul>
			
			</nav>
            
            <section class="mt-3 ml-5">
	            <h3>날씨 입력</h3>
					<form method="get" action="/jstl/weather/add">
	                    <div class="d-flex justify-content-between mt-5">
	                        <div class="d-flex align-items-center">
	                            <label class="input-lable">날짜</label> 
	                            <input type="text" class="form-control" id="date" name="date">
	                        </div>
	                        <div class="d-flex align-items-center">
	                            <label class="input-lable">날씨</label> 
	                            <select class="form-control" name="weather">
	                                <option>맑음</option>
	                                <option>구름조금</option>
	                                <option>흐림</option>
	                                <option>비</option>
	                            </select>
	                        </div>
	
	                        <div class="d-flex align-items-center">
	                            <label class="input-lable">미세먼지</label> 
	                            <select class="form-control " name="microDust">
	                                <option>좋음</option>
	                                <option>보통</option>
	                                <option>나쁨</option>
	                                <option>최악</option>
	                            </select>
	                        </div>
	                    </div>
	
	                    <div class="d-flex justify-content-between mt-5">
	                        <div class="d-flex align-items-center">
	                            <label class="col-3">기온</label> 
	                            <div class="input-group">
	                                <input type="text" class="form-control" name="temperatures">
	                                <div class="input-group-append">
	                                    <span class="input-group-text">℃</span>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="d-flex align-items-center">
	                            <label class="col-4">강수량</label> 
	                            <div class="input-group">
	                                <input type="text" class="form-control" name="precipitation">
	                                    <div class="input-group-append">
	                                        <span class="input-group-text">mm</span>
	                                </div>
	                            </div>
	                        </div>
	                        
	                        <div class="d-flex align-items-center">
	                            <label class="col-3">풍속</label> 
	                            <div class="input-group">
	                                <input type="text" class="form-control" name="windSpeed"> 
	                                    <div class="input-group-append">
	                                        <span class="input-group-text">km/h</span>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="text-right mt-4 mb-5">
	                        <button type="submit" class="btn btn-success">저장</button>
	                    </div>
                    </form>
                    
            </section>
       </div>
       <footer class="border-top d-flex">
           <div class="mt-3 ml-4"> <img width="120" src="https://www.weather.go.kr/w/resources/image/foot_logo.png"></div>
           <div class="copyright mt-2">
               <small class="text-secondary">(07062) 서울시 동작구 여의대방로16길 61  <br>
               Copyright@2020 KMA. All Rights RESERVED.</small>

           </div>
       </footer>
			
		
		

	
	</div>
	
	<script>
		$(document).ready(function() {
			
			$("#date").datepicker({
				dateFormat:"yy년 mm월 dd"
			});
		});
	
	
	</script>
		

</body>
</html>