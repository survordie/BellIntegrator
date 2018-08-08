package ru.bellintegrator.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationListView;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resource")
@Transactional
@DirtiesContext
public class OrganizationServiceTest {

    @Autowired
    private OrganizationService organizationService;

    @Test
    public void test(){
        List<OrganizationListView> organizationListViews = organizationService.getOrganizations("Tinkoff","7710140679",true);

        for (OrganizationListView organizationListView : organizationListViews) {
            System.out.println(organizationListView.toString());
        }
        System.out.println(organizationListViews.size());
//        String string = organizationService.getOrganizations("Tinkoff","7710140679",true);
    }
}
