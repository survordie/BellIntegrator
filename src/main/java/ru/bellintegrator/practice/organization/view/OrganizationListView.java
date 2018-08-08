package ru.bellintegrator.practice.organization.view;

public class OrganizationListView {
    public Long id;
    public String inn;
    public boolean isActive;

    @Override
    public String toString() {
        return "OrganizationListView{" +
                "id=" + id +
                ", inn='" + inn + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
