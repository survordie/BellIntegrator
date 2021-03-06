package ru.bellintegrator.practice.office.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfficeView {

    @ApiModelProperty(hidden = true)
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
