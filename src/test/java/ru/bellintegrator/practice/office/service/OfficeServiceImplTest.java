package ru.bellintegrator.practice.office.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import ru.bellintegrator.practice.country.model.Country;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.utils.ResultView;

import javax.persistence.EntityExistsException;
import javax.persistence.TransactionRequiredException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class OfficeServiceImplTest {

    private List<Office> officeList;
    private Organization organization;
    private Country country;
    private Office office;
    private ResultView resultView;

    @MockBean
    private OrganizationDao organizationDao;

    @MockBean
    private OfficeDao officeDao;

    @Before
    public void setUp() {
        resultView = new ResultView();
        country = new Country("РФ", "643");
        organization = new Organization(country, "Tinkoff", "Tinkoffbank", "7710140679", "773401001", "Москваезд", "", true);
        officeList = new ArrayList<>();

        office = new Office(organization, "Москва", "г. Москва, улица Правды", "", true);
        officeList.add(office);
    }

    @Test
    public void getOffices() {

        Mockito.doReturn(officeList)
                .when(officeDao)
                .getOfficeByFilter(1L, "", "", true);

        List<Office> list = officeDao.getOfficeByFilter(1L, "", "", true);

        Assert.assertNotNull(list);
        Assert.assertEquals(officeList.size(), 1);
    }

    @Test
    public void getOfficeById() {

        Mockito.doReturn(office)
                .when(officeDao)
                .getOfficeById(1L);

        Office o = officeDao.getOfficeById(1L);

        Assert.assertNotNull(o);
        Assert.assertEquals(o, office);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void updateOfficeError() {

        Mockito.doThrow(new DataIntegrityViolationException("office id not found"))
                .when(officeDao)
                .updateOffice(office);

        officeDao.updateOffice(office);
    }

    @Test(expected = EntityExistsException.class)
    public void saveOfficeThrow1() {
        Mockito.doThrow(new EntityExistsException("office already exists"))
                .when(officeDao)
                .saveOffice(office);

        officeDao.saveOffice(office);
    }

}