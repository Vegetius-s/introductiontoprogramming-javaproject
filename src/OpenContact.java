import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.io.*;

public class OpenContact {
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