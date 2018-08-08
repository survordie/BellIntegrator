package ru.bellintegrator.practice.country.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.bellintegrator.practice.country.view.CountryView;

import java.util.List;
import java.util.Set;

public interface CountryService {

    /**
     * Получить список стран
     *
     * @return
     */
//    Set<CountryView> getCountries();
    String getCountries() throws JsonProcessingException;
}
