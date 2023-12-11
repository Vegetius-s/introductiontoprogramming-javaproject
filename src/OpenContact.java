import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.io.*;

/**
 * This class contains a method to open a .txt file in the savedcontacts directory.
 * 
 * @author Veikka Luukkonen
 */
public class OpenContact {
    /**
     * This method contains the operations to open a .txt file.
     * 
     * Mainly calls methods from the java.awt.* import.
     * If the file does not existin the savedcontacts directory, then stops.
     */
    public static void openContact() {
        String fnameOpen = CreateWindow.fname.getText().trim().toLowerCase();
        String lnameOpen = CreateWindow.lname.getText().trim().toLowerCase();
        String openDirectory = System.getProperty("user.dir");
        openDirectory += "\\savedcontacts\\" + fnameOpen + lnameOpen + ".txt";
        
        try {  
            File openFile = new File(openDirectory);
            if (!Desktop.isDesktopSupported()) {  
                System.out.println("Your computer does not support opening text files.");  
                return;
            }
            Desktop desktop = Desktop.getDesktop();  
            if(openFile.exists())  
            desktop.open(openFile); 
        } catch(Exception e) {
            e.printStackTrace();
        }  
    }
}