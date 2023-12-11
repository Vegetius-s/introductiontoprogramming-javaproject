import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
import java.io.*;

public class UpdateContact {
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