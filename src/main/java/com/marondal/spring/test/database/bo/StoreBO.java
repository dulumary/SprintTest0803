package com.marondal.spring.test.database.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.test.database.dao.StoreDAO;
import com.marondal.spring.test.database.model.Store;

@Service
public class StoreBO {
	
	@Autowired
	private StoreDAO storeDAO;
	
	// store의 모든 데이터 조회 결과 리턴
	public List<Store> getStoreList() {
		List<Store> storeList = storeDAO.selectStoreList();
		return storeList;
	}

}
