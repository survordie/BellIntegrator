package ru.bellintegrator.practice.organization.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

@Service
@Primary
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao organizationDao;

    public OrganizationServiceImpl(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    @Override
    public List<OrganizationListView> getOrganizations(OrganizationListView view) {
        return null;
    }

    @Override
    public OrganizationView getOrganizationById(Long id) {
        Organization organization = organizationDao.getOrganizationById(id);
        OrganizationView view = new OrganizationView();

        view.id = organization.getId();
        view.name = organization.getName();
        view.fullName = organization.getFullName();
        view.inn = organization.getInn();
        view.kpp = organization.getKpp();
        view.address = organization.getAddress();
        view.phone = organization.getPhone();
        view.isActive = organization.isActive();

        return view;
    }

    @Override
    public String updateOrganization(OrganizationView view) {
        return null;
    }

    @Override
    public String saveOrganization(OrganizationView view) {
        return null;
    }
}
