package ru.bellintegrator.practice.doc_type.dao;

import ru.bellintegrator.practice.doc_type.model.DocType;

import java.util.Set;

/**
 * DAO для работы с типами документов
 */
public interface DocTypeDao {

    /**
     * Получить список типов документов
     *
     * @return
     */
    Set<DocType> getAllDocTypes();

    /**
     * Получить тип документа по коду
     *
     * @param code
     *
     * @return
     */
    DocType getDocTypeByCode(String code);
}
