package ru.bellintegrator.practice.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.Set;

@RestController
@RequestMapping(value = "/api/organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping(value = "/list")
    public Set<OrganizationListView> getOrganizations(OrganizationListView orgView){
        return organizationService.getOrganizations(orgView);
    }

    @GetMapping(value = "/{id}")
    public OrganizationView getOrganizationsById(@PathVariable long id){
        return organizationService.getOrganizationById(id);
    }

    @GetMapping(value = "update")
    public String updateOrganization (OrganizationView orgView){
        return organizationService.updateOrganization(orgView);
    }

    @GetMapping(value = "save")
    public String saveOrganization (OrganizationView orgView){
        return organizationService.saveOrganization(orgView);
    }
}
