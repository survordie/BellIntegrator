package ru.bellintegrator.practice.doc_type.view;

public class DocTypeView {

    public String code;
    public String name;

    @Override
    public String toString() {
        return "{ code: " + code + " name: " + name + "}";
    }
}
