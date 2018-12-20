package ru.bellintegrator.practice.organization.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import ru.bellintegrator.practice.country.dao.CountryDao;
import ru.bellintegrator.practice.country.model.Country;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationListView;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class OrganizationServiceImplTest {

    private Organization organization;
    private OrganizationListView organizationListView;
    private List<Organization> organizationList;
    private Country country;

    @MockBean
    private OrganizationDao organizationDao;

    @MockBean
    private CountryDao countryDao;

    @Before
    public void setUp() throws Exception {
        country = new Country("РФ", "643");
        organizationList = new ArrayList<>();
        organization = new Organization(country, "Tinkoff", "Tinkoffbank", "7710140679", "773401001", "Москваезд", "", true);
        organizationList.add(organization);
    }

    @Test
    public void getOrganizations() {

        Mockito.doReturn(organizationList)
                .when(organizationDao)
                .getOrganizationByFilter("Tinkoff", "7710140679", true);

        List<Organization> list = organizationDao.getOrganizationByFilter("Tinkoff", "7710140679", true);

        Assert.assertEquals(list, organizationList);
    }

    @Test
    public void getOrganizationById() {

        Mockito.doReturn(organization)
                .when(organizationDao)
                .getOrganizationById(1L);

        Organization org = organizationDao.getOrganizationById(1L);

        Assert.assertEquals(org, organization);
    }

    @Test(expected = EntityExistsException.class)
    public void saveOrganization() {

        Mockito.doThrow(new EntityExistsException("organization already exists"))
                .when(organizationDao)
                .saveOrganization(organization);

        organizationDao.saveOrganization(organization);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void updateOrganization() {
        Mockito.doThrow(new DataIntegrityViolationException("organization is not found"))
                .when(organizationDao)
                .updateOrganization(organization);

        organizationDao.updateOrganization(organization);
    }
}