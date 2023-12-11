import javax.swing.*;
import java.awt.event.*;

/**
 * This class contains the methods for creating and running the ContactsApp.
 * 
 * Implements the ActionListener interface to listen to presses of the JButtons.
 * 
 * @author Veikka Luukkonen
 */
public class CreateWindow implements ActionListener {
    static JTextField id, fname, lname, phnum, addr, email;
    static JButton add, clear, delete, update, open;
    static JLabel idL, fnameL, lnameL, phnumL, addrL, emailL, instruct;
    /**
     * Constructor of the CreateWindow-class.
     * Contains operations for creating the application window.
     */
    CreateWindow() {
        JFrame gui = new JFrame();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the panel on the top of the window
        JPanel topLayout = new JPanel();
        // Create buttons
        add = new JButton("Add");
        clear = new JButton("Clear");
        delete = new JButton("Delete");
        update = new JButton("Update");
        open = new JButton("Open");
        // Actionlisteners
        add.addActionListener(this);
        clear.addActionListener(this);
        delete.addActionListener(this);
        update.addActionListener(this);
        open.addActionListener(this);
        //Adding the elements to the window
        topLayout.add(add);
        topLayout.add(delete);
        topLayout.add(update);
        topLayout.add(open);
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
        idL = new JLabel("(**) ID Number:");
        idL.setBounds(100, 50, 150, 20);
        fnameL = new JLabel("(*) First name:");
        fnameL.setBounds(100,100,150,20);
        lnameL = new JLabel("(*) Last name:");
        lnameL.setBounds(100,150,150,20);
        phnumL = new JLabel("(**) Phone number:");
        phnumL.setBounds(70,200,150,20);
        addrL = new JLabel("Address (Optional):");
        addrL.setBounds(78,250,150,20);
        emailL = new JLabel("Email (Optional):");
        emailL.setBounds(95,300,150,20);
        instruct = new JLabel("((**) Required for adding and updating) ((*) Always required)");
        instruct.setBounds(10,330,380,20);

        // Add JLabels to window
        gui.add(idL);
        gui.add(fnameL);
        gui.add(lnameL);
        gui.add(phnumL);
        gui.add(addrL);
        gui.add(emailL);
        gui.add(instruct);

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
    /**
     * Implementation of the actionPerformed method of the ActionListener interface.
     * 
     * User presses the clear button = empties all text fields.
     * User presses the add button = calls method validateRows of the Validate class.
     * User presses the delete button = calls method of the DeleteContact class.
     * User presses the open button = calls method of the OpenContact class.
     * User presses the update button = calls method updateContact of the UpdateContact class.
     * 
     * @param e Actionevent. User pressed button.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            id.setText("");
            fname.setText("");
            lname.setText("");
            phnum.setText("");
            addr.setText("");
            email.setText("");
        }
        else if (e.getSource() == add) {
            Validate.validateRows();
        }
        else if (e.getSource() == delete) {
            if (Validate.validateNames()) {
                DeleteContact.deleteContact();
            }
        }
        else if (e.getSource() == open) {
            if (Validate.validateNames()) {
                OpenContact.openContact();
            }
        }
        else if (e.getSource() == update) {
            UpdateContact.updateContact();
        }
    }
}
