package ru.bellintegrator.practice.doc_type.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.doc_type.service.DocTypeService;
import ru.bellintegrator.practice.doc_type.view.DocTypeView;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class DocTypeController {
    private final DocTypeService dtService;

    @Autowired
    public DocTypeController(DocTypeService dtService) {
        this.dtService = dtService;
    }

    @GetMapping(value = "/docs")
    public Set<DocTypeView> getDocs(){
        return dtService.getDocTypes();
    }
}
