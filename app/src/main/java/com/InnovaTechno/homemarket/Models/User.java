package com.InnovaTechno.homemarket.Models;

import com.parse.ParseACL;
import com.parse.ParseClassName;
import com.parse.ParseUser;

@ParseClassName("User")
public class User extends ParseUser {

    public static final String KEY_USERNAME = "username";
    public static final String KEY_FULLNAME = "fullname";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_ALTERNATIVECONTACT = "alternativecontact";

    public static final String KEY_PASSWORD = "password";



    public String getAddress() {
        return getString(KEY_ADDRESS);
    }

    public void setAddress(String address) {
        put(KEY_ADDRESS, address);
    }

    public String getPhone() {
        return getString(KEY_PHONE);
    }

    public void setPhone(String phone) {
        put(KEY_PHONE, phone);
    }

    public String getAlternativecontact() {
        return getString(KEY_ALTERNATIVECONTACT);
    }

    public void setAlternativecontact(String alternativecontact) {
        put(KEY_ALTERNATIVECONTACT, alternativecontact);
    }

    public String getFullName() {
        return getString(KEY_FULLNAME);
    }

    public void setFullName(String fullname) {
        put(KEY_FULLNAME, fullname);
    }

    public String getUsername() {
        return getString(KEY_USERNAME);
    }

    public void setUsername(String username) {
        put(KEY_USERNAME, username);
    }

    public String getEmail() {
        return getString(KEY_EMAIL);
    }

    public void setEmail(String email) {
        put(KEY_EMAIL, email);
    }

    public String getPassword() {
        return getString(KEY_PASSWORD);
    }

    public void setPassword(String password) {
        put(KEY_PASSWORD, password);
    }
}
