package ru.bellintegrator.practice.doc_type.service;

import ru.bellintegrator.practice.doc_type.view.DocTypeView;

import java.util.Set;

/**
 * Сервис для работы с типами документов
 */
public interface DocTypeService {

    /**
     * Получить список типов документов
     *
     * @return
     */
    Set<DocTypeView> getDocTypes();
}
