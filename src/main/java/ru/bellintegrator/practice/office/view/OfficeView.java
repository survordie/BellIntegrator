package ru.bellintegrator.practice.office.view;

public class OfficeView {

    public Long id;
    public String name;
    public String address;
    public String phone;
    public boolean isActive;

    @Override
    public String toString(){
        return "{id: " + id + " name: " + name + " is Active: " + isActive + "}";
    }
}
