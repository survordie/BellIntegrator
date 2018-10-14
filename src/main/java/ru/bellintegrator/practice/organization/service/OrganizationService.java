package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.utils.ResultView;

import java.util.List;

public interface OrganizationService {

    /**
     * Получить организации по фильтру
     * @param organizationlistview
     */
    List<OrganizationListView> getOrganizations(OrganizationListView organizationlistview);

    /**
     * Получить организацию по id
     */
    OrganizationView getOrganizationById(Long id);

    /**
     * Добавить данные организации
     */
    ResultView saveOrganization(OrganizationView view);

    /**
     * Обновить данные организации
     */
    ResultView updateOrganization(OrganizationView view);
}
