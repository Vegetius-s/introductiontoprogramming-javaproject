import javax.swing.*;
import java.awt.event.*;

public class CreateWindow implements ActionListener {
    JTextField id, fname, lname, phnum, addr, email;
    JButton submit, clear;
    JLabel idL, fnameL, lnameL, phnumL, addrL, emailL;
    CreateWindow() {
        JFrame gui = new JFrame();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the panel on the top of the window
        JPanel topLayout = new JPanel();
        // Create buttons
        submit = new JButton("Submit");
        clear = new JButton("Clear");
        // Actionlisteners
        submit.addActionListener(this);
        clear.addActionListener(this);
        //Adding the elements to the window
        topLayout.add(submit);
        topLayout.add(clear);

        // Create textfields for user inputs
        id = new JTextField();
        id.setBounds(200,50,150,20);
        fname = new JTextField();
        fname.setBounds(200,100,150,20);
        lname = new JTextField();
        lname.setBounds(200,150,150,20);
        phnum = new JTextField();
        phnum.setBounds(200,200,150,20);
        addr = new JTextField();
        addr.setBounds(200,250,150,20);
        email = new JTextField();
        email.setBounds(200,300,150,20);

        // Create JLabels
        idL = new JLabel("ID Number:");
        idL.setBounds(120, 50, 150, 20);
        fnameL = new JLabel("First name:");
        fnameL.setBounds(120,100,150,20);
        lnameL = new JLabel("Last name:");
        lnameL.setBounds(120,150,150,20);
        phnumL = new JLabel("Phone number:");
        phnumL.setBounds(100,200,150,20);
        addrL = new JLabel("Address (Optional):");
        addrL.setBounds(78,250,150,20);
        emailL = new JLabel("Email (Optional):");
        emailL.setBounds(95,300,150,20);

        // Add JLabels to window
        gui.add(idL);
        gui.add(fnameL);
        gui.add(lnameL);
        gui.add(phnumL);
        gui.add(addrL);
        gui.add(emailL);

        // Add textfield to window
        gui.add(id);
        gui.add(fname);
        gui.add(lname);
        gui.add(phnum);
        gui.add(addr);
        gui.add(email);
        // Add top JPanel with buttons
        gui.add(topLayout);

        // Set size and display window
        gui.setSize(400,400);
        gui.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            id.setText("");
            fname.setText("");
            lname.setText("");
            phnum.setText("");
            addr.setText("");
            email.setText("");
        }
        if (e.getSource() == submit) {
            // validateRows();
        }
    }
    public String getContent(JTextField x) {
        return x.getText();
    }
}