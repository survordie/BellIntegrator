package ru.bellintegrator.practice.doc.dao;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.doc_type.model.Doc;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class DocDaoImpl implements DocDao {

    private final EntityManager em;

    public DocDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Doc> getAllDocuments() {
        TypedQuery<Doc> query = em.createQuery("SELECT d FROM d", Doc.class);

        return query.getResultList();
    }
}
