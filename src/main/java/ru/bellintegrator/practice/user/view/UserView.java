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
        return "{id:" + id + " last name:" + secondName + " name:" + firstName + "}";
    }

}
