package com.kodnest.tune.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tune.entity.Song;

import Service.SongService;

@Controller
public class SongController {
	@Autowired
	SongService songService;
    
	@PostMapping("/addsong")
	
public String addsong(@ModelAttribute Song song) {
		songService.addSong(song);
		return "NewSong";
//	boolean status=	songService.songExists(song.getName());
//	if(status==false) {
//	songService.addSong(song);
//	System.out.println("song added");
//	}
//	else {
//		System.out.println("Song already exists");
//	}
//	return "login";
	
}
	@GetMapping("/viewsongs")
	 public String viewsongs(Model model) {
		List<Song>list = songService.fetchAllSongs();
         model.addAttribute("songs",list);
          return "displaysongs";
		}
	
	@GetMapping("/playsongs")
	 public String playsongs(Model model) {
		List<Song>list = songService.fetchAllSongs();
		boolean premium =true;
		if(premium) {
         model.addAttribute("songs",list);
		return "displaysongs";
		}else {
			return "subscriptionform";
		}
	}
}