package ru.bellintegrator.practice.user.view;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserView {

    public Long id;
    public String firstName;
    public String secondName;
    public String middleName;
    public String position;
    public Long officeId;
    public String docCode;
    public String docName;
    public String docNumber;
    public Date docDate;
    public String phone;
    public String citizenshipName;  //Имя страны
    public String citizenshipCode;  //Код страны
    public boolean isIdentified;

    @Override
    public String toString() {
        return "UserView{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", officeId=" + officeId +
                ", docCode='" + docCode + '\'' +
                ", docName='" + docName + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", docDate=" + docDate +
                ", phone='" + phone + '\'' +
                ", citizenshipName='" + citizenshipName + '\'' +
                ", citizenshipCode='" + citizenshipCode + '\'' +
                ", isIdentified=" + isIdentified +
                '}';
    }
}
