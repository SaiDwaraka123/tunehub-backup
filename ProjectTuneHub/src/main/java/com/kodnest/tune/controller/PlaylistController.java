package com.kodnest.tune.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tune.entity.Playlist;
import com.kodnest.tune.entity.Song;
import com.kodnest.tune.serviceimpl.PlaylistServiceimpl;
import com.kodnest.tune.serviceimpl.SongServiceimpl;

@Controller
public class PlaylistController {
	
	@Autowired
	SongServiceimpl songService;

	@Autowired
	PlaylistServiceimpl  playlistService;
	
	@GetMapping("/createplaylists")
	 public String createPlaylists(Model model) {
		List<Song>list = songService.fetchAllSongs();
         model.addAttribute("songs",list);
		return "createplaylist";
	}
	@PostMapping("/addplaylist")
	 public String addplaylist(@ModelAttribute Playlist playlist) {
		//updating the playlist table
		playlistService.addplaylist(playlist);
		//updating the song table
		List<Song> songList=  playlist.getSong();
		for(Song s: songList) {
			s.getPlaylist().add(playlist);
			songService.updateSong(s);
	 }
		return "adminhome";
		 
	 }
	@GetMapping("/viewplaylists")
	 public String viewplaylists(Model model) {
		List<Playlist>list = playlistService.fetchAllPlaylists();
         model.addAttribute("playlist",list);
		return "displayplaylist";
}
//	@PostMapping("/addplaylist")
//	public String addplaylist(Model model) {
//	    List<Song> songList = songService.fetchAllSongs();
//	    if (songList == null) {
//	        songList = new ArrayList<>(); // Initialize with an empty list to avoid null pointer exception
//	    }
//	    model.addAttribute("songList", songList);
//	    return "displayplaylists";
//	}
}
