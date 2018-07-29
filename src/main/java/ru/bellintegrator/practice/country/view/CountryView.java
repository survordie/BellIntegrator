package ru.bellintegrator.practice.country.view;

public class CountryView {

    public String code;
    public String name;

    @Override
    public String toString() {
        return "{ code: " + code + " name: " + name + "}";
    }
}
