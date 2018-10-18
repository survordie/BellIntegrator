package ru.bellintegrator.practice.user.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.doc.dao.DocDao;
import ru.bellintegrator.practice.doc.model.Doc;
import ru.bellintegrator.practice.doc_type.dao.DocTypeDao;
import ru.bellintegrator.practice.doc_type.model.DocType;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.user.dao.UserDao;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.view.UserListView;
import ru.bellintegrator.practice.user.view.UserView;
import ru.bellintegrator.practice.utils.ResultView;

import java.util.*;

@Service
@Primary
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final UserDao userDao;
    private final DocDao docDao;
    private final DocTypeDao docTypeDao;
    private final OfficeDao officeDao;

    public UserServiceImpl(UserDao userDao, DocDao docDao, DocTypeDao docTypeDao, OfficeDao officeDao) {
        this.userDao = userDao;
        this.docDao = docDao;
        this.docTypeDao = docTypeDao;
        this.officeDao = officeDao;
    }

    @Override
    @Transactional(readOnly = true)
    public UserView getUserById(Long id) {
        User user = userDao.getUserById(id);
        Doc doc = docDao.getDocumentsByFilter(user.getId());
        DocType docType = doc.getDocCode();

        UserView userView = mapUser(user);
        userView.docName = docType.getName();
        userView.docNumber = doc.getDocNumber();
        userView.docDate = doc.getDocDate();

        return userView;
    }


    @Override
    @Transactional(readOnly = true)
    public List<UserListView> getUserList(UserListView userListView) {
        List<User> userList = userDao.getUserByFilter(userListView.officeId, userListView.firstName, userListView.secondName, userListView.middleName, userListView.position, userListView.docCode, userListView.citizenshipCode);
        List<UserListView> userListViews = mapUserList(userList);

        return userListViews;
    }


    @Override
    public ResultView updateUser(UserView user) {
        return null;
    }

    @Override
    @Transactional
    public ResultView saveUser(UserView userView) {

        /*User user = mapReverseUser(userView);
        Office office = officeDao.getOfficeById(userView.officeId);
        DocType docType = docTypeDao.getDocTypeByCode(userView.docCode);

        Doc doc = new Doc(docType, userView.docNumber, userView.docDate);
        Set<Doc> docList = user.getDocId();
        docList.add(doc);
        user.setOfficeId(office);
        user.setDocId(docList);*/

        Date date = Calendar.getInstance().getTime();
        DocType docType = docTypeDao.getDocTypeByCode("23");
        Office office = officeDao.getOfficeById(1L);
        Doc doc = new Doc(docType, "234", date);
        Set<Doc> docList = new HashSet<>();
        docList.add(doc);

        User user = new User(office, docList, "dsfg","","","","", true);

        log.debug(user.toString());
        userDao.saveUser(user);

        return new ResultView();
    }

    private UserView mapUser(User user) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
        mapperFactory.classMap(User.class, UserView.class).exclude("officeId").exclude("docId").mapNulls(false).byDefault().register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        UserView userView = mapperFacade.map(user, UserView.class);

        return userView;
    }

    private List<UserListView> mapUserList(List<User> userList) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(User.class, UserListView.class).exclude("officeId").exclude("docId").mapNulls(false).byDefault().register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        List<UserListView> userViewList = mapperFacade.mapAsList(userList, UserListView.class);

        return userViewList;
    }

    private User mapReverseUser(UserView userView) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(UserView.class, User.class).mapNulls(false).exclude("officeId").exclude("id").byDefault().register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        User user = mapperFacade.map(userView, User.class);

        return user;
    }
}
