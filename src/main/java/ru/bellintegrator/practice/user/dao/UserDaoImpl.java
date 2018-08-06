package ru.bellintegrator.practice.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.user.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

	@Override
	public List<User> all() {

		TypedQuery<User> query = em.createQuery("SELECT u FROM u", User.class);

		return  query.getResultList();
	}

	@Override
	public User getUserById(Long id) {

		return em.find(User.class, id);
	}

	@Override
	public User getUserByFilter(User user) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
		Root<User> userRoot = criteriaQuery.from(User.class);
		criteriaQuery.select(userRoot);
		List<Predicate> predicateList = new ArrayList<>();
		predicateList.add(criteriaBuilder.equal(userRoot.get("user").get("officeId"), user.getOfficeId()));

		if(!user.getFirstName().isEmpty()){
			predicateList.add(criteriaBuilder.equal(userRoot.get("user").get("firstName"), user.getFirstName()));
		}

		if(!user.getSecondName().isEmpty()){
			predicateList.add(criteriaBuilder.equal(userRoot.get("user").get("firstName"), user.getSecondName()));
		}

		if(!user.getMiddleName().isEmpty()){
			predicateList.add(criteriaBuilder.equal(userRoot.get("user").get("middleName"), user.getMiddleName()));
		}

		if(user.getPosition() != 0){
			predicateList.add(criteriaBuilder.equal(userRoot.get("user").get("position"), user.getPosition()));
		}

		criteriaQuery.where(predicateList.toArray(new Predicate[]{}));

		TypedQuery<User> query = em.createQuery(criteriaQuery);

		return query.getSingleResult();
	}

	@Override
	public void updateUser(User user) {
		em.persist(user);
	}

	@Override
	public void saveUser(User user) {
		em.persist(user);
	}
}