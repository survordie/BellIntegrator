package ru.bellintegrator.practice.office.model.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Office {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
}
