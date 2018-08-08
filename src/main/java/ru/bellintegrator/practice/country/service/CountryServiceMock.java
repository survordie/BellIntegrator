package ru.bellintegrator.practice.country.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.country.view.CountryView;

import java.util.HashSet;
import java.util.Set;

@Service
//@Primary
public class CountryServiceMock implements CountryService {

    public CountryServiceMock() {

    }

    @Override
//    public Set<CountryView> getCountries() {
    public String getCountries() {
        Set<CountryView> countryViewSet = new HashSet<>();
        CountryView countryView = new CountryView();
        countryView.code = "643";
        countryView.name = "Russia";
        countryViewSet.add(countryView);
//        return countryViewSet;
        return "643";
    }
}
