package com.kodnest.tune.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class NavController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/Registration")
	public String Registration() {
		return "Registration";
	}
	@GetMapping("/NewSong")
	public String NewSong() {
		return "NewSong";
	}
	
}
