package com.marondal.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.mybatis.bo.RealEstateBO;
import com.marondal.spring.test.mybatis.model.RealEstate;

@Controller
@RequestMapping("/mybatis/test01")
public class RealEstateController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/1")
	@ResponseBody
	public RealEstate getRealEstate(@RequestParam("id") int id) {
		
		RealEstate realEstate = realEstateBO.getRealEstate(id);
		return realEstate;
		
	}
	
	@RequestMapping("/2")
	@ResponseBody
	public List<RealEstate> getRealEstateAsRent(@RequestParam("rent") int rent) {
		
		List<RealEstate> realEstateList = realEstateBO.getRealEstateAsRent(rent);
		return realEstateList;
		
		
	}
	
	@RequestMapping("/3")
	@ResponseBody
	public List<RealEstate> getRealEstateAsAreaPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price
			) {
		
		List<RealEstate> realEstateList = realEstateBO.getRealEstateAsAreaPrice(area, price);
		
		return realEstateList;
		
		
	}

}
