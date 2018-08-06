package ru.bellintegrator.practice.doc_type.dao;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.doc_type.model.DocType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class DocTypeDaoImpl implements DocTypeDao {

    private  final EntityManager em;

    public DocTypeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<DocType> getAllDocType() {
        TypedQuery<DocType> query = em.createQuery("SELECT dt FROM dt", DocType.class);

        return query.getResultList();
    }
}
