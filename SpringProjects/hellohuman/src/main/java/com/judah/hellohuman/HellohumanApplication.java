package com.judah.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
public class HellohumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellohumanApplication.class, args);
	}
	
	@RequestMapping("/")
	public String hello(
			@RequestParam(value="name", required=false) String name, 
			@RequestParam(value="last_name", required=false) String last_name,
			@RequestParam(value="times", required=false) Integer times) {
		if(times != null && times > 0) {
			String output = "";
			for(int i = 0; i < times; i++) {
				if(name != null && last_name != null) {
					output += "Hello " + name + " " + last_name + " ";
				}else if(name != null) {
					output += "Hello " + name + " ";
				}else if(last_name != null) {
					output += "Hello " + last_name + " ";
				}else {
					output += "Hello Human ";
				}
			}
			return output;
		}
		
		if(name != null && last_name != null) {
			return "Hello " + name + " " + last_name;
		}else if(name != null) {
			return "Hello " + name;
		}else if(last_name != null) {
			return "Hello " + last_name;
		}
		return "Hello Human";
	}

}
