package com.headerdev.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.headerdev.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User Where username = ?");
		query.setString(0, username);
		User user = (User) query.uniqueResult();
        if(user!=null){
            Hibernate.initialize(user.getUserProfiles());
        }
		return user;
	}

	@Override
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		session.flush();
	}

	@Override
	public void deleteBySSO(String sso) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		List<User> userList = query.list();
		return userList;
	}
	
	

}
