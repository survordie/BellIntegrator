package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.utils.ResultView;

import java.util.List;

/**
 * Сервис для работы с организациями
 */
public interface OrganizationService {

    /**
     * Получить организации по фильтру
     *
     * @param organizationlistview
     * @return
     */
    List<OrganizationListView> getOrganizations(OrganizationListView organizationlistview);

    /**
     * Получить организацию по id
     *
     * @param id
     * @return
     */
    OrganizationView getOrganizationById(Long id);

    /**
     * Добавить данные организации
     *
     * @param view
     * @return
     */
    ResultView saveOrganization(OrganizationView view);

    /**
     * Обновить данные организации
     *
     * @param view
     * @return
     */
    ResultView updateOrganization(OrganizationView view);
}
