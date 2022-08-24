package com.marondal.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.ajax.bo.BookingBO;
import com.marondal.spring.test.ajax.model.Booking;

@Controller
@RequestMapping("/ajax/booking")
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/main")
	public String bookingMain() {
		return "ajax/bookingMain";
	}
	
	@GetMapping("/list")
	public String bookingList(Model model) {
		
		List<Booking> bookingList = bookingBO.getBookingList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "ajax/bookingList";
	}
	
	@GetMapping("/input")
	public String bookingInput() {
		return "ajax/bookingInput";
	}
	
	
	// id로 예약 정보를 삭제하는 api
	// {"result":"success"} or {"result":"fail"}
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteBooking(@RequestParam("id") int id) {
		
		int count = bookingBO.deleteBooking(id);
		
		Map<String, String> map = new HashMap<>();
		
		if(count == 1) {
			// 삭제 성공
			map.put("result", "success");
		} else {
			// 삭제 실패
			map.put("result", "fail");
		}
		
		return map;
		
	}
	
	// 데이터를 전달 받고 데이터를 데이터베이스에 저장하는 api
	// {"result":"success"} or {"result":"fail"}
	@GetMapping("/add")
	@ResponseBody
	public Map<String, String> addBooking(
			@RequestParam("name") String name
			//, @DateTimeFormat(pattern="yyyy년MM월dd일") // 2022년08월22일
			, @RequestParam("date") String date  // 2022-08-22
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		int count = bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, String> map = new HashMap<>();
		
		if(count == 1) {
			// 성공
			map.put("result", "success");
		} else {
			// 실패
			map.put("result", "fail");
		}
		
		return map;
	}
	
	
	// []  {}
	//  {
	//     "result":"success",
	//	   "data":{ 
	// 			   "name":"김인규",
	//    			"phoneNumber":"010-1234-5678",
	//    			"date":"2022-08-12"
	// 				}
	// }
	// 
	@PostMapping("/find")
	@ResponseBody
	public Map<String, Object> findBooking(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingBO.getBooking(name, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		
		if(booking != null) {
			result.put("result", "success");
			result.put("data", booking);
		} else {
			result.put("result", "fail");
		}
		
		
		return result;
	}
	

}
