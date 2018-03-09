package com.onuz.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onuz.model.User;
import com.onuz.service.TcRecognitionService;

@Controller
@RequestMapping("/")
public class WelcomeController {
	
	@Autowired
	private TcRecognitionService tcRecognitionService;

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("user", new User());
		return "home";
	}
	
    @RequestMapping(value = "/tcRecognition", method = RequestMethod.POST)
    public String tcRecognition(@ModelAttribute("user") User user) {
    	
    	if (tcRecognitionService.tcValidate(user.getTcNo()) == false) {
    		
    		System.out.println("Sadece rakam girişi yapınız.");
    		user.setResult("Sadece rakam girişi yapınız.");
    		
    	
    	} else if (user.getTcNo().length() != 11) {
    		
    		System.out.println("Eksik sayıda rakam girişi yapınız.");
    		user.setResult("Eksik sayıda rakam girişi yapınız.");
    		
    	
    	} else if (tcRecognitionService.tcRecognate(user.getTcNo()) == true) {
    	
    		System.out.println("TC No Doğru.");
    		user.setResult("TC No Doğru.");	
    	
    	} else {
    	
    		System.out.println("Hatalı bir TC No girildi.");
    		user.setResult("Hatalı bir TC No girildi.");
    		
    	}
	
    	return "home";
    }
    

}