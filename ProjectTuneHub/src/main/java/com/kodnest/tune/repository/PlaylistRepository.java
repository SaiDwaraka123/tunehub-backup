package com.kodnest.tune.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.tune.entity.Playlist;

public interface PlaylistRepository  extends JpaRepository<Playlist, Integer>{

	
public List<Playlist> findAll();
	
	
	//public List<Song> findAll();
}
