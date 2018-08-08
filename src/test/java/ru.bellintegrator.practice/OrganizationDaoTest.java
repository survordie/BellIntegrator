package ru.bellintegrator.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
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

    @Test
    public void test(){
        List<Organization> organizationList = organizationDao.getOrganizationByFilter("Tinkoff","7710140679",true);
        for (Organization organization : organizationList) {
            System.out.println(organization);
        }
    }
}
