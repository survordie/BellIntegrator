package ru.bellintegrator.practice.country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.country.dao.CountryDao;
import ru.bellintegrator.practice.country.model.Country;
import ru.bellintegrator.practice.country.view.CountryView;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
@Primary
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;

    @Autowired
    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Set<CountryView> getCountries() {
        Set<Country> countrySet = countryDao.getAllCountries();

        return countrySet.stream().map(mapCountry()).collect(Collectors.toSet());
    }

    private Function<Country, CountryView> mapCountry() {
        return c -> {
            CountryView view = new CountryView();
            view.id = c.getId();
            view.code = c.getCode();
            view.name = c.getName();

            return view;
        };
    }
}
