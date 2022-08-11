package com.marondal.spring.test.jstl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSTLTest01Controller {
	
	@GetMapping("/jstl/test01")
	public String jstlTest01() {
		return "jstl/test01";
	}
	
}
