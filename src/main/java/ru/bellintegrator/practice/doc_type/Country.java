package ru.bellintegrator.practice.doc_type;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Наименование страны
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Код страны
     */
    @Column(name = "code", nullable = false)
    private String code;

    /**
     * Конструктор для hibernate
     */
    public Country(){

    }

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
