package ru.bellintegrator.practice.office.dao;

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

    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Office> getAllOffices() {
        TypedQuery<Office> query = em.createQuery("SELECT o FROM o", Office.class);

        return query.getResultList();
    }

    @Override
    public Office getOfficebyId(Long id) {
        return em.find(Office.class, id);
    }

    @Override
    public Office getOfficeByFilter(String orgId, String name, String phone, boolean isActive) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Office> officeRoot = criteriaQuery.from(Office.class);
        criteriaQuery.select(officeRoot);
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(criteriaBuilder.equal(officeRoot.get("organizationId"), orgId));

        if(name != null){
            predicateList.add(criteriaBuilder.equal(officeRoot.get("name"), name));
        }

        if(phone != null){
            predicateList.add(criteriaBuilder.equal(officeRoot.get("phone"), phone));
        }

        if(isActive){
            predicateList.add(criteriaBuilder.equal(officeRoot.get("isActive"), isActive));
        }

        criteriaQuery.where(predicateList.toArray(new Predicate[]{}));

        TypedQuery<Office> query = em.createQuery(criteriaQuery);

        return query.getSingleResult();
    }

    @Override
    public void updateOffice(Office office) {
        em.persist(office);
    }

    @Override
    public void saveOffice(Office office) {
        em.persist(office);
    }
}