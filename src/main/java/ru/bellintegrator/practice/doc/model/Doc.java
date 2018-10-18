package ru.bellintegrator.practice.doc.model;

import ru.bellintegrator.practice.doc_type.model.DocType;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Doc")
public class Doc {
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
     * Код типа документа
     */
    @ManyToOne
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
    public Doc() {

    }

    public Doc(DocType docCode, String docNumber, Date docDate) {
        this.docCode = docCode;
        this.docNumber = docNumber;
        this.docDate = docDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Doc{" +
                "id=" + id +
                ", docNumber='" + docNumber + '\'' +
                ", docDate=" + docDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doc doc = (Doc) o;
        return Objects.equals(getDocCode(), doc.getDocCode()) &&
                Objects.equals(getDocNumber(), doc.getDocNumber()) &&
                Objects.equals(getDocDate(), doc.getDocDate());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDocCode(), getDocNumber(), getDocDate());
    }
}
