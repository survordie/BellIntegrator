package ru.bellintegrator.practice.office.controller;

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

    @PostMapping(value = "/list")
    public List<OfficeView> getOffices(OfficeView officeView) {
        return officeService.getOffices(officeView);
    }

    @GetMapping(value = "/{id}")
    public OfficeView getOfficeById(@PathVariable Long id) {
        return officeService.getOfficeById(id);
    }

    @PostMapping(value = "/update")
    public ResultView updateOffice(@RequestBody OfficeView view) {
        return officeService.updateOffice(view);
    }

    @PostMapping(value = "/save")
    public ResultView saveOffice(@RequestBody OfficeView view) {
        return officeService.saveOffice(view);
    }
}
