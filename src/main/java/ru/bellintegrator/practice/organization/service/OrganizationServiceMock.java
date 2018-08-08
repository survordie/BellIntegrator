package ru.bellintegrator.practice.organization.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.ArrayList;
import java.util.List;

@Service
//@Primary
public class OrganizationServiceMock implements OrganizationService {

    public OrganizationServiceMock() {

    }

    @Override
    public List<OrganizationListView> getOrganizations(OrganizationListView view) {
        List<OrganizationListView> organizationViewList = new ArrayList<>();

        OrganizationListView organizationView = new OrganizationListView();
        //organizationView.countryId = "643";
        organizationView.name = "Org 1";
        //organizationView.address = "Address 1";
        //organizationView.fullName = "Name org 1";
        organizationView.inn = "INN";
        organizationView.isActive = true;
        //organizationView.kpp = "KPP";
        //organizationView.phone = "phone";

        organizationViewList.add(organizationView);

        return organizationViewList;
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
    public String updateOrganization(OrganizationView view) {
        return "success";
    }

    @Override
    public String saveOrganization(OrganizationView view) {
        return "success";
    }
}
