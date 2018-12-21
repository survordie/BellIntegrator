package ru.bellintegrator.practice.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.utils.ResultView;

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
    public @ResponseBody
    List<OrganizationListView> getOrganizations(@RequestBody OrganizationListView organizationlistview) {
        return organizationService.getOrganizations(organizationlistview);
    }
//    public String getOrganizations(@RequestBody String name, String inn, boolean isActive) {
//        return organizationService.getOrganizations(name, inn, isActive);
//    }

    @GetMapping(value = "/{id}")
    public OrganizationView getOrganizationsById(@PathVariable Long id) {
        return organizationService.getOrganizationById(id);
    }

    @PostMapping(value = "/update")
    public ResultView updateOrganization(@RequestBody OrganizationView orgView) {
        return organizationService.updateOrganization(orgView);
    }

    @PostMapping(value = "/save")
    public ResultView saveOrganization(@RequestBody OrganizationView orgView) {
        return organizationService.saveOrganization(orgView);
    }
}
