<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>통나무 펜션</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <link rel="stylesheet" href="/ajax/css/style.css" type="text/css">
    </head>

    <body>
        <div id="wrap" >
            <header class="mt-4">
                <div class="text-center display-4">통나무 팬션</div>
                <nav class="mt-4">
                    <ul class="nav nav-fill">
                        <li class="nav-item"><a class="nav-link" href="#">팬션소개</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">객실보기</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">예약하기</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">예약목록</a></li>
                    </ul>
                </nav>
            </header>

            
            <section>
                 <h2 class="my-4 text-center">예약 하기</h2>
                
                <div class="d-flex justify-content-center">
                    <div class="w-50">
                        <label>이름</label>
                        <input type="text" id="nameInput" class="form-control">

                        <label class="mt-3">예약날짜</label>
                        <input type="text" id="dateInput" class="form-control">

                        <label class="mt-3">숙박일수</label>
                        <input type="text" id="dayInput" class="form-control">

                        <label class="mt-3">숙박인원</label>
                        <input type="text" id="headcountInput" class="form-control">

                        <label class="mt-3">전화번호</label>
                        <input type="text" id="phoneNumberInput" class="form-control">

                        <button class="btn btn-warning btn-block mt-3" id="bookingBtn">예약하기</button>
                    </div>
                </div>
            </section>

            <footer class="mt-3 ml-4">
                <address>
                    제주특별자치도 제주시 애월읍  <br>
                    사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목 <br>
                    Copyright 2025 tongnamu All right reserved
                </address>

            </footer>


        </div>
        
        <script>
        	$(document).ready(function() {
        		
        		$("#bookingBtn").on("click", function() {
        			// 사용자가 입력한 값을 api로 데이터를 저장한다. 
        			let name = $("#nameInput").val();
        			let date = $("#dateInput").val();
        			let day = $("#dayInput").val();
        			let headcount = $("#headcountInput").val();
        			let phoneNumber = $("#phoneNumberInput").val();
        			
        			if(name == "") {
        				alert("이름을 입력하세요");
        				return ;
        			}
        			
        			if(date == "") {
        				alert("날짜를 입력하세요");
        				return ;
        			}
        			
        			if(day == "") {
        				alert("숙박일 수를 입력하세요");
        				return ;
        			}
        			
        			// 숙박일수 숫자로만 표현되었는지
        			// Not a Number
        			if(isNaN(day)) {
        				alert("숙박일수는 숫자만 입력 가능합니다");
        				return ;
        			}
        			
        			if(headcount == "") {
        				alert("숙박인원을 입력하세요");
        				return ;
        			}
        			
        			if(isNaN(headcount)) {
        				alert("숙박인원은 숫자만 입력 가능합니다.");
        				return;
        			}
        			
        			if(phoneNumber == "") {
        				alert("전화번호를 입력하세요");
        				return ;
        			}
        			
        			$.ajax({
        				type:"get"
        				, url:"/ajax/booking/add"
        				, data:{"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber}
        				, success:function(data) {
        					
        					// {"result":"success"} or {"result":"fail"}
        					if(data.result == "success") {
        						location.href = "/ajax/booking/list";
        					} else {
        						alert("예약 실패");
        					}
        					
        				}
        				, error:function() {
        					alert("예약 에러");
        				}
        			});
        			
        			
        		});
        		
        		
        	});
        
        </script>

    </body>
</html>