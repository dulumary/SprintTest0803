package com.marondal.spring.test.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.test.ajax.dao.FavoriteDAO;
import com.marondal.spring.test.ajax.model.Favorite;

@Service
public class FavoriteBO {
	
	@Autowired
	private FavoriteDAO favoriteDAO;
	
	public List<Favorite> getFavoriteList() {
		
		return favoriteDAO.selectFavoriteList();
	}
	
	public int addFavorite(String name, String url) {
		return favoriteDAO.insertFavorite(name, url);
	}
	
	public boolean isDuplicateUrl(String url) {

//		int count = favoriteDAO.selectCountUrl(url);
		
//		if(count == 0) {
//			return false;
//		} else {
//			return true;
//		}
		
//		return count != 0;
		
		return favoriteDAO.selectCountUrl(url) != 0;
		
	}
	
	public int deleteFavorite(int id) {
		return favoriteDAO.deleteFavorite(id);
	}

}
