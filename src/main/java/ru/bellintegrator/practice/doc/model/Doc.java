package ru.bellintegrator.practice.doc.model;

import ru.bellintegrator.practice.user.model.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "doc")
public class Doc {
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
     * Код документа
     */
    @Column(name = "doc_code", length = 50)
    private String docCode;

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
     * Конструктор для hibernate
     */
    public Doc(){

    }

    public Doc(String docCode, String docName, String docNumber, Date docDate) {
        this.docCode = docCode;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
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
}
