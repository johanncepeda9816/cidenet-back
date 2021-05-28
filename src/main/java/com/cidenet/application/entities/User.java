package com.cidenet.application.entities;

import java.io.Serializable;

public class User implements Serializable{

    private String firstName;
    private String firstSurname;
    private String secondSurname;
    private String registrationDate;
    private String modificationDate;
    private String documentType;
    private String documentNumber;
    private String area;
    private String otherName;
    private String country;
    private String email;
    private boolean active;

    public User() {

    }

    public User(String firstName, String firstSurname, String secondSurname, String registrationDate, String modificationDate, String documentType, String documentNumber, String area, String otherName, String country, String email, boolean active) {
        this.firstName = firstName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.registrationDate = registrationDate;
        this.modificationDate = modificationDate;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.area = area;
        this.otherName = otherName;
        this.country = country;
        this.email = email;
        this.active = active;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstSurname() {
        return this.firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return this.secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getModificationDate() {
        return this.modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getDocumentType() {
        return this.documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOtherName() {
        return this.otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public User firstSurname(String firstSurname) {
        setFirstSurname(firstSurname);
        return this;
    }

    public User secondSurname(String secondSurname) {
        setSecondSurname(secondSurname);
        return this;
    }

    public User registrationDate(String registrationDate) {
        setRegistrationDate(registrationDate);
        return this;
    }

    public User modificationDate(String modificationDate) {
        setModificationDate(modificationDate);
        return this;
    }

    public User documentType(String documentType) {
        setDocumentType(documentType);
        return this;
    }

    public User documentNumber(String documentNumber) {
        setDocumentNumber(documentNumber);
        return this;
    }

    public User area(String area) {
        setArea(area);
        return this;
    }

    public User otherName(String otherName) {
        setOtherName(otherName);
        return this;
    }

    public User country(String country) {
        setCountry(country);
        return this;
    }

    public User email(String email) {
        setEmail(email);
        return this;
    }

    public User active(boolean active) {
        setActive(active);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " firstName='" + getFirstName() + "'" +
            ", firstSurname='" + getFirstSurname() + "'" +
            ", secondSurname='" + getSecondSurname() + "'" +
            ", registrationDate='" + getRegistrationDate() + "'" +
            ", modificationDate='" + getModificationDate() + "'" +
            ", documentType='" + getDocumentType() + "'" +
            ", documentNumber='" + getDocumentNumber() + "'" +
            ", area='" + getArea() + "'" +
            ", otherName='" + getOtherName() + "'" +
            ", country='" + getCountry() + "'" +
            ", email='" + getEmail() + "'" +
            ", active='" + getActive() + "'" +
            "}";
    }

}
