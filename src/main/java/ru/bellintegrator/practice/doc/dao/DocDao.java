package ru.bellintegrator.practice.doc.dao;

import ru.bellintegrator.practice.doc.model.Doc;

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

    /**
     * Сохранить данные нового документа
     */
    void saveDocument(Doc doc);
}
