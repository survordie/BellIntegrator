package ru.bellintegrator.practice.doc.model;

import ru.bellintegrator.practice.doc_type.model.DocType;
import ru.bellintegrator.practice.user.model.User;

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
    @OneToOne
    @JoinColumn(name = "doc_type_id")
    private DocType docCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

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

    public Doc(DocType docCode, User userId, String docNumber, Date docDate) {
        this.docCode = docCode;
        this.userId = userId;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        return Objects.equals(docCode, doc.docCode) &&
                Objects.equals(userId, doc.userId) &&
                Objects.equals(docNumber, doc.docNumber) &&
                Objects.equals(docDate, doc.docDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(docCode, userId, docNumber, docDate);
    }
}
