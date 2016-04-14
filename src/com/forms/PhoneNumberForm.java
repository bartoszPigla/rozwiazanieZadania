package com.forms;

import com.desktopApp.ErrorMessage;
import com.enums.Navigation;
import com.enums.ErrorType;
import com.enums.FormType;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartosz Pigla on 02.04.16.
 */
public class PhoneNumberForm extends WizardForm {
    private JPanel rootPanel;
    private JTextField phoneNumberTextField;
    private JButton goToAddressButton;
    private JButton goToSummaryButton;

    public PhoneNumberForm(){
        super(FormType.phoneNumber);
        setContentPane(rootPanel);
        pack();

        getRootPane().setDefaultButton(goToSummaryButton);

        addButtonActionListener(goToAddressButton,FormType.address, Navigation.previous);
        addButtonActionListener(goToSummaryButton,FormType.summary,Navigation.next);
    }

    @Override
    public String getErrors() {
        String phoneNumber=phoneNumberTextField.getText().toString();

        String error=
            new ErrorMessage(phoneNumber)
                .isNumber()
                .isNotShorterThan(9)
                .isNotLongerThan(12)
                .getMessage();

        return error;
    }

    public String getPhoneNumber(){
        return phoneNumberTextField.getText();
    }

    public void clearPhoneNumberField() {
        phoneNumberTextField.setText("");
    }
}
