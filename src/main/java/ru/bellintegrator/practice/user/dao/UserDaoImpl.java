package ru.bellintegrator.practice.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {

        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);

        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {

        return em.find(User.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> getUserByFilter(Long officeId, String firstName, String secondName, String middleName, String position, String docCode, String citizenshipCode) {
        CriteriaQuery<User> criteriaQuery = builderQuery(officeId, firstName, secondName, middleName, position, docCode, citizenshipCode);

        TypedQuery<User> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }

    private CriteriaQuery<User> builderQuery(Long officeId, String firstName, String secondName, String middleName, String position, String docCode, String citizenshipCode) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);
        criteriaQuery.select(userRoot);
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(criteriaBuilder.equal(userRoot.get("officeId"), officeId));

        if (firstName != null) {
            predicateList.add(criteriaBuilder.equal(userRoot.get("firstName"), firstName));
        }

        if (secondName != null) {
            predicateList.add(criteriaBuilder.equal(userRoot.get("secondName"), secondName));
        }

        if (middleName != null) {
            predicateList.add(criteriaBuilder.equal(userRoot.get("middleName"), middleName));
        }

        if (position != null) {
            predicateList.add(criteriaBuilder.equal(userRoot.get("position"), position));
        }

        if (docCode != null) {
            predicateList.add(criteriaBuilder.equal(userRoot.get("docCode"), docCode));
        }

        if (citizenshipCode != null) {
            predicateList.add(criteriaBuilder.equal(userRoot.get("citizenshipCode"), citizenshipCode));
        }

        criteriaQuery.where(predicateList.toArray(new Predicate[]{}));
        return criteriaQuery;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveUser(User user) {

        em.persist(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateUser(User user) {
        User u = em.find(User.class, user.getId());

        if (u != null) {
            u.setFirstName(user.getFirstName());
            u.setMiddleName(user.getMiddleName());
            u.setSecondName(user.getSecondName());
            u.setPosition(user.getPosition());
            u.setOfficeId(user.getOfficeId());
            u.setPhone(user.getPhone());
            u.setIdentified(user.isIdentified());
        } else {
            throw new IllegalArgumentException("user id:" + user.getId() + " for update not found!");
        }
        em.flush();
    }
}