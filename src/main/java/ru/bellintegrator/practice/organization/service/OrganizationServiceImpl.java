package ru.bellintegrator.practice.organization.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.country.dao.CountryDao;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.utils.ResultView;

import java.sql.SQLException;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
@Primary
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao organizationDao;
    private final CountryDao countryDao;
    private static final String OK = "result\": \"success";

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao, CountryDao countryDao) {
        this.organizationDao = organizationDao;
        this.countryDao = countryDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OrganizationListView> getOrganizations(OrganizationListView organizationlistview) {

        List<Organization> organizationList = organizationDao.getOrganizationByFilter(organizationlistview.name, organizationlistview.inn, organizationlistview.isActive);
        List<OrganizationListView> organizationListView = mapOrganizationListView(organizationList);


        return organizationListView;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OrganizationView getOrganizationById(Long id) {
        Organization organization = organizationDao.getOrganizationById(id);

        OrganizationView view = mapOrganization(organization);

        return view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultView saveOrganization(OrganizationView view) {

        Organization organization = reverseMapOrganization(view);
        organization.setCountryId(countryDao.getCountryByCode(view.countryId));

        organizationDao.saveOrganization(organization);

        return new ResultView();
    }

    @Override
    @Transactional
    public ResultView updateOrganization(OrganizationView view) {

        if (organizationDao.getOrganizationById(view.id) != null) {
            Organization organization = reverseMapOrganization(view);
            organization.setCountryId(countryDao.getCountryByCode(view.countryId));

            organizationDao.updateOrganization(organization);
        } else{
            throw new DataIntegrityViolationException(view.id + "not found");
        }
        return new ResultView();
    }

    private OrganizationView mapOrganization(Organization organization) {

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Organization.class, OrganizationView.class).exclude("countryId").mapNulls(false).byDefault().register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        OrganizationView organizationView = mapperFacade.map(organization, OrganizationView.class);

        return organizationView;
    }

    private Organization reverseMapOrganization(OrganizationView organizationView) {

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(OrganizationView.class, Organization.class).mapNulls(false).byDefault().register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        Organization organization = mapperFacade.map(organizationView, Organization.class);

        return organization;
    }

    private List<OrganizationListView> mapOrganizationListView(List<Organization> organization) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
        mapperFactory.classMap(Organization.class, OrganizationListView.class).mapNulls(false).byDefault().register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        List<OrganizationListView> organizationListView = mapperFacade.mapAsList(organization, OrganizationListView.class);

        return organizationListView;
    }
}
