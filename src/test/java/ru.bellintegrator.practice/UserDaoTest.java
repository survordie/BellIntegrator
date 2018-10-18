package ru.bellintegrator.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.doc.dao.DocDao;
import ru.bellintegrator.practice.doc.model.Doc;
import ru.bellintegrator.practice.doc_type.dao.DocTypeDao;
import ru.bellintegrator.practice.doc_type.model.DocType;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.user.dao.UserDao;
import ru.bellintegrator.practice.user.model.User;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resource")
@Transactional
@DirtiesContext
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Autowired
    DocDao docDao;

    @Autowired
    OfficeDao officeDao;

    @Autowired
    DocTypeDao docTypeDao;

    @Test
    public void saveUserTest(){
        Date date = Calendar.getInstance().getTime();
        DocType docType = docTypeDao.getDocTypeByCode("23");
        Office office = officeDao.getOfficeById(1L);
        Doc doc = new Doc(docType, "234", date);
        Set<Doc> docList = new HashSet<>();
        docList.add(doc);

        User user = new User(office, docList, "dsfg","","","","", true);

        userDao.saveUser(user);

        System.out.println(user);
    }
}
