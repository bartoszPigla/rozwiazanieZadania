package com.forms;

import com.desktopApp.ErrorMessage;
import com.enums.Navigation;
import com.enums.FormType;

import javax.swing.*;

/**
 * Created by Bartosz Pigla on 02.04.16.
 */
public class FirstNameForm extends WizardForm {
    private JTextField firstNameTextField;
    private JButton goToLastNameButton;
    private JPanel rootPanel;

    public FirstNameForm(){
        super(FormType.firstName);
        setContentPane(rootPanel);
        pack();

        getRootPane().setDefaultButton(goToLastNameButton);

        addButtonActionListener(goToLastNameButton,FormType.lastName, Navigation.next);
    }


    @Override
    public String getErrors() {
        String firstName=firstNameTextField.getText().toString();
        String errors=
            new ErrorMessage(firstName)
                .isText()
                .firstLetterIsUpperCase()
                .isNotLongerThan(40)
                .isNotShorterThan(3)
                .getMessage();
        return errors;
    }

    public void clearFirstNameField(){
        firstNameTextField.setText("");
    }

    public String getFirstName(){
        return firstNameTextField.getText();
    }
}
