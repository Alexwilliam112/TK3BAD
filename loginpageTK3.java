import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class loginpageTK3 extends JFrame implements ActionListener {
    
    //declare
    private JPanel title_panel, text_panel, button_panel;
    private JLabel title, username, password;
    private JTextField variabel_user;
    private JPasswordField variabel_pass;
    private JButton variabel_masuk, variabel_keluar;
    private JCheckBox variabel_tampilpass;
    //TEXT SETTINGS
    final String text_login = "LOGIN";
    final String text_cancel = "CANCEL";
    final String text_checkbox = "Show Password";

    //CREDENTIAL VALIDATION METHOD
    final String username_value = "super admin";
    final String password_value = "12345678";
    private boolean validation(String val_user, String val_pass) {
        return username_value.equals(val_user) && password_value.equals(val_pass);
    }

    public loginpageTK3() {
        //frame setup
        setTitle("TK2BAD.app");
        setSize(400,230);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //component LABEL
        title = new JLabel("LOGIN PAGE");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        username = new JLabel("USERNAME:  ");
        username.setFont(new Font("Arial", Font.BOLD, 14));
        password = new JLabel("PASSWORD:  ");
        password.setFont(new Font("Arial", Font.BOLD, 14));

        //component TEXT FIELD
        variabel_user = new JTextField(20); //text field
        variabel_pass = new JPasswordField(20); //password field

        //component buttons
        variabel_masuk = new JButton(text_login); //login button
        variabel_masuk.addActionListener(this);
        variabel_keluar = new JButton(text_cancel); //exit app
        variabel_keluar.addActionListener(this);
        //component checkbox
        variabel_tampilpass = new JCheckBox(text_checkbox);
        variabel_tampilpass.addActionListener(this);

        //add panel
        title_panel = new JPanel(new FlowLayout());
        text_panel = new JPanel(new FlowLayout());
        button_panel = new JPanel(new FlowLayout());

        //components layouting
        title_panel.add(title);
        text_panel.add(username);
        text_panel.add(variabel_user);
        text_panel.add(password);
        text_panel.add(variabel_pass);
        text_panel.add(variabel_tampilpass);
        button_panel.add(variabel_masuk);
        button_panel.add(variabel_keluar);

        //borderlayout set
        setLayout(new BorderLayout());
        add(title_panel, BorderLayout.NORTH);
        add(text_panel, BorderLayout.CENTER);
        add(button_panel, BorderLayout.SOUTH);
        setVisible(true);
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(text_login)) {
            String val_user = variabel_user.getText();
            String val_pass = new String(variabel_pass.getPassword()); //convert to string
            if (validation(val_user, val_pass)) { //call validation method
                JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL! WELCOME BACK " + username_value, 
                "LOGIN SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                variabel_user.setText("");
                variabel_pass.setText("");
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Credentials. Please Contact Administrator", 
                "INVALID LOGIN", JOptionPane.ERROR_MESSAGE);
                variabel_user.setText("");
                variabel_pass.setText("");
                return;
            }
        }
        else if (e.getActionCommand().equals(text_cancel))
        { //if exit, show dialog box
            int confirmation = JOptionPane.showConfirmDialog(null, 
            "Confirm exiting the application.",
            "EXIT", JOptionPane.YES_NO_OPTION);
            //if confirm exit app
            if (confirmation == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
        else if (e.getActionCommand().equals(text_checkbox)) {
            //conditions: show password only if checkbox is selected
            if (variabel_tampilpass.isSelected()) {
                //turns char to normal char
                variabel_pass.setEchoChar((char) 0);
            } else { //return password field back to buttons char
                variabel_pass.setEchoChar('\u2022');
            }
            
        }
    }

    public static void main (String[] args) {
        new loginpageTK3();
    }




}
