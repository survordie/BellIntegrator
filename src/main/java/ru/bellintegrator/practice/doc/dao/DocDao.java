package ru.bellintegrator.practice.doc.dao;

import ru.bellintegrator.practice.doc_type.model.Doc;

import java.util.List;

/**
 * DAO для работы с документами
 */
public interface DocDao {

    /**
     * Получить список всех документов
     *
     * @return
     */
    List<Doc> getAllDocuments();
}
