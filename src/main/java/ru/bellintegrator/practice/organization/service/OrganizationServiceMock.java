package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.utils.ResultView;

import java.util.ArrayList;
import java.util.List;

//@Service
public class OrganizationServiceMock implements OrganizationService {

    public OrganizationServiceMock() {

    }

    @Override
    public List<OrganizationListView> getOrganizations(OrganizationListView organizationlistview) {
//    public String getOrganizations(String name, String inn, boolean isActive) {
        List<OrganizationListView> organizationViewList = new ArrayList<>();

        OrganizationListView organizationView = new OrganizationListView();
        //organizationView.countryId = "643";
        organizationView.id = 1L;
        //organizationView.address = "Address 1";
        //organizationView.fullName = "Name org 1";
        organizationView.inn = "INN";
        organizationView.isActive = true;
        //organizationView.kpp = "KPP";
        //organizationView.phone = "phone";

        organizationViewList.add(organizationView);

        return organizationViewList;
//        return "success";
    }

    @Override
    public OrganizationView getOrganizationById(Long id) {

        OrganizationView organizationView = new OrganizationView();
        organizationView.countryId = "643";
        organizationView.name = "Org 1";
        organizationView.address = "Address 1";
        organizationView.fullName = "Name org 1";
        organizationView.inn = "INN";
        organizationView.isActive = true;
        organizationView.kpp = "KPP";
        organizationView.phone = "phone";

        return organizationView;
    }

    @Override
    public ResultView saveOrganization(OrganizationView view) {
        return null;
    }

    @Override
    public ResultView updateOrganization(OrganizationView view) {
        return null;
    }
}
