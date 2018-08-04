package ru.bellintegrator.practice.doc_type.service;

import ru.bellintegrator.practice.doc_type.view.DocTypeView;

import java.util.Set;

public interface DocTypeService {

    /**
     * Получить список типов документов
     */
    Set<DocTypeView> getDocTypes();
}
