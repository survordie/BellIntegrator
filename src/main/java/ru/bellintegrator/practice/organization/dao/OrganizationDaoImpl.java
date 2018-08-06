package ru.bellintegrator.practice.organization.dao;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organization.model.Organization;

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
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Organization> getAllOrganization() {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM o", Organization.class);

        return query.getResultList();
    }

    @Override
    public Organization getOrganizationById(Long id) {
        return em.find(Organization.class, id);
    }

    @Override
    public Organization getOrganizationByFilter(String name, StringBuilder inn, boolean isActive) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Organization> criteriaQuery = criteriaBuilder.createQuery(Organization.class);
        Root<Organization> organizationRoot = criteriaQuery.from(Organization.class);
        criteriaQuery.select(organizationRoot);
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(criteriaBuilder.equal(organizationRoot.get("name"), name));

        if(inn != null){
            predicateList.add(criteriaBuilder.equal(organizationRoot.get("inn"), inn));
        }

        if(isActive){
            predicateList.add(criteriaBuilder.equal(organizationRoot.get("isActive"), isActive));
        }

        criteriaQuery.where(predicateList.toArray(new Predicate[]{}));

        TypedQuery<Organization> query = em.createQuery(criteriaQuery);

        return query.getSingleResult();
    }

    @Override
    public void updateOrganization(Organization organization) {
        em.persist(organization);
    }

    @Override
    public void saveOrganization(Organization organization) {
        em.persist(organization);
    }
}
