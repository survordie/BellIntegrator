package ru.bellintegrator.practice.country.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.country.service.CountryService;
import ru.bellintegrator.practice.country.view.CountryView;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "/api", description = "Операции с данными по странам")
@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @ApiOperation(value = "Resource to get countries", nickname = "getCountries", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @GetMapping(value = "/countries")
    public Set<CountryView> getCountries() {

        return countryService.getCountries();
    }

}
