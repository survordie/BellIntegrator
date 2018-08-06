package ru.bellintegrator.practice.organization.dao;

import ru.bellintegrator.practice.organization.model.Organization;

import java.util.List;

/**
 * DAO для работы со организациями
 */
public interface OrganizationDao {

    /**
     * Получить список всех организаций
     *
     * @return
     */
    List<Organization> getAllOrganization();

    /**
     * Получить организацию по id
     *
     * @param id
     * @return
     */
    Organization getOrganizationById(Long id);

    /**
     * Получить организацию по фильтру
     *
     * @param (name, inn, isActive)
     * @return
     */
    Organization getOrganizationByFilter(String name, StringBuilder inn, boolean isActive);

    /**
     * Обновить данные организации
     *
     * @param organization
     * @return
     */
    void updateOrganization(Organization organization);

    /**
     * Добавить новую организацию
     *
     * @param organization
     * @return
     */
    void saveOrganization(Organization organization);
}
