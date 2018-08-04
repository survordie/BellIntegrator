package ru.bellintegrator.practice.user.view;

public class UserView {

    public Long id;
    public String firstName;
    public String secondName;
    public String middleName;
    public int position;
    public int officeId;
    public int docTypeId;
    public int docId;
    public String phone;
    public String citizenshipName;
    public int citizenshipCode;
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
