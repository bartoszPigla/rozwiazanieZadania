package com.enums;

/**
 * Created by Bartosz Pigla on 02.04.16.
 */
public enum FormType {
    firstName("firstNameLabel"),
    lastName("lastNameLabel"),
    address("addressLabel"),
    phoneNumber("phoneNumberLabel"),
    summary("summaryLabel");

    private String formNameLabel;
    FormType(String formNameLabel){
        this.formNameLabel =formNameLabel;
    }

    @Override
    public String toString() {
        return formNameLabel;
    }
}
