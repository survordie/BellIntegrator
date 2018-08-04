package ru.bellintegrator.practice.user.view;

public class UserListView {
    public Long offiseId;
    public String firstName;
    public String secondName;
    public String middleName;
    public int position;
    public int docCode;
    public int citizenshipCode;

    @Override
    public String toString() {
        return "UserListView{" +
                "offiseId=" + offiseId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position=" + position +
                ", docCode=" + docCode +
                ", citizenshipCode=" + citizenshipCode +
                '}';
    }
}
