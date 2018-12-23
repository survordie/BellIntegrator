package ru.bellintegrator.practice.user.model;

import ru.bellintegrator.practice.doc.model.Doc;
import ru.bellintegrator.practice.office.model.Office;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Пользователь
 */
@Entity
@Table(name = "User")
public class User {

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
     * Идентификатор офиса
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office officeId;

    /**
     * Идентификатор документа
     */
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Doc> docId = new HashSet<>();

    /**
     * Имя
     */
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "second_name", length = 50)
    private String secondName;

    /**
     * Отчество
     */
    @Column(name = "middle_name", length = 50)
    private String middleName;

    /**
     * Позиция
     */
    @Column(name = "position", nullable = false)
    private String position;

    /**
     * Телефон
     */
    @Column(name = "phone", length = 20)
    private String phone;

    /**
     * Идентифицирован
     */
    @Column(name = "is_identified")
    private boolean isIdentified;

    /**
     * Конструктор для hibernate
     */
    public User() {

    }

    public User(Office officeId, String firstName, String secondName, String middleName, String position, String phone, boolean isIdentified) {
        this.officeId = officeId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.isIdentified = isIdentified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Office getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Office officeId) {
        this.officeId = officeId;
    }

    public Set<Doc> getDocId() {
        return docId;
    }

    public void setDocId(Set<Doc> docId) {
        this.docId = docId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isIdentified() {
        return isIdentified;
    }

    public void setIdentified(boolean identified) {
        isIdentified = identified;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", officeId=" + officeId +
                ", docId=" + docId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", isIdentified=" + isIdentified +
                '}';
    }
}
