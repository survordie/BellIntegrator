package ru.bellintegrator.practice.organization.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationListView;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Primary
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao organizationDao;

    public OrganizationServiceImpl(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    @Override
    public List<OrganizationListView> getOrganizations(String name, String inn, boolean isActive) {

        List<Organization> organizationList = organizationDao.getOrganizationByFilter(name, inn, isActive);
        List<OrganizationListView> organizationListView = new ArrayList<>();


        return organizationList.stream().map(mapOrganizationLV()).collect(Collectors.toList());
    }

    @Override
    public OrganizationView getOrganizationById(Long id) {
        Organization organization = organizationDao.getOrganizationById(id);
//        OrganizationView view = new OrganizationView();
//
//        view.id = organization.getId();
//        view.name = organization.getName();
//        view.fullName = organization.getFullName();
//        view.inn = organization.getInn();
//        view.kpp = organization.getKpp();
//        view.address = organization.getAddress();
//        view.phone = organization.getPhone();
//        view.isActive = organization.isActive();
        OrganizationView view = mapOrganization(organization);

        return view;
    }

    @Override
    public String saveOrganization(OrganizationView view) {
        return null;
    }

    private OrganizationView mapOrganization(Organization organization) {

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
        mapperFactory.classMap(Organization.class, OrganizationView.class).exclude("countryId").byDefault().register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        OrganizationView organizationView = mapperFacade.map(organization, OrganizationView.class);

        return organizationView;
    }

    private OrganizationListView mapOrganizationListView(Organization organization){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Organization.class, OrganizationListView.class);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        OrganizationListView organizationListView = mapperFacade.map(organization, OrganizationListView.class);

        return organizationListView;
    }

    private Function<Organization, OrganizationListView> mapOrganizationLV(){
        return  o -> {
            return mapOrganizationListView(o);
        };
    }
}
