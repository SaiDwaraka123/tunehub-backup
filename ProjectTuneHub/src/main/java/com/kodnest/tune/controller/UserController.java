package com.kodnest.tune.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tune.entity.Song;
import com.kodnest.tune.entity.User;
import com.kodnest.tune.serviceimpl.UserServiceimpl;

import Service.SongService;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserServiceimpl  userService;
	
	@Autowired
	SongService songService;
	
	@PostMapping("/register")
public String addUser(@ModelAttribute User user) {
//	System.out.println(user.getUsername()+" "+user.getEmail()+" "+user.getAddress()+" "+user.getRole()+" "+user.getPassword());
	
		//email taken from registration form
		String email=user.getEmail();
		
		//checking if the email entred in registration form is present in DB or not
	boolean status=	userService.emailExists(email);
	 if(status==false) {
		userService.addUser(user);
		System.out.println("user added");
	 }
	 else {
		 System.out.println("User already exists");
		
	 }
	return "login";
}

		@PostMapping("/validate")
		public String validate(@RequestParam("email")String email,
			@RequestParam("password")String password, HttpSession session,Model model){
			
			if(userService.validateUser(email,password)==true) {
			String role =	userService.getRole(email);
			session.setAttribute("email",email);
			
			if(role.equals("admin")) {
				return "adminhome";
		
		}else {
		User user=	userService.getUser(email);
		  boolean userstatus= user.isIspremium();
		  
		  List<Song>fetchAllSongs=songService.fetchAllSongs();
		  model.addAttribute("songs",fetchAllSongs);
		  
		   model.addAttribute("ispremium",userstatus);
		      return "customerhome";
	            } 
			}else {
	               
	                return "login";
			}

		}

   @GetMapping("/logout")
   public String logout(HttpSession session) {
	   session.invalidate();
	   return "login";
   }
			
   }	

		
		



			
		
	


