package ru.bellintegrator.practice.country.dao;

import ru.bellintegrator.practice.country.model.Country;

import java.util.Set;

/**
 * DAO для работы со странами
 */
public interface CountryDao {

    /**
     * Получить список всех стран
     *
     * @return
     */
    Set<Country> getAllCountries();

    /**
     * Получить данные страны по коду
     *
     * @param code
     * @return
     */
    Country getCountryByCode(String code);
}
