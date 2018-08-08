package ru.bellintegrator.practice.doc_type.model;

import javax.persistence.*;

@Entity
@Table(name = "Doc_Type")
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
    @Column(name = "code")
    private String code;

    /**
     * Имя документа
     */
    @Column(name = "name", length = 50)
    private String name;

    /**
     * Конструктор для hibernate
     */
    public DocType() {

    }

    public DocType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
