package ru.bellintegrator.practice.user.service;

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
import ru.bellintegrator.practice.doc.dao.DocDao;
import ru.bellintegrator.practice.doc.model.Doc;
import ru.bellintegrator.practice.doc_type.dao.DocTypeDao;
import ru.bellintegrator.practice.doc_type.model.DocType;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.user.dao.UserDao;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.view.UserListView;
import ru.bellintegrator.practice.user.view.UserView;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    private User user;
    private List<User> users;
    private Doc doc;
    private DocType docType;
    private UserView userView;
    private UserListView userListView;
    private List<UserListView> listViews;
    private Office office;
    private Country country;
    private Organization organization;
    private List<Office> officeList;

    @MockBean
    private UserDao userDao;

    @MockBean
    private DocDao docDao;

    @MockBean
    private DocTypeDao docTypeDao;

    @MockBean
    private OfficeDao officeDao;

    @Before
    public void setUp() throws Exception {
        country = new Country("РФ", "643");
        organization = new Organization(country, "Tinkoff", "Tinkoffbank", "7710140679", "773401001", "Москваезд", "", true);
        officeList = new ArrayList<>();

        office = new Office(organization, "Москва", "г. Москва, улица Правды", "", true);
        officeList.add(office);

        user = new User(office, "Юзер", "Фамилия", "Отчество", "1", "", true);
        users = new ArrayList<>();
        users.add(user);

        userListView = new UserListView();

        userListView.id = 1L;
        userListView.officeId = office.getId();
        userListView.firstName = "user";
        userListView.secondName = "sname";
        userListView.middleName = "midname";
        userListView.position = "";
        userListView.docCode = "21";
        userListView.citizenshipCode = "643";

        listViews = new ArrayList<>();
        listViews.add(userListView);
    }

    @Test
    public void getUserById() {

        Mockito.doReturn(user)
                .when(userDao)
                .getUserById(1L);

        User u = userDao.getUserById(1L);

        Assert.assertEquals(u, user);
    }

    @Test
    public void getUserList() {

        Mockito.doReturn(users)
                .when(userDao)
                .getUserByFilter(1L, "", "", "", "", "", "");

        List<User> u = userDao.getUserByFilter(1L, "", "", "", "", "", "");

        Assert.assertEquals(u, users);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void updateUser() {

        Mockito.doThrow(new DataIntegrityViolationException("user not found"))
                .when(userDao)
                .updateUser(user);

        userDao.updateUser(user);
    }

    @Test(expected = EntityExistsException.class)
    public void saveUser() {
        Mockito.doThrow(new EntityExistsException("user already exists"))
                .when(userDao)
                .saveUser(user);

        userDao.saveUser(user);
    }
}