package ru.bellintegrator.practice.country.dao;

import ru.bellintegrator.practice.country.model.Country;

import java.util.List;
import java.util.Set;

/**
 * DAO для работы со странами
 */
public interface CountryDao {

    /**
     *  Получить список всех стран
     *
     * @return
     */
    public Set<Country> getAllCountries();
}
