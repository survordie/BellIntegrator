package ru.bellintegrator.practice.doc_type.view;

import io.swagger.annotations.ApiModelProperty;

public class DocTypeView {

    @ApiModelProperty(hidden = true)
    public Long id;
    public String code;
    public String name;

    @Override
    public String toString() {
        return "DocTypeView{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
