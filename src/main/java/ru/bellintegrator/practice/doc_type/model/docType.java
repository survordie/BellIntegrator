package ru.bellintegrator.practice.doc_type.model;

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
    @Column(name = "code", length = 50)
    private String code;

    /**
     * Имя документа
     */
    @Column(name = "name", length = 50)
    private String name;

    /**
     * Список пользователей
     */
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users;

    /**
     * Конструктор для hibernate
     */
    public DocType(){

    }

    public DocType(String code, String name) {
        this.code = code;
        this.name = name;
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

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        getUsers().add(user);
        user.setDocTypeId(this);
    }

    public void removeUser(User user){
        getUsers().remove(user);
        user.setDocTypeId(null);
    }
}
