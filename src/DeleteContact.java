import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
import java.io.*;

public class DeleteContact {
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