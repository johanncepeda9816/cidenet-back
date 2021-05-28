package com.cidenet.application.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
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

    @Column(name = "firstName", nullable = false)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "firstSurname", nullable = false)
    public String getFirstSurname() {
        return this.firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    @Column(name = "secondSurname", nullable = false)
    public String getSecondSurname() {
        return this.secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }
    @Column(name = "registrationDate", nullable = false)
    public String getRegistrationDate() {
        return this.registrationDate;
    }
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Column(name = "modificationDate", nullable = false)
    public String getModificationDate() {
        return this.modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Column(name = "documentType", nullable = false)
    public String getDocumentType() {
        return this.documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @Id
    @Column(name = "documentNumber", nullable = false)
    public String getDocumentNumber() {
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Column(name = "area", nullable = false)
    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "otherName", nullable = false)
    public String getOtherName() {
        return this.otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    @Column(name = "country", nullable = false)
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name = "active", nullable = false)
    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
