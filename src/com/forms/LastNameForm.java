package com.forms;

import com.desktopApp.ErrorMessage;
import com.enums.Navigation;
import com.enums.FormType;

import javax.swing.*;

/**
 * Created by Bartosz Pigla on 02.04.16.
 */
public class LastNameForm extends WizardForm {
    private JPanel rootPanel;
    private JTextField lastNameTextField;
    private JButton goToFirstNameButton;
    private JButton goToAddressButton;
    private JPanel buttonPanel;

    public LastNameForm(){
        super(FormType.lastName);
        setContentPane(rootPanel);
        pack();

        getRootPane().setDefaultButton(goToAddressButton);

        addButtonActionListener(goToFirstNameButton,FormType.firstName, Navigation.previous);
        addButtonActionListener(goToAddressButton,FormType.address,Navigation.next);
    }

    @Override
    public String getErrors() {
        String lastName=lastNameTextField.getText().toString();

        String error=
                new ErrorMessage(lastName)
                        .isText()
                        .isNotLongerThan(100)
                        .isNotShorterThan(5)
                        .getMessage();

        return error;
    }

    public void clearLastNameField(){
        lastNameTextField.setText("");
    }

    public String getLastName(){
        return lastNameTextField.getText();
    }
}
