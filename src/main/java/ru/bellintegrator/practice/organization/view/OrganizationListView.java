package ru.bellintegrator.practice.organization.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationListView {

    @ApiModelProperty(hidden = true)
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
