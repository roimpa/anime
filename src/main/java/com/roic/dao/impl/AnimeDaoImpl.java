package com.roic.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roic.dao.AnimeDao;
import com.roic.entity.Anime;

@Repository("animeDao")
@Transactional
public class AnimeDaoImpl implements AnimeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Anime> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Anime.class).list();
	}

	@Override
	public Anime get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Anime) session.get(Anime.class, id);
	}

	@Override
	public void save(Anime anime) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(anime);
	}

}
