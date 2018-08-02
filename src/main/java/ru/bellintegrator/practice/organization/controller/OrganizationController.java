package ru.bellintegrator.practice.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public Set<OrganizationListView> getOrganizations(@RequestBody OrganizationListView orgView){
        return organizationService.getOrganizations(orgView);
    }

    @GetMapping(value = "/{id}")
    public OrganizationView getOrganizationsById(@PathVariable long id){
        return organizationService.getOrganizationById(id);
    }

    @GetMapping(value = "update")
    public String updateOrganization (@RequestBody OrganizationView orgView){
        return organizationService.updateOrganization(orgView);
    }

    @GetMapping(value = "save")
    public String saveOrganization (@RequestBody OrganizationView orgView){
        return organizationService.saveOrganization(orgView);
    }
}
