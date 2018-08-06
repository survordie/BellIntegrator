package ru.bellintegrator.practice.doc_type.dao;

import ru.bellintegrator.practice.doc_type.model.DocType;

import java.util.List;

/**
 * DAO для работы с типами документов
 */
public interface DocTypeDao {

    /**
     * Получить список типов документов
     *
     * @return
     */
    List<DocType> getAllDocType();
}
