package ru.bellintegrator.practice.user.view;

public class UserListView {

    public Long officeId;
    public String firstName;
    public String secondName;
    public String middleName;
    public int position;
    public String docCode;
    public String citizenshipCode;  //Код страны

    @Override
    public String toString() {
        return "UserListView{" +
                "offiseId=" + officeId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position=" + position +
                ", docCode=" + docCode +
                ", citizenshipCode=" + citizenshipCode +
                '}';
    }
}
