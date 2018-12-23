package ru.bellintegrator.practice.doc_type.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.doc_type.model.DocType;

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
public class DocTypeDaoImpl implements DocTypeDao {

    private final EntityManager em;

    @Autowired
    public DocTypeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<DocType> getAllDocTypes() {
        TypedQuery<DocType> query = em.createQuery("SELECT dt FROM DocType dt", DocType.class);

        return query.getResultList().stream().collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DocType getDocTypeByCode(String code) {

        final TypedQuery<DocType> query;

        if (code != null) {
            CriteriaQuery<DocType> criteriaQuery = buildQuery(code);
            query = em.createQuery(criteriaQuery);

        } else {
            throw new NullPointerException("Код документа должен быть заполнен");
        }
        return query.getSingleResult();
    }

    private CriteriaQuery<DocType> buildQuery(String code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<DocType> criteriaQuery = builder.createQuery(DocType.class);

        Root<DocType> root = criteriaQuery.from(DocType.class);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("code"), code));

        return criteriaQuery;
    }
}
