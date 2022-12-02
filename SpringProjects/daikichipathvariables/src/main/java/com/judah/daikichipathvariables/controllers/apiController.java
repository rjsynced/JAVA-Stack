package com.judah.daikichipathvariables.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class apiController {

	public apiController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/")
	public String index() {
		return "Welcome ";
	}
	
	@RequestMapping("/daikichi/travel/{city}")
	public String getTravel(@PathVariable("city") String city) {
		return "Congrats! You will soon to " + city;
	}
	
	@RequestMapping("/daikichi/lotto/{number}")
	public String getLotto(@PathVariable("number") Integer number) {
		if(number % 2 == 0) {
			return "You will take a grand journey in the near future, but be wary of tempting offers.";
		} else {
			return "You have enjoyed the fruits of your labor, but now is a great time to spend time with family and friends.";
		}
	}
}
