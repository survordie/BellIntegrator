package ru.bellintegrator.practice.doc_type.view;

public class DocTypeView {

    public Long id;
    public String code;
    public String name;

    @Override
    public String toString() {
        return "DocTypeView{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
