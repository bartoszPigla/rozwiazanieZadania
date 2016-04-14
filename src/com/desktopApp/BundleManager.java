package com.desktopApp;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Created by Bartosz Pigla on 02.04.16.
 */
public class BundleManager {
    private static ResourceBundle bundle = ResourceBundle.getBundle("FormLabels");

    public static String getValue(String key){
        return bundle.getString(key);
    }

    public static String getValue(String key, Object... params){
        String  msgValue = bundle.getString(key);
        MessageFormat messageFormat = new MessageFormat(msgValue);
        Object[] args = {params};
        return messageFormat.format(params);
    }
    public static ResourceBundle getBundle(){
        return bundle;
    }
}
