package ru.bellintegrator.practice.doc_type.service;

import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.doc_type.view.DocTypeView;

import java.util.HashSet;
import java.util.Set;

@Service
//@Primary
public class DocTypeServiceMock implements DocTypeService {

    public DocTypeServiceMock() {

    }

    @Override
    public Set<DocTypeView> getDocTypes() {
        Set<DocTypeView> docTypeViewSet = new HashSet<>();
        DocTypeView docTypeView = new DocTypeView();
        docTypeView.code = "21";
        docTypeView.name = "Passprot";
        docTypeViewSet.add(docTypeView);

        return docTypeViewSet;
    }
}
