package com.forms;

import com.desktopApp.BundleManager;
import com.desktopApp.FormManager;
import com.enums.FormType;
import com.enums.Navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Bartosz Pigla on 02.04.16.
 */
public abstract class WizardForm extends JFrame {
    protected WizardForm(FormType formType){
        super(BundleManager.getValue(formType.toString()));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setPosition(this);
    }

    public void addButtonActionListener(JButton button, FormType formType, Navigation navigation){
        button.addActionListener((ActionEvent e)->{
            if(navigation==navigation.previous){
                switchWindow(formType);
            }
            else{
                String errors=getErrors();
                if(errors==null||errors.equals("")){
                    switchWindow(formType);
                }
                else{
                    JOptionPane.showMessageDialog(new JFrame(), errors, BundleManager.getValue("errorLabel"),
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void switchWindow(FormType formType){
        JFrame form = FormManager.getFormInstance(formType);
        setVisible(false);
        form.setVisible(true);
    }

    public static void setPosition(JFrame form){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        form.setLocation(screenWidth / 4, screenHeight / 4);
    }

    public abstract String getErrors();
}
