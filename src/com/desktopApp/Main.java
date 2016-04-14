package com.desktopApp;

import com.enums.FormType;
import com.forms.FirstNameForm;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            FirstNameForm firstNameForm = FormManager.getFirstNameFormInstance();
            firstNameForm.setVisible(true);
        });
    }
}
