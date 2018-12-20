package ru.bellintegrator.practice.doc_type.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.bellintegrator.practice.doc_type.dao.DocTypeDao;
import ru.bellintegrator.practice.doc_type.view.DocTypeView;

import java.util.HashSet;
import java.util.Set;


@RunWith(SpringRunner.class)
public class DocTypeServiceImplTest {

    @MockBean
    private DocTypeDao docTypeDao;

    @Test
    public void getDocTypes() {

        Set<DocTypeView> set = new HashSet<>();
        set.add(new DocTypeView());

        Mockito.doReturn(set)
                .when(docTypeDao)
                .getAllDocTypes();

        Assert.assertNotNull(set);
    }
}