package ru.bellintegrator.practice.organization.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Resource to get organization by filter", nickname = "getOrganizations", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @PostMapping(value = "/list")
    public @ResponseBody
    List<OrganizationListView> getOrganizations(@RequestBody OrganizationListView organizationlistview) {
        return organizationService.getOrganizations(organizationlistview);
    }

    @ApiOperation(value = "Resource to get organization by ID", nickname = "getOrganizationsById", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @GetMapping(value = "/{id}")
    public OrganizationView getOrganizationsById(@PathVariable Long id) {
        return organizationService.getOrganizationById(id);
    }

    @ApiOperation(value = "Resource to update organization", nickname = "updateOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @PostMapping(value = "/update")
    public ResultView updateOrganization(@RequestBody OrganizationView orgView) {
        return organizationService.updateOrganization(orgView);
    }

    @ApiOperation(value = "Resource to create organization", nickname = "saveOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @PostMapping(value = "/save")
    public ResultView saveOrganization(@RequestBody OrganizationView orgView) {
        return organizationService.saveOrganization(orgView);
    }
}
