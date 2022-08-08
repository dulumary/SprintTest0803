package com.marondal.spring.test.mybatis.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.test.mybatis.dao.RealEstateDAO;
import com.marondal.spring.test.mybatis.model.RealEstate;

@Service
public class RealEstateBO {
	
	@Autowired
	private RealEstateDAO realEstateDAO;
	
	public RealEstate getRealEstate(int id) {
		
		RealEstate realEstate = realEstateDAO.selectRealEstate(id);
		return realEstate;
	}
	
	public List<RealEstate> getRealEstateAsRent(int rent) {
		
		List<RealEstate> realEstateList = realEstateDAO.selectRealEstateAsRent(rent);
		return realEstateList;
	}
	
	public List<RealEstate> getRealEstateAsAreaPrice(int area, int price) {
		return realEstateDAO.selectRealEstateAsAreaPrice(area, price);
	}
	
	public int addRealEstateByObject(RealEstate realEstate) {
		
		return realEstateDAO.insertRealEstateByObject(realEstate);
		
	}
	
	public int addRealEstate(int realtorId, String address, int area, String type, int price, int rentPrice) {
		
		return realEstateDAO.insertRealEstate(realtorId, address, area, type, price, rentPrice);
	}
	
	public int updateRealEstate(int id, String type, int price) {
		return realEstateDAO.updateRealEstate(id, type, price);
	}
	
	public int deleteRealEstate(int id) {
		return realEstateDAO.deleteRealEstate(id);
	}

}
