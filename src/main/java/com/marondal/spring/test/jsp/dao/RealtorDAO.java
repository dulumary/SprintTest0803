package com.marondal.spring.test.jsp.dao;

import org.springframework.stereotype.Repository;

import com.marondal.spring.test.jsp.model.Realtor;

@Repository
public interface RealtorDAO {
	
	public int insertRealtor(Realtor realtor);

}
