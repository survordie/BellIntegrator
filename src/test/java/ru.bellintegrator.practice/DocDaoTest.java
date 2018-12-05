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

import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resource")
@Transactional
@DirtiesContext
public class DocDaoTest {

    @Autowired
    DocTypeDao docTypeDao;

    @Autowired
    DocDao docDao;

    @Test
    public void saveDocTest(){
//        Date date = Calendar.getInstance().getTime();
//        DocType docType = docTypeDao.getDocTypeByCode("21");
//        Doc doc = new Doc(docType, "234", date);
//
//        docDao.saveDocument(doc);
//
//        System.out.println(doc);
    }
}
