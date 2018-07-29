package ru.bellintegrator.practice.organization.view;

public class OrganizationView {
    public Long id;
    public String countryId;
    public String name;
    public String fullName;
    public String inn;
    public String kpp;
    public String address;
    public String phone;
    public boolean isActive;

    @Override
    public String toString(){
        return "{id:" + id + " name:" + name + " country Id:" + countryId + "}";
    }
}
