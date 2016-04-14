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
public class AddressForm extends WizardForm {
    private JPanel rootPanel;
    private JTextField addressTextField;
    private JButton goToLastNameButton;
    private JButton goToPhoneNumberButton;
    private JPanel buttonPanel;

    public AddressForm(){
        super(FormType.address);
        setContentPane(rootPanel);
        pack();

        getRootPane().setDefaultButton(goToPhoneNumberButton);

        addButtonActionListener(goToLastNameButton,FormType.lastName, Navigation.previous);
        addButtonActionListener(goToPhoneNumberButton,FormType.phoneNumber,Navigation.next);
    }
    @Override
    public String getErrors() {
        String address=addressTextField.getText().toString();

        String error=
            new ErrorMessage(address)
                .isNotLongerThan(100)
                .isNotShorterThan(5)
                .getMessage();

        return error;
    }

    public String getAddress(){
        return addressTextField.getText();
    }

    public void clearAddressField() {
        addressTextField.setText("");
    }
}
