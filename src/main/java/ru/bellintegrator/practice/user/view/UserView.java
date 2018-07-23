package ru.bellintegrator.practice.user.view;

import java.util.Date;

public class UserView {

    public Long id;
    public String firstName;
    public String secondName;
    public String middleName;
    public int position;
    public String phone;
    public String citizenshipName;
    public int citizenshipCode;
    public boolean isIdentified;

    @Override
    public String toString(){
        return "{id:" + id + "last name:" + secondName + "name:" + firstName + "}";
    }

}
