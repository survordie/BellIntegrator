package ru.bellintegrator.practice.doc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.doc.model.Doc;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class DocDaoImpl implements DocDao {

    private final EntityManager em;

    @Autowired
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

        if (doc != null) {
            em.persist(doc);
        } else {
            throw new NullPointerException("Документ не может быть пустым");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateDocument(Doc doc) {

        if (doc != null) {
            Doc d = em.find(Doc.class, doc.getId());

            if (d != null) {
                d.setDocNumber(doc.getDocNumber());
                d.setDocCode(doc.getDocCode());
                d.setDocDate(doc.getDocDate());
            }
        } else {
            throw new NullPointerException("Документ не может быть пустым");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Doc getDocumentsByFilter(Long id) {
        if (id != 0) {
        return em.find(Doc.class, id);
        } else {
            throw new IllegalArgumentException("Идентификатор документа не может быть равным нулю");
        }
    }

    private CriteriaQuery<Doc> buildQuery(Long id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Doc> query = builder.createQuery(Doc.class);

        Root<Doc> docRoot = query.from(Doc.class);
        query.select(docRoot);
        query.where(builder.equal(docRoot.get("id"), "id"));

        return query;
    }
}
