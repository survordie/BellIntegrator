package ru.bellintegrator.practice.organization.model;

import org.hibernate.mapping.FetchProfile;
import ru.bellintegrator.practice.country.model.Country;
import ru.bellintegrator.practice.office.model.Office;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organization")
public class Organization {

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
     * Страна
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "code")
    private Country countryId;

    /**
     * Имя
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Полное имя
     */
    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;

    /**
     * ИНН
     */
    @Column(name = "inn", length = 12, nullable = false)
    private String inn;

    /**
     * КПП
     */
    @Column(name = "kpp", length = 9, nullable = false)
    private String kpp;

    /**
     * Адрес
     */
    @Column(name = "address", length = 200, nullable = false)
    private String address;

    /**
     * Номер телефона
     */
    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    /**
     * Работает или нет?
     */
    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @OneToMany(mappedBy = "organization_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Office> offices;

    /**
     * Конструктор для hibernate
     */
    public Organization(){

    }

    public Organization(String name, String fullName, String inn, String kpp, String address, String phone, boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public List<Office> getOffices() {
        return offices;
    }

    public void addOffice(Office office) {
        getOffices().add(office);
        office.setOrganizationId(this);
    }

    public void removeOffice(Office office){
        getOffices().remove(office);
        office.setOrganizationId(null);
    }
}
