package ru.bellintegrator.practice.office.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.OfficeView;

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

    @GetMapping(value = "/list")
    public List<OfficeView> getOffices() {
        return officeService.getOffices();
    }

    @GetMapping(value = "/{id}")
    public OfficeView getOfficeById(@RequestBody OfficeView view) {
        return officeService.getOfficeById(view);
    }

    @GetMapping(value = "/update")
    public String updateOffice(@RequestBody OfficeView view) {
        return officeService.updateOffice(view);
    }

    @GetMapping(value = "/save")
    public String saveOffice(@RequestBody OfficeView view) {
        return officeService.saveOffice(view);
    }
}
