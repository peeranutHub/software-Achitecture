package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstAPI {
	
	@GetMapping("/name")
	@CrossOrigin(origins="*")
	public String Name(@RequestParam("gender") String gender,@RequestParam("street") String street) {
		System.out.println(gender);
		System.out.println(street);
		return "[{\"fullname\":\"Peeranut Moonrut\",\"Age\":\"19\",\"height\":\"165\"},{\"fullname\":\"Jattapol\",\"Age\":\"20\",\"height\":\"167\"}]";
	}

	
	@GetMapping("/calculate")
	public String calculate(@RequestParam("a") int a, @RequestParam("b") int b) {
		return "a="+a+",b="+b+"<br>"+a+"+"+b+"="+(a+b);
	}
	
	@GetMapping("/bmi")
	public String BMICalculate(@RequestParam("height") Integer h,@RequestParam("weight") Integer w) {
		int bmi = (w / ((h / 100)^2));
		return "BMI = "+bmi;  
	}
	
	@GetMapping("/sayhi/{nickname}/{msg}")
	public String hi(@PathVariable("nickname") String nick, @PathVariable("msg") String msg) {
		return "Hi"+ nick +" "+ msg;
	}
	
	@GetMapping("/bmiPath/{height}/{weight}")
	public String BMICal(@PathVariable("height") Integer h,@PathVariable("weight") Integer w) {
		double bmi = (w / ((h / 100)^2));
		return "BMI = "+bmi;
	}
}
