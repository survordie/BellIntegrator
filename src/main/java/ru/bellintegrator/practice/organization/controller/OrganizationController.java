package ru.bellintegrator.practice.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

@RestController
@RequestMapping(value = "/api/organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping(value = "/list")
    public List<OrganizationListView> getOrganizations(@RequestBody String name, String inn, boolean isActive) {
        return organizationService.getOrganizations(name, inn, isActive);
    }
//    public String getOrganizations(@RequestBody String name, String inn, boolean isActive) {
//        return organizationService.getOrganizations(name, inn, isActive);
//    }

    @GetMapping(value = "/{id}")
    public OrganizationView getOrganizationsById(@PathVariable long id) {
        return organizationService.getOrganizationById(id);
    }

    @PostMapping(value = "/update")
    public String updateOrganization(@RequestBody OrganizationView orgView) {
        return organizationService.saveOrganization(orgView);
    }

    @PostMapping(value = "/save")
    public String saveOrganization(@RequestBody OrganizationView orgView) {
        return organizationService.saveOrganization(orgView);
    }
}
