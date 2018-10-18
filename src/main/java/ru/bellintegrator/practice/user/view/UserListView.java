package ru.bellintegrator.practice.user.view;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserListView {

    public Long id;
    public Long officeId;
    public String firstName;
    public String secondName;
    public String middleName;
    public String position;
    public String docCode;
    public String citizenshipCode;  //Код страны

    @Override
    public String toString() {
        return "UserListView{" +
                "id=" + id +
                ", officeId=" + officeId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position=" + position +
                ", docCode='" + docCode + '\'' +
                ", citizenshipCode='" + citizenshipCode + '\'' +
                '}';
    }
}
