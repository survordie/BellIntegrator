package ru.bellintegrator.practice.organization.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationView {

    @ApiModelProperty(hidden = true)
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
    public String toString() {
        return "OrganizationView{" +
                "id=" + id +
                ", countryId='" + countryId + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
