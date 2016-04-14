package com.forms;

import com.desktopApp.FormManager;
import com.enums.Navigation;
import com.enums.FormType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by Bartosz Pigla on 02.04.16.
 */
public class SummaryForm  extends WizardForm{
    private JPanel rootPanel;
    private JButton goToPhoneNumberButton;
    private JButton addNewUserButton;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel addressLabel;
    private JLabel phoneNumberLabel;

    public SummaryForm(){
        super(FormType.summary);

        setContentPane(rootPanel);

        pack();

        getRootPane().setDefaultButton(addNewUserButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                setUserData();
            }
        });

        addButtonActionListener(goToPhoneNumberButton,FormType.phoneNumber, Navigation.previous);

        addNewUserButton.addActionListener((ActionEvent e)->{
            FormManager.deleteInsertedData();
            JFrame form = FormManager.getFormInstance(FormType.firstName);

            setVisible(false);
            form.setVisible(true);
        });
    }

    public void setUserData(){
        firstNameLabel.setText(FormManager.getFirstNameFormInstance().getFirstName());
        lastNameLabel.setText(FormManager.getLastNameFormInstance().getLastName());
        addressLabel.setText(FormManager.getAddressFormInstance().getAddress());
        phoneNumberLabel.setText(FormManager.getPhoneNumberInstance().getPhoneNumber());
    }

    @Override
    public String getErrors() {
        return null;
    }

    public void clearUserData() {
        firstNameLabel.setText("");
        lastNameLabel.setText("");
        addressLabel.setText("");
        phoneNumberLabel.setText("");
    }
}
