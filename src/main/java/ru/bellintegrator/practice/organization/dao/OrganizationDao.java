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
    List<Organization> getAllOrganizations();

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
     * @param (name,inn,isActive)
     * @return
     */
    List<Organization> getOrganizationByFilter(String name, String inn, boolean isActive);

    /**
     * СОзхранить данные организации
     *
     * @param organization
     * @return
     */
    void saveOrganization(Organization organization);
}
