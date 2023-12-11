import javax.swing.*;
import java.awt.event.*;
import java.lang.*;

/**
 * This class contains methods for validation of user input into the text fields.
 * 
 * Methods may be called independetly for validation of spesific text fields.
 * 
 * @author Veikka Luukkonen
 */
public class Validate {
    /**
     * Method used for validating all of the apps text fields at once.
     * 
     * This method calls all other methods in the Validate-class, and then
     * calls the saveContact method of the SaveContact-class to create a .txt document.
     */
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
    /**
     * Method used for validating the id text field.
     * 
     * This method checks that the ID contains:
     * 6 digits for the date of birth,
     * A valid century marker,
     * And 3 digits as the personal identification number.
     * 
     * @return Returns a boolean value, true if valid, else false.
     */
    public static boolean validateID() {
        String idText = CreateWindow.id.getText().trim().toLowerCase();
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
        for (int j = 7; j < 10; j++) {
            if (!Character.isDigit(idText.charAt(j))) {
                System.out.println("The ID does not have a valid identification number.");
                return false;
            }
        }
        char centMark = idText.charAt(6);
        if (centMark == 'a' || centMark == '-' || centMark == '+') {
            return true;
        } else {
            System.out.println("The century marker of the ID is not valid.");
            return false;
        }
    }
    /**
     * Method for validation of the fname and lname text fields.
     * 
     * fname must be between 3 and 10 characters,
     * lname must be between 4 and 12 characters.
     * 
     * @return Returns a boolean value, true if valid, else false.
     */
    public static boolean validateNames() {
        String fnameText = CreateWindow.fname.getText().trim();
        String lnameText = CreateWindow.lname.getText().trim();

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
    /**
     * Method for validation of the phnum text field.
     * 
     * removes the '+' character from the front of the phone number for
     * the duration of the validation, if it is there.
     * 
     * phnum must be between 7 and 13 characters long.
     * Checks that all characters are digits.
     * 
     * @return Returns a boolean value. True if valid, else false.
     */
    public static boolean validatePhnum() {
        String phnumText = CreateWindow.phnum.getText().trim();
        if (phnumText.charAt(0) == '+') {
            String tempStr = phnumText.replace("+", "");
            phnumText = tempStr;
        }
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
    /**
     * Method for the validation of the addr text field.
     * 
     * Addr must be between 9 and 29 characters long or 0 characters long.
     * 
     * @return Returns an integer value. 0 if length is 0, 1 if valid, 2 if not valid.
     */
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
    /**
     * Method for the validation of the email text field.
     * 
     * Email must be between 4 and 29 characters long or 0 characters long,
     * Email must contain the '@' and '.' characters.
     * 
     * @return Returns an integer value. 0 if length is 0, 1 if valid, 2 if not valid.
     */
    public static int validateEmail() {
        String emailText = CreateWindow.email.getText().trim();
        if (emailText.length() == 0) { // email empty
            return 0;
        } else {
            if (emailText.length() < 4 || emailText.length() > 30) { // length < 4
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
