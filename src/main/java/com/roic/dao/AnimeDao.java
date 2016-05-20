package com.roic.dao;

import java.util.List;

import com.roic.entity.Anime;

public interface AnimeDao {

	List<Anime> getAll();
	Anime get(Long id);
	void save(Anime anime);
	
}
