package ru.bellintegrator.practice.country.model;

import ru.bellintegrator.practice.organization.model.Organization;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Наименование страны
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Код страны
     */
    @Column(name = "code", nullable = false)
    private String code;

    /**
     * Список организаций в стране
     */
    @OneToMany(mappedBy = "countryId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Organization> organization;

    /**
     * Конструктор для hibernate
     */
    public Country(){

    }

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Organization> getOrganization() {
        return organization;
    }

    public void addOrganization(Organization organization) {
        getOrganization().add(organization);
        organization.setCountryId(this);
    }

    public void removeOrganization(Organization organization){
        getOrganization().remove(organization);
        organization.setCountryId(null);
    }
}
