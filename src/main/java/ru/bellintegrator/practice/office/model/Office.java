package ru.bellintegrator.practice.office.model;

import ru.bellintegrator.practice.organization.model.Organization;

import javax.persistence.*;

@Entity
@Table(name = "Office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Идентификатор организации
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organizationId;

    /**
     * Имя офиса
     */
    @Column(name = "name", length = 200, nullable = false)
    private String name;

    /**
     * Адрес офиса
     */
    @Column(name = "address", length = 200, nullable = false)
    private String address;

    /**
     * Телефон офиса
     */
    @Column(name = "phone", length = 20)
    private String phone;

    /**
     * Офис работает?
     */
    @Column(name = "is_active")
    private boolean isActive;

    /**
     * Конструктор для hibernate
     */
    public Office() {

    }

    public Office(Organization organizationId, String name, String address, String phone, boolean isActive) {
        this.organizationId = organizationId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Organization getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Organization organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", organizationId=" + organizationId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive='" + isActive + '\'' +
                '}';
    }
}
