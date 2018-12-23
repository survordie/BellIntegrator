package ru.bellintegrator.practice.office.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.utils.ResultView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(@RequestBody OfficeService officeService) {
        this.officeService = officeService;
    }

    @ApiOperation(value = "Resource to get offices by filter", nickname = "getOffices", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @PostMapping(value = "/list")
    public List<OfficeView> getOffices(@RequestBody OfficeView officeView) {
        return officeService.getOffices(officeView);
    }

    @ApiOperation(value = "Resource to get offices by ID", nickname = "getOfficeById", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @GetMapping(value = "/{id}")
    public OfficeView getOfficeById(@PathVariable Long id) {
        return officeService.getOfficeById(id);
    }

    @ApiOperation(value = "Resource to update office", nickname = "updateOffice", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @PostMapping(value = "/update")
    public ResultView updateOffice(@RequestBody OfficeView view) {
        return officeService.updateOffice(view);
    }

    @ApiOperation(value = "Resource to create office", nickname = "saveOffice", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @PostMapping(value = "/save")
    public ResultView saveOffice(@RequestBody OfficeView view) {
        return officeService.saveOffice(view);
    }
}
