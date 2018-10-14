package ru.bellintegrator.practice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.country.dao.CountryDao;
import ru.bellintegrator.practice.country.model.Country;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resource")
@Transactional
@DirtiesContext
public class CountryDaoTest {

    @Autowired
    private CountryDao countryDao;

    @Test
    public void test(){
        Set<Country> countrySet = countryDao.getAllCountries();
        Assert.assertNotNull(countrySet);
    }

    @Test
    public void test1(){
        Country country = countryDao.getCountryByCode("643");

        System.out.println(country.getId());
        System.out.println(country.getName());
        Assert.assertEquals(country.getCode(), "643");
    }
}
