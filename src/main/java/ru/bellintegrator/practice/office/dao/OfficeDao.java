package ru.bellintegrator.practice.office.dao;

import ru.bellintegrator.practice.office.model.Office;

import java.util.List;

/**
 * DAO для работы со офисами
 */
public interface OfficeDao {

    /**
     * Получить список всех офисов
     *
     * @return
     */
    List<Office> getAllOffices();

    /**
     * Получить офис по id
     *
     * @param id
     * @return
     */
    Office getOfficebyId(Long id);

    /**
     * Получить офис по фильтру
     *
     * @param (orgId,name,phone,isActive)
     * @return
     */
    Office getOfficeByFilter(String orgId, String name, String phone, boolean isActive);

    /**
     * Сохранить данные офиса
     *
     * @param office
     */
    void saveOffice(Office office);
}
