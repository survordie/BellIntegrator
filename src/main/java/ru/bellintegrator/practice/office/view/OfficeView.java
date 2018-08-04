package ru.bellintegrator.practice.office.view;

public class OfficeView {

    public Long id;
    public Long organizationId;
    public String name;
    public String address;
    public String phone;
    public boolean isActive;

    @Override
    public String toString() {
        return "OfficeView{" +
                "id=" + id +
                ", organizationId=" + organizationId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
