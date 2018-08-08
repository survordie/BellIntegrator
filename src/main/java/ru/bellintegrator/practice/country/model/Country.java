package ru.bellintegrator.practice.country.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Country")
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
    @NotNull
    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Код страны
     */
    @NotNull
    @NotEmpty
    @Column(name = "code", nullable = false)
    private String code;

    /**
     * Конструктор для hibernate
     */
    public Country() {

    }

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Long getId() {
        return id;
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
