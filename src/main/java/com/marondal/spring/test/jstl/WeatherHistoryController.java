package com.marondal.spring.test.jstl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.jstl.bo.WeatherBO;
import com.marondal.spring.test.jstl.model.Weather;

@Controller
@RequestMapping("/jstl/weather")
public class WeatherHistoryController {
	
	@Autowired
	private WeatherBO weatherBO;
	
	@GetMapping("/list")
	public String weatherHistory(Model model) {
		
		List<Weather> weatherHistory = weatherBO.getWeathHistory();
		
		model.addAttribute("weatherHistory", weatherHistory);
		
		return "jstl/weather/list";
	}
	
	@GetMapping("/input")
	public String weatherInput() {
		return "jstl/weather/input";
	}
	
	@GetMapping("/add")
	@ResponseBody
	public String addWeather(
			@RequestParam("date") String date
			, @RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("microDust") String microDust
			, @RequestParam("windSpeed") double windSpeed) {
		
		int count = weatherBO.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return "삽입결과 : " + count;
		
	}

}
