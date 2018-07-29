package ru.bellintegrator.practice.organization.view;

public class OrganizationListView {
    public Long id;
    public String name;
    public String inn;
    public boolean isActive;

    @Override
    public String toString(){
        return "{id:" + id + " name:" + name + "}";
    }
}
