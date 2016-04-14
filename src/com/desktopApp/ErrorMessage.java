package com.desktopApp;

import com.enums.ErrorType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartosz Pigla on 03.04.16.
 */
public class ErrorMessage {
    private String string;

    /*
    private String
            isEmptyMessage,
            firstLetterLowerCaseMessage,
            isNotTextMessage,
            isNotNumberMessage,
            isTooLongMessage,
            isTooShortMessage;
            */

    private List<String> errorList=new ArrayList<>();
    private boolean isEmpty;
    private String emptyMessage;

    public ErrorMessage(String string){
        this.string=string;
        isEmpty=string==null||string.equals("");
        if(isEmpty)
            emptyMessage=BundleManager.getValue(ErrorType.isEmpty.toString());
    }

    public ErrorMessage isNotLongerThan(int max){
        if(!isEmpty &&  string.length() > max)
            errorList.add(BundleManager.getValue(ErrorType.isTooLong.toString(),max));
        return this;
    }

    public ErrorMessage isNotShorterThan(int min){
        if(!isEmpty &&  string.length() < min)
            errorList.add(BundleManager.getValue(ErrorType.isTooShort.toString(),min));
        return this;
    }

    public ErrorMessage isText(){
        if(!isEmpty && !string.chars().allMatch(x -> Character.isLetter(x)))
            errorList.add(BundleManager.getValue(ErrorType.isNotText.toString()));
        return this;
    }

    public ErrorMessage isNumber(){
        if(!isEmpty){
            try {
                Long.parseLong(string);
            } catch (NumberFormatException exc) {
                errorList.add(BundleManager.getValue(ErrorType.isNotNumber.toString()));
            }
        }
        return this;
    }

    public ErrorMessage firstLetterIsUpperCase(){
        if(!isEmpty && !Character.isUpperCase(string.charAt(0)))
            errorList.add(BundleManager.getValue(ErrorType.firstLetterLowerCase.toString()));
        return this;
    }

    public String getMessage() {
        if(isEmpty)
            return emptyMessage;
        else{
            StringBuilder stringBuilder = new StringBuilder("");
            for (String error : errorList) {
                if (error != null)
                    stringBuilder.append(error + "\n");
            }
            String errors = stringBuilder.toString();
            if (!errors.equals("")) {
                int index = errors.lastIndexOf('\n');
                errors = errors.substring(0, index);
                return errors;
            } else {
                return "";
            }
        }
    }
}
