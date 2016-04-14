package com.desktopApp;

import com.enums.FormType;
import com.forms.*;

import javax.swing.*;

/**
 * Created by Bartosz Pigla on 02.04.16.
 */
public class FormManager {
    private static FirstNameForm firstNameForm;
    private static LastNameForm lastNameForm;
    private static AddressForm addressForm;
    private static PhoneNumberForm phoneNumberForm;
    private static SummaryForm summaryForm;

    public static JFrame getFormInstance(FormType formType){
        switch(formType){
            case firstName:
                return getFirstNameFormInstance();
            case lastName:
                return getLastNameFormInstance();
            case address:
                return getAddressFormInstance();
            case phoneNumber:
                return getPhoneNumberInstance();
            case summary:
                return getSummaryFormInstance();
            default:
                return null;

        }
    }

    public static FirstNameForm getFirstNameFormInstance(){
        if(firstNameForm==null){
            firstNameForm=new FirstNameForm();
        }
        return firstNameForm;
    }

    public static LastNameForm getLastNameFormInstance(){
        if(lastNameForm==null){
            lastNameForm=new LastNameForm();
        }
        return lastNameForm;
    }

    public static AddressForm getAddressFormInstance(){
        if(addressForm==null){
            addressForm=new AddressForm();
        }
        return addressForm;
    }

    public static PhoneNumberForm getPhoneNumberInstance(){
        if(phoneNumberForm ==null){
            phoneNumberForm =new PhoneNumberForm();
        }
        return phoneNumberForm;
    }

    public static SummaryForm getSummaryFormInstance(){
        if(summaryForm==null){
            summaryForm=new SummaryForm();
        }
        return summaryForm;
    }

    public static void deleteInsertedData(){
        if(firstNameForm!=null)
            firstNameForm.clearFirstNameField();
        if(lastNameForm!=null)
            lastNameForm.clearLastNameField();
        if(addressForm!=null)
            addressForm.clearAddressField();
        if(phoneNumberForm !=null)
            phoneNumberForm.clearPhoneNumberField();
        if(summaryForm!=null)
            summaryForm.clearUserData();
    }
}
