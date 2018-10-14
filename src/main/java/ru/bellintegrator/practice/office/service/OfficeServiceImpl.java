package ru.bellintegrator.practice.office.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.utils.ResultView;

import java.util.List;

@Service
@Primary
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao officeDao;
    private final OrganizationDao organizationDao;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, OrganizationDao organizationDao) {
        this.officeDao = officeDao;
        this.organizationDao = organizationDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> getOffices(OfficeView officeView) {

        List<Office> officeList = officeDao.getOfficeByFilter(officeView.organizationId, officeView.name, officeView.phone, officeView.isActive);
        List<OfficeView> officeViewList = mapOfficeListView(officeList);

        return officeViewList;
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeView getOfficeById(Long id) {

        Office office = officeDao.getOfficeById(id);

        OfficeView view = mapOffice(office);

        return view;
    }



    @Override
    @Transactional
    public ResultView updateOffice(OfficeView officeView) {

        if (officeDao.getOfficeById(officeView.id) != null) {
            Office office = reverseMapOffice(officeView);
            office.setOrganizationId(organizationDao.getOrganizationById(officeView.organizationId));

            officeDao.updateOffice(office);
        } else{
            throw new DataIntegrityViolationException(officeView.id + "not found");
        }
        return new ResultView();
    }

    @Override
    @Transactional
    public ResultView saveOffice(OfficeView officeView) {

        Office office = reverseMapOffice(officeView);
        office.setOrganizationId(organizationDao.getOrganizationById(officeView.organizationId));

        officeDao.saveOffice(office);

        return new ResultView();
    }

    private OfficeView mapOffice(Office office) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Office.class, OfficeView.class).exclude("organizationId").mapNulls(false).byDefault().register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        OfficeView officeView = mapperFacade.map(office, OfficeView.class);

        return officeView;
    }

    private Office reverseMapOffice(OfficeView officeView) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(OfficeView.class, Office.class).mapNulls(false).byDefault().register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        Office office = mapperFacade.map(officeView, Office.class);

        return office;
    }

    private List<OfficeView> mapOfficeListView(List<Office> officeList) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
        mapperFactory.classMap(Office.class, OfficeView.class).exclude("organizationId").mapNulls(false).byDefault().register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        List<OfficeView> officeViewList = mapperFacade.mapAsList(officeList, OfficeView.class);

        return officeViewList;
    }
}
