package ru.bellintegrator.practice.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.user.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
* {@inheritDoc}
*/
@Repository
public class UserDaoImpl implements UserDao{
	
	private final EntityManager em;
	
	@Autowired
	public UserDaoImpl(EntityManager em){
		this.em = em;
	}
}