import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
import java.io.*;

/**
 * This class contains one method for deleting a .txt file.
 * 
 * @author Veikka Luukkonen
 */
public class DeleteContact {
    /**
     * This method searches for a file using the fname and lname text fields, then deletes it.
     * 
     * Since the Contact .txt files are named after the person they are made of, the user can
     * search for the file by re-inputting the first and last name of the person.
     */
    public static void deleteContact() {
        String fnameDelete = CreateWindow.fname.getText().trim().toLowerCase();
        String lnameDelete = CreateWindow.lname.getText().trim().toLowerCase();

        String delDirectory = System.getProperty("user.dir");
        delDirectory += "\\savedcontacts\\" + fnameDelete + lnameDelete + ".txt";
        File deleteFile = new File(delDirectory);
        if (deleteFile.delete()) {
            System.out.println("File deleted: " 
            + fnameDelete + lnameDelete + ".txt");
        } else {
            System.out.println("No such file: "
            + fnameDelete + lnameDelete + ".txt");
        }
    }
}