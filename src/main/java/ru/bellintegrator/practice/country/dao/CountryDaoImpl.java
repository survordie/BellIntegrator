package ru.bellintegrator.practice.country.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.country.model.Country;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Repository
public class CountryDaoImpl implements CountryDao {

    private final EntityManager em;

    @Autowired
    public CountryDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Set<Country> getAllCountries() {
        TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);

        return query.getResultList().stream().collect(Collectors.toSet());
    }

    @Override
    public Country getCountryByCode(String code) {

        CriteriaQuery<Country> criteria = buildCriteria(code);
        TypedQuery<Country> query = em.createQuery(criteria);

        return query.getSingleResult();
    }

    private CriteriaQuery<Country> buildCriteria(String code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Country> criteria = builder.createQuery(Country.class);

        Root<Country> country = criteria.from(Country.class);
        criteria.where(builder.equal(country.get("code"), code));

        return criteria;
    }
}
