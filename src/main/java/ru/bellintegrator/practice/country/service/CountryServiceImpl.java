package ru.bellintegrator.practice.country.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.country.dao.CountryDao;
import ru.bellintegrator.practice.country.model.Country;
import ru.bellintegrator.practice.country.view.CountryView;


import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Primary
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;

    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    @Transactional
//    public Set<CountryView>
    public String getCountries() throws JsonProcessingException {
        Set<Country> countrySet = countryDao.getAllCountries();
        Set<CountryView> countryViewSet = countrySet.stream().map(mapCountry()).collect(Collectors.toSet());

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

        StringBuilder stringBuilder = new StringBuilder();

        for (CountryView countryView : countryViewSet) {
            stringBuilder.append(mapper.writeValueAsString(countryView));
        }

        return stringBuilder.toString();
    }

    private Function<Country, CountryView> mapCountry(){
        return c -> {
            CountryView view = new CountryView();
            view.id = c.getId();
            view.code = c.getCode();
            view.name = c.getName();

            return view;
        };
    }
}
