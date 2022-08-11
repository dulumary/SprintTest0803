package com.marondal.spring.test.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.test.jsp.dao.SellerDAO;
import com.marondal.spring.test.jsp.model.Seller;

@Service
public class SellerBO {
	
	@Autowired
	private SellerDAO sellerDAO; 
	
	public int addSeller(String nickname, String imageUrl, double temperature) {
		return sellerDAO.insertSeller(nickname, imageUrl, temperature);
	}
	
	public Seller getLastSeller() {
		return sellerDAO.selectLastSeller();
	}
	
	public Seller getSeller(int id) {
		return sellerDAO.selectSeller(id);
	}

}
