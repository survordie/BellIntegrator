package ru.bellintegrator.practice.country.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.bellintegrator.practice.country.dao.CountryDaoImpl;
import ru.bellintegrator.practice.country.model.Country;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
public class CountryServiceImplTest {

    private Country country;

    @MockBean
    private CountryDaoImpl countryDao;

    @Before
    public void setUp() throws Exception {
        country = new Country("РФ", "643");
    }

    @Test
    public void getCountries() {

        Set<Country> countryStub = new HashSet<Country>();
        countryStub.add(country);

        Mockito.doReturn(countryStub)
                .when(countryDao)
                .getAllCountries();
        Set<Country> countrySet = countryDao.getAllCountries();

        Assert.assertNotNull(countrySet);
    }

    @Test
    public void getCountryByCodeTest() {

        Mockito.doReturn(country)
                .when(countryDao)
                .getCountryByCode("643");

        Country country = countryDao.getCountryByCode("643");

        Assert.assertEquals(country.getCode(), "643");
        Assert.assertEquals(country.getName(), "РФ");
    }
}