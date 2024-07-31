package com.kodnest.tune.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tune.entity.Playlist;
import com.kodnest.tune.entity.Song;
import com.kodnest.tune.repository.SongRepository;

import Service.SongService;
@Service
public  class SongServiceimpl implements SongService {

	@Autowired
	SongRepository songRepository;
	
   
	@Override
	public void addSong(Song song) {
		// if (song.getArtist() == null || song.getArtist().isEmpty()) {
		//        throw new IllegalArgumentException("Artist cannot be null or empty");
		//    }
		songRepository.save(song);
		

	}
	@Override
	public boolean songExists(String name) {
	   Song songs =songRepository.findByName(name);
		if(songs==null) {
	 return false;
 	}
	else  {
		return true;
}
	}

	@Override
	public List<Song> fetchAllSongs(){
		List<Song> song=songRepository.findAll();
		return song;
	}
	@Override
	public String addSong(String song) {
		// TODO Auto-generated method stub
		return null;
	}
//	@Override
//	public void addplaylist(Playlist playlist) {
//		// TODO Auto-generated method stub
//		
//	}
	public void updateSong(Song s) {
		songRepository.save(s);
		
	}
@Override
public void addplaylist(Playlist playlist) {
	// TODO Auto-generated method stub
	
}
	

		
	}

	

	
	

