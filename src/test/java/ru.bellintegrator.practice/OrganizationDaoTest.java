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
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resource")
@Transactional
@DirtiesContext
public class OrganizationDaoTest {

    @Autowired
    private OrganizationDao organizationDao;

    @Autowired
    private CountryDao countryDao;

    @Test
    public void test(){
        List<Organization> organizationList = organizationDao.getOrganizationByFilter("Tinkoff","7710140679",true);
        Assert.assertEquals(organizationList.size(), 1);
//        for (Organization organization : organizationList) {
//            System.out.println(organization);
//        }
    }

    @Test
    public void testSave(){
        Organization organization = new Organization();
        organization.setActive(true);
        organization.setAddress("dfgh");
        organization.setFullName("dgf");
        organization.setInn("34534");
        organization.setKpp("3243");
        organization.setPhone("3455");
        organization.setName("Tin");

        Country country = countryDao.getCountryByCode("643");
        organization.setCountryId(country);

        organizationDao.saveOrganization(organization);

        List<Organization> organizationList = organizationDao.getAllOrganizations();
        for (Organization org : organizationList) {
            System.out.println(org);
        }
    }
}
