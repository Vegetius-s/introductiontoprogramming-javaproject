import javax.swing.*;
import java.awt.event.*;
import java.lang.*;

class Validate {
    // Perform all validation and if valid, save contact
    public static void validateRows() {
        boolean validId = validateID();
        boolean validNames = validateNames();
        boolean validPhnum = validatePhnum();
        int addrStatus = validateAddr();
        int emailStatus = validateEmail();

        if (addrStatus == 0 || addrStatus == 1 && emailStatus == 0 || emailStatus == 1) {
            if (validId && validNames && validPhnum) {
                // int parameters tell the function if addr or email is empty
                SaveContact.saveContact(addrStatus, emailStatus);
            }
        }
    }
    public static boolean validateID() {
        String idText = CreateWindow.id.getText();
        if (idText.length() != 11) { // id is not 11 chars
            System.out.println("Id number is not the correct length.");
            return false;
        }
        for (int i = 0; i < 6; i++) {
            if (!Character.isDigit(idText.charAt(i))) {
                System.out.println("The id number does not have a valid date.");
                return false;
            }
        }
        return true;
    }
    public static boolean validateNames() {
        String fnameText = CreateWindow.fname.getText();
        String lnameText = CreateWindow.lname.getText();

        if (fnameText.length() <= 3 || fnameText.length() >= 10) { // 3 <= length >= 10
            System.out.println("First name is not a valid length.");
            return false;
        }
        if (lnameText.length() <= 4 || lnameText.length() >= 12) { // 4 <= length >= 12
            System.out.println("Last name is not a valid length.");
            return false;
        }
        return true;
    }
    public static boolean validatePhnum() {
        String phnumText = CreateWindow.phnum.getText();

        if (phnumText.length() <= 7 || phnumText.length() >= 13) { // 7 <= length >= 13
            System.out.println("The phone number is not a valid length.");
            return false;
        }
        // Loop through phone number and return false if not only digits
        for (int i = 0; i < phnumText.length(); i++) {
            if (!Character.isDigit(phnumText.charAt(i))) {
                System.out.println("The phone number has to only have digits.");
                return false;
            }
        }
        return true;
    }
    public static int validateAddr() {
        String addrText = CreateWindow.addr.getText();
        if (addrText.length() == 0) { // Addr empty
            return 0;
        } else {
            if (addrText.length() > 30 || addrText.length() < 10) { // 30 > length < 10
                System.out.println("The address is not a valid length.");
                return 2;
            }
            return 1;
        }
    }
    public static int validateEmail() {
        String emailText = CreateWindow.email.getText();
        if (emailText.length() == 0) { // email empty
            return 0;
        } else {
            if (emailText.length() < 4) { // length < 4
                return 2;
            }
            // email needs to contain @ and . symbols
            boolean isAt = emailText.contains("@");
            boolean isDot = emailText.contains(".");

            if (isAt) {
                if (isDot) {
                    return 1;
                } else {
                    System.out.println("Email does not contain the '.' character.");
                }
            } else {
                System.out.println("Email does not contain the '@' character.");
            }
            return 2;
        }
    }
}
