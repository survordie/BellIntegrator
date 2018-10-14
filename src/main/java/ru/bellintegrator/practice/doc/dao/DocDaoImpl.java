package ru.bellintegrator.practice.doc.dao;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.doc.model.Doc;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Doc> getAllDocuments() {
        TypedQuery<Doc> query = em.createQuery("SELECT d FROM Doc d", Doc.class);

        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveDocument(Doc doc) {
        em.persist(doc);
    }
}
