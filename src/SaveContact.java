import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
import java.io.*;

/**
 * This class contains one method for saving a contact as a .txt file.
 * 
 * Since the email and address fields are optional, they can be left out.
 * 
 * @author Veikka Luukkonen
 */
public class SaveContact {
    /**
     * This method contains operations for the creation of a .txt file.
     * 
     * User needs to have a directory by the name of savedcontacts in the working directory.
     * The .txt file is named after the first and last name of the contact.
     * 
     * @param addrCreate An integer value. 0 if to be left out, 1 if included. (addr text field)
     * @param emailCreate An integer value. 0 if to be left out, 1 if included. (email text field)
     */
    public static void saveContact(int addrCreate, int emailCreate) {
        boolean createAddr = false;
        boolean createEmail = false;
        if (addrCreate == 1) {
            createAddr = true;
        }
        if (emailCreate == 1) {
            createEmail = true;
        }
        String fnameFile = CreateWindow.fname.getText().trim().toLowerCase();
        String lnameFile = CreateWindow.lname.getText().trim().toLowerCase();

        // get directory where files will be saved
        String fileDirectory = System.getProperty("user.dir");
        fileDirectory += "\\savedcontacts\\" + fnameFile + lnameFile + ".txt";

        boolean fileNotExists = true;

        try {
            File contactFile = new File(fileDirectory);
            if (contactFile.createNewFile()) {
                System.out.println("File created: " + contactFile.getName());
            } else {
                System.out.println("File already exists.");
                fileNotExists = false;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String ls = System.getProperty("line.separator");
        String finalId = CreateWindow.id.getText();
        String finalFname = CreateWindow.fname.getText();
        String finalLname = CreateWindow.lname.getText();
        String finalPhnum = CreateWindow.phnum.getText();
        String finalAddr = CreateWindow.addr.getText();
        String finalEmail = CreateWindow.email.getText();

        if (fileNotExists) {
            try {
                FileWriter myWriter = new FileWriter(fileDirectory);
                myWriter.write("Id: " + finalId + ls);
                myWriter.write("First name: " + finalFname + ls);
                myWriter.write("Last name: " + finalLname + ls);
                myWriter.write("Phone number: " + finalPhnum + ls);
                if (createAddr) {
                    myWriter.write("Address: " + finalAddr + ls);
                }
                if (createEmail) {
                    myWriter.write("Email: " + finalEmail + ls);
                }
                myWriter.close();
                System.out.println("Contact info added to file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
}