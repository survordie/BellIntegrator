package ru.bellintegrator.practice.doc_type.dao;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.doc_type.model.DocType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Repository
public class DocTypeDaoImpl implements DocTypeDao {

    private final EntityManager em;

    public DocTypeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Set<DocType> getAllDocTypes() {
        TypedQuery<DocType> query = em.createQuery("SELECT dt FROM DocType dt", DocType.class);

        return query.getResultList().stream().collect(Collectors.toSet());
    }
}
