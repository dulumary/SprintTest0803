package com.marondal.spring.test.ajax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.marondal.spring.test.ajax.model.Favorite;

@Repository
public interface FavoriteDAO {
	
	public List<Favorite> selectFavoriteList();
	
	public int insertFavorite(
			@Param("name") String name
			, @Param("url") String url);
	
	public int selectCountUrl(@Param("url") String url);
	
	public int deleteFavorite(@Param("id") int id);

}
