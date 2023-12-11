import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
import java.io.*;

/**
 * This class contains one method for the updaing of a .txt file.
 * 
 * Deletes previous file and creates a new one by the same name.
 * 
 * @author Veikka Luukkonen
 */
public class UpdateContact {
    /**
     * This method is responsible for updating a .txt file.
     * 
     * Calls methods from the DeleteContact and SaveContact classes to re-create a .txt file.
     */
    public static void updateContact() {
        boolean validIdUpdate = Validate.validateID();
        boolean validNamesUpdate = Validate.validateNames();
        boolean validPhnumUpdate = Validate.validatePhnum();
        int addrStatusUpdate = Validate.validateAddr();
        int emailStatusUpdate = Validate.validateEmail();

        if (addrStatusUpdate == 0 || addrStatusUpdate == 1 && emailStatusUpdate == 0 || emailStatusUpdate == 1) {
            if (validIdUpdate && validNamesUpdate && validPhnumUpdate) {
                DeleteContact.deleteContact();
                SaveContact.saveContact(addrStatusUpdate, emailStatusUpdate);
            }
        }
    }
}