package ru.bellintegrator.practice.user.view;

public class UserView {

    public Long id;
    public String firstName;
    public String secondName;
    public String middleName;
    public int position;
    public Long officeId;
    public String docTypeId;
    public String docId;
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
                ", position=" + position +
                ", officeId=" + officeId +
                ", docTypeId=" + docTypeId +
                ", docId=" + docId +
                ", phone='" + phone + '\'' +
                ", citizenshipName='" + citizenshipName + '\'' +
                ", citizenshipCode=" + citizenshipCode +
                ", isIdentified=" + isIdentified +
                '}';
    }
}
