package com.marondal.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.ajax.bo.FavoriteBO;
import com.marondal.spring.test.ajax.model.Favorite;

@Controller
@RequestMapping("/ajax/favorite")
public class FavoriteController {
	
	@Autowired
	private FavoriteBO favoriteBO;
	
	@GetMapping("/list")
	public String favoriteList(Model model) {
		
		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		
		model.addAttribute("favoriteList", favoriteList );
		
		return "ajax/favoriteList";
		
	}
	
	@GetMapping("/input")
	public String favoriteInput() {
		return "ajax/favoriteInput";
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Map<String, String> addFavorite(
			@RequestParam("name") String name
			, @RequestParam("url") String url) {
		
		int count = favoriteBO.addFavorite(name, url);
		Map<String, String> map = new HashMap<>();
		// {"result":"success"}
		if(count == 1) {
			map.put("result", "success");
		} else { // {"result":"fail"}
			map.put("result", "fail");
		}
		
		return map;
	}
	
	// url을 입력받고, 중복된 상태인지를 알려주는 api
	// {"is_duplicate":true} or {"is_duplicate":false}
	
	@PostMapping("/is_duplicate")
	@ResponseBody
	public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url) {
		
//		boolean isDuplicate = favoriteBO.isDuplicateUrl(url);
		
		Map<String, Boolean> map = new HashMap<>();
		
//		if(isDuplicate) {
//			map.put("is_duplicate", true);
//		} else {
//			map.put("is_duplicate", false);
//		}
		
//		map.put("is_duplicate", isDuplicate);
		map.put("is_duplicate", favoriteBO.isDuplicateUrl(url));
		
		return map;
		
		
	}
	
	// id를 기반으로 즐겨찾기를 삭제하는 기능 api
	// {"result":"success"} or {"result":"fail"}
	
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteFavorite(@RequestParam("id") int id) {
		
		int count = favoriteBO.deleteFavorite(id);
		
		Map<String, String> map = new HashMap<>();
		
		if(count == 1) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		
		return map;
	}
	

}
