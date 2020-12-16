package com.example.demo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/v1/api") //เอาไว้จัดหมวดหมู่path
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
	
	@GetMapping("/animal")
	public animal getAniamalData() {
		animal Dog = new animal();
		Dog.setXxx("Dog");
		Dog.setName("kaew");
		Dog.setSpecies("bang-kaew");
		
		return Dog;
	}
	
	@GetMapping("/animals")
	public ArrayList<animal> getAnimalList(){
		ArrayList<animal> list = new ArrayList<animal>();
		
		animal dog = new animal();
		dog.setXxx("dog");
		dog.setName("kaew");
		dog.setSpecies("bang-kaew");
		
		list.add(dog);
		
		animal cat = new animal();
		cat.setXxx("cat");
		cat.setName("dumm");
		cat.setSpecies("persian");
		
		list.add(cat);
		return list;
	}
	
	@GetMapping("/animal/add")
	public String addAnimal(@ModelAttribute animal bird) {
		return bird.getXxx()+" "+bird.getName()+" "+bird.getSpecies();
	}
	
	
	@GetMapping("/calperson")
	public bmiforinput person() {
		bmiforinput cal = new bmiforinput();
		cal.setHeight(150);
		cal.setWeight(65);
		return cal;
	}
	
	@GetMapping("/calperson/test")
	public String testCal(@ModelAttribute bmiforinput BMII) {
		double bmi = (BMII.getWeight() / ((BMII.getHeight() / 100) * (BMII.getHeight() / 100) ));
		return "Height ="+String.valueOf(BMII.getHeight())+"<br>"+"Weight ="+ String.valueOf(BMII.getWeight()) +"<br>"+"BMI ="+ String.valueOf(bmi);
	}
}
