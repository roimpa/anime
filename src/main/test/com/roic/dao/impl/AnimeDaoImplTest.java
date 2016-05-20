package com.roic.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.roic.dao.AnimeDao;
import com.roic.entity.Anime;

public class AnimeDaoImplTest {
	
	private AnimeDao animeDao;
	private AbstractApplicationContext context;

	/**
	 * Configuracion via spring.
	 */
	@Before
	public void setUp() {
		// loads configuration and mappings
		context = new ClassPathXmlApplicationContext("context.xml");
		animeDao = (AnimeDao)context.getBean("animeDao");
	}

	@After
	public void tearDown() {
		context.close();
	}
	
	@Test
	public void testGuardarPedido() {
		Anime anime = new Anime();
		anime.setName("Toradora");
		anime.setWatched(false);
		
        animeDao.save(anime);
	}
	
	@Test
	public void testGetInfo() {
		List<Anime> list = animeDao.getAll();
		list.size();
	}

}
