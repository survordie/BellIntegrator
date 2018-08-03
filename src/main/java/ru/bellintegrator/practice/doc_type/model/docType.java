package ru.bellintegrator.practice.doc_type.model;

import ru.bellintegrator.practice.doc.model.Doc;
import ru.bellintegrator.practice.user.model.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doc_type")
public class DocType {

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
    @OneToOne(mappedBy = "docCode", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Doc doc;

    /**
     * Имя документа
     */
    @Column(name = "name", length = 50)
    private String name;

    /**
     * Конструктор для hibernate
     */
    public DocType(){

    }

    public DocType(Doc doc, String name) {
        this.doc = doc;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
