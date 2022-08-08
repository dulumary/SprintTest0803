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
@RequestMapping("/mybatis")
public class RealEstateController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/test01/1")
	@ResponseBody
	public RealEstate getRealEstate(@RequestParam("id") int id) {
		
		RealEstate realEstate = realEstateBO.getRealEstate(id);
		return realEstate;
		
	}
	
	@RequestMapping("/test01/2")
	@ResponseBody
	public List<RealEstate> getRealEstateAsRent(@RequestParam("rent") int rent) {
		
		List<RealEstate> realEstateList = realEstateBO.getRealEstateAsRent(rent);
		return realEstateList;
		
		
	}
	
	@RequestMapping("/test01/3")
	@ResponseBody
	public List<RealEstate> getRealEstateAsAreaPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price
			) {
		
		List<RealEstate> realEstateList = realEstateBO.getRealEstateAsAreaPrice(area, price);
		
		return realEstateList;
		
		
	}
	
	@RequestMapping("/test02/1")
	@ResponseBody
	public String addRealEstateByObject() {
//		realtorId : 3
//		address : 푸르지용 리버 303동 1104호
//		area : 89
//		type : 매매
//		price : 100000
		
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateBO.addRealEstateByObject(realEstate);
		
		
		return "삽입결과 : " + count;
		
	}
	
	@RequestMapping("/test02/2")
	@ResponseBody
	public String addRealEstate(@RequestParam("realtorId") int realtorId) {
		
//		address : 썅떼빌리버 오피스텔 814호
//		area : 45
//		type : 월세
//		price : 100000
//		rentPrice : 120
		
		int count = realEstateBO.addRealEstate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		return "삽입결과 : " + count;
	}
	
	@RequestMapping("/test03")
	@ResponseBody
	public String updateRealEstate() {
//		id가 24 인 행의 type 을 전세로 바꾸고 price 를 70000으로 변경하세요.
		int count = realEstateBO.updateRealEstate(24, "전세", 70000);
		
		return "수정 결과 : " + count;
		
	}
	
	@RequestMapping("/test04")
	@ResponseBody
	public String deleteRealEstate(@RequestParam("id") int id) {
		
		int count = realEstateBO.deleteRealEstate(id);
		return "삭제 결과 : " + count;
		
	}

}
