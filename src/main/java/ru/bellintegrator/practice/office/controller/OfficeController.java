package ru.bellintegrator.practice.office.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.Set;

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
    public Set<OfficeView> getOffices(){
        return  officeService.getOffices();
    }

    @GetMapping(value = "/{id}")
    public OfficeView getOfficeById(@PathVariable long id){
        return officeService.getOfficeById();
    }

    @GetMapping(value = "/update")
    public String updateOffice(@RequestBody OfficeView view){
        return officeService.updateOffice(view);
    }

    @GetMapping(value = "/save")
    public String saveOffice(@RequestBody OfficeView view){
        return officeService.saveOffice(view);
    }
}
