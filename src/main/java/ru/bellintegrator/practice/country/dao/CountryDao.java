package ru.bellintegrator.practice.country.dao;

import ru.bellintegrator.practice.country.model.Country;

import java.util.List;

/**
 * DAO для работы со странами
 */
public interface CountryDao {

    /**
     *  Получить список всех стран
     *
     * @return
     */
    public List<Country> getAllCountry();
}
