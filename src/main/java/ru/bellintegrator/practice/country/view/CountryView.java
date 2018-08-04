package ru.bellintegrator.practice.country.view;

public class CountryView {

    public Long id;
    public String code;
    public String name;

    @Override
    public String toString() {
        return "CountryView{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
