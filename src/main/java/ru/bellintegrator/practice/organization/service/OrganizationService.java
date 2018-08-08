package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

public interface OrganizationService {

    /**
     * Получить организации по фильтру
     * @param name
     * @param inn
     * @param isActive
     */
    List<OrganizationListView> getOrganizations(String name, String inn, boolean isActive);

    /**
     * Получить организацию по id
     */
    OrganizationView getOrganizationById(Long id);

    /**
     * Добавить данные организации
     */
    String saveOrganization(OrganizationView view);
}
