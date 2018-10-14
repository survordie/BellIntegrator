package ru.bellintegrator.practice.organization.view;

public class OrganizationListView {
    public Long id;
    public String name;
    public String inn;
    public boolean isActive;

    @Override
    public String toString() {
        return "OrganizationListView{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inn='" + inn + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
