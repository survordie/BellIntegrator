package ru.bellintegrator.practice.doc_type.model;

import ru.bellintegrator.practice.doc.model.Doc;
import ru.bellintegrator.practice.user.model.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doc_type")
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
    @OneToOne(mappedBy = "docCode", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ru.bellintegrator.practice.doc.model.Doc doc;

    /**
     * Имя документа
     */
    @Column(name = "name", length = 50)
    private String name;

    /**
     * Конструктор для hibernate
     */
    public Doc(){

    }

    public Doc(ru.bellintegrator.practice.doc.model.Doc doc, String name) {
        this.doc = doc;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public ru.bellintegrator.practice.doc.model.Doc getDoc() {
        return doc;
    }

    public void setDoc(ru.bellintegrator.practice.doc.model.Doc doc) {
        this.doc = doc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
