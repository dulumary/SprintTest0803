package com.marondal.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.database.bo.StoreBO;
import com.marondal.spring.test.database.model.Store;

@Controller
public class StroeController {
	
	@Autowired
	private StoreBO storeBO;
	
	// Store의 모든 데이터를 json 형태로 response에 담는다.
	@RequestMapping("/database/test01")
	@ResponseBody
	public List<Store> storeList() {
		
		List<Store> storeList = storeBO.getStoreList();
		
		return storeList;
	}

}
