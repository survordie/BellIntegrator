package ru.bellintegrator.practice.office.model;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.user.model.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "office")
public class Office {

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
     * Идентификатор организации
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Organization organizationId;

    /**
     * Список юзеров
     */
    @OneToMany(mappedBy = "officeId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users;

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
    private String isActive;

    /**
     * Конструктор для hibernate
     */
    public Office(){

    }

    public Office(String name, String address, String phone, String isActive) {
        this.name = name;
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

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Organization getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Organization organizationId) {
        this.organizationId = organizationId;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        getUsers().add(user);
        user.setOfficeId(this);
    }

    public void removeUser(User user){
        getUsers().remove(user);
        user.setOfficeId(null);
    }
}
