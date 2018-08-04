package ru.bellintegrator.practice.user.model;

import ru.bellintegrator.practice.doc.model.Doc;
import ru.bellintegrator.practice.doc_type.model.DocType;
import ru.bellintegrator.practice.office.model.Office;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "Id")
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
    @JoinColumn(name = "office_id", nullable = false)
    private Office officeId;

    /**
     * Идентификатор документа
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "doc_id", nullable = false)
    private Set<Doc> docId;

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
    private int position;

    /**
     * Телефон
     */
    @Column(name = "phone", length = 20)
    private String phone;


    /**
     * Имя гражданина
     */
    @Column(name = "citizenship_name", length = 50)
    private String citizenshipName;

    /**
     * Код гражданина
     */
    @Column(name = "citizenship_code")
    private int citizenshipCode;

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

    public User(Office officeId, Set<Doc> docId, String firstName, String secondName, String middleName, int position, String phone, String citizenshipName, int citizenshipCode, boolean isIdentified) {
        this.officeId = officeId;
        this.docId = docId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.citizenshipName = citizenshipName;
        this.citizenshipCode = citizenshipCode;
        this.isIdentified = isIdentified;
    }

    public Long getId() {
        return id;
    }

    public Office getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Office officeId) {
        this.officeId = officeId;
    }

    public Set<Doc> getDocId() {
        if(docId != null){
            docId = new HashSet<>();
        }
        return docId;
    }

    public void addDocId(Doc docId) {
        getDocId().add(docId);
    }

    public void removeDocId(Doc docId){
        getDocId().remove(docId);
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public int getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(int citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public boolean isIdentified() {
        return isIdentified;
    }

    public void setIdentified(boolean identified) {
        isIdentified = identified;
    }
}
