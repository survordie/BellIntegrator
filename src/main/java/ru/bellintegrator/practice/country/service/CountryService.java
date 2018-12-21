package ru.bellintegrator.practice.country.service;

import ru.bellintegrator.practice.country.view.CountryView;

import java.util.Set;

/**
 * Сервис для работы со странами
 */
public interface CountryService {

    /**
     * Получить список стран
     *
     * @return
     */
    Set<CountryView> getCountries();
}
