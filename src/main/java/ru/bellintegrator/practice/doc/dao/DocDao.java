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
     * @param doc
     */
    void saveDocument(Doc doc);

    /**
     * Обновить данные нового документа
     * @param doc
     */
    void updateDocument(Doc doc);

    /**
     * Получить список документов по фильтру
     *
     * @return
     */
    Doc getDocumentsByFilter(Long id);
}
