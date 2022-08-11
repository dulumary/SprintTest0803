package com.marondal.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marondal.spring.test.jsp.bo.RealtorBO;
import com.marondal.spring.test.jsp.model.Realtor;

@Controller
@RequestMapping("/jsp/realtor")
public class RealtorController {
	
	@Autowired
	private RealtorBO realtorBO;
	
	// 공인중개사 정보 저장하는
	@GetMapping("/add")
	public String addRealtor(
			@ModelAttribute Realtor realtor
			, Model model) {
		
		int count = realtorBO.addRealtor(realtor);
		
		model.addAttribute("result", realtor);
		
		return "jsp/realtorInfo";
	}
	
	// 공인중개사 입력 페이지 
	@GetMapping("/input")
	public String realtorInput() {
		return "jsp/realtorInput";
	}

}
