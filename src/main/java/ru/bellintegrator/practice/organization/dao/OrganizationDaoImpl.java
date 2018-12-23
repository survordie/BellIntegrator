package ru.bellintegrator.practice.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> getAllOrganizations() {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o", Organization.class);

        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization getOrganizationById(Long id) {

        return em.find(Organization.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> getOrganizationByFilter(String name, String inn, boolean isActive) {

        CriteriaQuery<Organization> criteriaQuery = buildQuery(name, inn, isActive);

        TypedQuery<Organization> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }

    private CriteriaQuery<Organization> buildQuery(String name, String inn, boolean isActive) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Organization> criteriaQuery = criteriaBuilder.createQuery(Organization.class);
        Root<Organization> organizationRoot = criteriaQuery.from(Organization.class);
        criteriaQuery.select(organizationRoot);
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(criteriaBuilder.equal(organizationRoot.get("name"), name));

        if (inn != null) {
            predicateList.add(criteriaBuilder.equal(organizationRoot.get("inn"), inn));
        }

        if (isActive) {
            predicateList.add(criteriaBuilder.equal(organizationRoot.get("isActive"), isActive));
        }

        criteriaQuery.where(predicateList.toArray(new Predicate[]{}));
        return criteriaQuery;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveOrganization(Organization organization) {

        em.persist(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateOrganization(Organization organization) {

        Organization org = em.find(Organization.class, organization.getId());
        if (org != null) {
            org.setCountryId(organization.getCountryId());
            org.setName(organization.getName());
            org.setPhone(organization.getPhone());
            org.setKpp(organization.getKpp());
            org.setInn(organization.getInn());
            org.setFullName(organization.getFullName());
            org.setAddress(organization.getAddress());
            org.setActive(organization.isActive());
        }
        em.flush();
    }
}
