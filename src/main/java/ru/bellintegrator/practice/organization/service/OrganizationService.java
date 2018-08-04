package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

public interface OrganizationService {

    /**
     * Получить организации по фильтру
     */
    List<OrganizationListView> getOrganizations(OrganizationListView view);

    /**
     * Получить организацию по id
     */
    OrganizationView getOrganizationById(Long id);

    /**
     * Обновить данные организации
     */
    String updateOrganization(OrganizationView view);

    /**
     * Добавить данные организации
     */
    String saveOrganization(OrganizationView view);
}
