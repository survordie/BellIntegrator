package ru.bellintegrator.practice.country.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryView {

    @ApiModelProperty(hidden = true)
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
