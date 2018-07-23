package ru.bellintegrator.practice.user.model;

import javax.persistence.*;
import java.util.Date;

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
     * Имя документа
     */
    @Column(name = "doc_name", length = 50)
    private String docName;

    /**
     * Номер документа
     */
    @Column(name = "doc_number", length = 50)
    private String docNumber;

    /**
     * Дата документа
     */
    @Column(name = "doc_date")
    private Date docDate;

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

    public User(String firstName, String secondName, String middleName, int position, String phone, String docName, String docNumber, Date docDate, String citizenshipName, int citizenshipCode, boolean isIdentified) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipName = citizenshipName;
        this.citizenshipCode = citizenshipCode;
        this.isIdentified = isIdentified;
    }

    public Long getId() {
        return id;
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

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
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
