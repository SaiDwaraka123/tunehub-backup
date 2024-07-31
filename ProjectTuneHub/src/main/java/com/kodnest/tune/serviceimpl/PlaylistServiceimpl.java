package com.kodnest.tune.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tune.entity.Playlist;
import com.kodnest.tune.repository.PlaylistRepository;

import Service.PlaylistService;
@Service
public class PlaylistServiceimpl implements PlaylistService{

	@Autowired
	PlaylistRepository playlistRepository;

	@Override
	public void addplaylist(Playlist playlist) {
		playlistRepository.save(playlist);
		
		
		
	}
//	@Override
//	public List<Playlist> fetchAllSongs(){
//	 return	playlistRepository.findAll();
//		//return song;
//	}
//	@Override
//	public List<Playlist> fetchAllPlaylists() {
//	   return playlistRepository.findAll();
//		//return null;
//	}
	@Override
	public List<Playlist> fetchAllSongs() {
	return 	playlistRepository.findAll();
	}
//@Override
//public List<Playlist> fetchAllSongs() {
//	return 	playlistRepository.findAll();
//	
//}
@Override
public List<Playlist> fetchAllPlaylists() {
	List<Playlist> playlist = playlistRepository.findAll();
	return playlist;
}
//public List<Playlist> getAllSongs() {
//    List<Playlist> songs = playlistRepository.findAll();
//    return songs != null ? songs : new ArrayList<>(); // Return an empty list if songs is null
//}

	
	
}
