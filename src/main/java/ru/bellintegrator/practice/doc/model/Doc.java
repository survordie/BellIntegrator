package ru.bellintegrator.practice.doc.model;

import ru.bellintegrator.practice.doc_type.model.DocType;
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
     * Код типа документа
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_type_id")
    private DocType docCode;

    /**
     * Номер документа
     */
    @Column(name = "doc_number")
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

    public Doc(DocType docCode, String docNumber, Date docDate) {
        this.docCode = docCode;
        this.docNumber = docNumber;
        this.docDate = docDate;
    }

    public Long getId() {
        return id;
    }

    public DocType getDocCode() {
        return docCode;
    }

    public void setDocCode(DocType docCode) {
        this.docCode = docCode;
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
