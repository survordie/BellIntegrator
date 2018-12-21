package ru.bellintegrator.practice.doc_type.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.doc_type.dao.DocTypeDao;
import ru.bellintegrator.practice.doc_type.model.DocType;
import ru.bellintegrator.practice.doc_type.view.DocTypeView;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
@Primary
public class DocTypeServiceImpl implements DocTypeService {

    private final DocTypeDao docTypeDao;

    @Autowired
    public DocTypeServiceImpl(DocTypeDao docTypeDao) {this.docTypeDao = docTypeDao;}

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Set<DocTypeView> getDocTypes() {
        Set<DocType> docTypeSet = docTypeDao.getAllDocTypes();

        return docTypeSet.stream().map(mapDocType()).collect(Collectors.toSet());
    }

    private Function<DocType, DocTypeView> mapDocType() {
        return dt -> {
            DocTypeView view = new DocTypeView();
            view.id = dt.getId();
            view.code = dt.getCode();
            view.name = dt.getName();

            return view;
        };
    }
}
