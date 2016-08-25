package com.headerdev.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.headerdev.model.UserProfile;

@Repository
@Transactional
public class UserProfileDaoImpl implements UserProfileDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserProfile> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserProfile");
		List<UserProfile> list = query.list();
		session.flush();
		return list;
	}

	@Override
	public UserProfile findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserProfile where id = ?");
		query.setInteger(0, id);
		session.flush();
		return (UserProfile) query.uniqueResult();
	}

}
