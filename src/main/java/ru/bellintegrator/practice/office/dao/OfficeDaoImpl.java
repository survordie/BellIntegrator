package ru.bellintegrator.practice.office.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.office.model.Office;

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
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> getAllOffices() {
        TypedQuery<Office> query = em.createQuery("SELECT o FROM Office o", Office.class);

        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office getOfficeById(Long id) {

        return em.find(Office.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> getOfficeByFilter(Long orgId, String name, String phone, boolean isActive) {
        CriteriaQuery<Office> criteriaQuery = buildQuery(orgId, name, phone, isActive);

        TypedQuery<Office> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }

    private CriteriaQuery<Office> buildQuery(Long orgId, String name, String phone, boolean isActive) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Office> criteriaQuery = criteriaBuilder.createQuery(Office.class);
        Root<Office> officeRoot = criteriaQuery.from(Office.class);
        criteriaQuery.select(officeRoot);
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(criteriaBuilder.equal(officeRoot.get("organizationId"), orgId));

        if (name != null) {
            predicateList.add(criteriaBuilder.equal(officeRoot.get("name"), name));
        }

        if (phone != null) {
            predicateList.add(criteriaBuilder.equal(officeRoot.get("phone"), phone));
        }

        if (isActive) {
            predicateList.add(criteriaBuilder.equal(officeRoot.get("isActive"), isActive));
        }

        criteriaQuery.where(predicateList.toArray(new Predicate[]{}));
        return criteriaQuery;
    }

    @Override
    public void saveOffice(Office office) {
        em.persist(office);
    }

    @Override
    public void updateOffice(Office office) {
        Office of = em.find(Office.class, office.getId());

        if (of != null) {
            of.setName(office.getName());
            of.setOrganizationId(office.getOrganizationId());
            of.setAddress(office.getAddress());
            of.setPhone(office.getPhone());
            of.setIsActive(office.getIsActive());
        } else {
            throw new IllegalArgumentException("office for update not found!");
        }
        em.flush();
    }
}
