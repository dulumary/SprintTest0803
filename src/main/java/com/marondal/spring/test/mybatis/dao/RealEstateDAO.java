package com.marondal.spring.test.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.marondal.spring.test.mybatis.model.RealEstate;

@Repository
public interface RealEstateDAO {
	
	public RealEstate selectRealEstate(@Param("id") int id);
	
	public List<RealEstate> selectRealEstateAsRent(@Param("rentPrice") int rent);
	
	public List<RealEstate> selectRealEstateAsAreaPrice(
			@Param("area") int area
			, @Param("price") int price);

}
