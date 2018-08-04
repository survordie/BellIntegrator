package ru.bellintegrator.practice.country.service;

import ru.bellintegrator.practice.country.view.CountryView;

import java.util.Set;

public interface CountryService {

    /**
     * Получить список стран
     */
    Set<CountryView> getCountries();
}
