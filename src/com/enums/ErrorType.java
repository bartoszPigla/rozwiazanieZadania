package com.enums;

/**
 * Created by Bartosz Pigla on 02.04.16.
 */
public enum ErrorType {
    isEmpty("isEmptyError"),

    firstLetterLowerCase("firstLetterLowerCaseError"),

    isNotText("isNotTextError"),

    isNotNumber("isNotNumberError"),

    isTooLong("isTooLongError"),

    isTooShort("isTooShortError");

    private String errorLabel;

    ErrorType(String errorLabel){
        this.errorLabel =errorLabel;
    }

    @Override
    public String toString() {
        return errorLabel;
    }
}
