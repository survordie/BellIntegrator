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
        return "{id:" + offiseId + " last name:" + secondName + " name:" + firstName + "}";
    }
}
