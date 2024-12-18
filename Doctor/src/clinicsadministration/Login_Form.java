package clinicsadministration;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login_Form extends JFrame implements ActionListener, KeyListener {

    Font newfont = new Font("NewTimeRoman", Font.BOLD, 16);
    Color select_btn = new Color(161, 230, 237);
    Color background_btn = new Color(228, 238, 248);
    JButton login = new JButton("Log in ");
    JButton cancel = new JButton("Close");
    JLabel l_name = new JLabel("Username ");
    JLabel l_pass = new JLabel("Password ");
    JTextField txt_name = new JTextField();
    JPasswordField pass = new JPasswordField();
    JCheckBox show = new JCheckBox("show the password ");
    JLabel background = new JLabel();

    JPanel panel = new JPanel(null);
    JLabel loginform = new JLabel(" Medical clinic ");

    public Login_Form() {
        this.setTitle("Log in ");
        setLayout(null);
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        panel.setBounds(0, 0, 800, 130);
        loginform.setBounds(330, 50, 170, 40);
        l_name.setBounds(620, 200, 90, 35);
        l_pass.setBounds(620, 250, 90, 35);
        txt_name.setBounds(250, 200, 350, 35);
        pass.setBounds(250, 250, 350, 35);
        login.setBounds(250, 330, 150, 35);
        cancel.setBounds(450, 330, 150, 35);
        show.setBounds(100, 260, 125, 20);
        background.setBounds(0, 0, 700, 500);

        panel.setBackground(Color.LIGHT_GRAY);
        this.getContentPane().setBackground(Color.WHITE);
        loginform.setFont(new Font("NewTimeRoman", Font.BOLD, 20));
        loginform.setForeground(Color.BLACK);
        l_name.setForeground(Color.BLACK);
        l_pass.setForeground(Color.BLACK);
        show.setBackground(Color.LIGHT_GRAY);
        show.setForeground(Color.BLACK);
//        login.setBackground(Color.GRAY);
//        cancel.setBackground(Color.GRAY;

        txt_name.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pass.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        panel.add(loginform);

        add(l_name);
        add(l_pass);
        add(txt_name);
        add(pass);
        add(login);
        add(cancel);
        add(show);
        add(background);
        add(panel);

        l_name.setFont(newfont);
        l_pass.setFont(newfont);
        txt_name.setFont(newfont);
        pass.setFont(newfont);
        login.setFont(newfont);
        cancel.setFont(newfont);

        login.addActionListener(this);
        cancel.addActionListener(this);
        show.addActionListener(this);
        addKeyListener(this);
        txt_name.addKeyListener(this);
        pass.addKeyListener(this);

        txt_name.requestFocus();
    }

    public boolean check_emile(String name, String pass) {
        Vector log = new Vector();
        log.add("admin");
        log.add("admin1");
        log.add("admin2");
        log.add("admin3");
        log.add("admin4");
        log.add("admin5");
        log.add("admin6");
        for (int i = 0; i < log.size(); i++) {
            if (name.compareToIgnoreCase(String.valueOf(log.get(i))) == 0 && pass.compareToIgnoreCase(String.valueOf(log.get(i))) == 0) {
                return true;
            }
        }
        return false;
    }

    public void logIN() {
        if (!txt_name.getText().isEmpty() && !pass.getText().isEmpty()) {
//            boolean check = check_emile(txt_name.getText(), pass.getText());
//            if (check) {
//                Vector<String> v = new Vector();
//                for (int i = 0; i < 12; i++) {
//                    v.add((i + 1) + "");
//                }
//                java.awt.EventQueue.invokeLater(new Runnable() {
//                    public void run() {
//                        new ClinicsAdministration(v).setVisible(true);
//                    }
//                });
//                dispose();
//            } else {
                String statement = "SELECT id, name, password FROM users WHERE name = '" + txt_name.getText() + "' ;";
                String id = "", name = "", password = "";
                try {
                    ResultSet rs = Tools.select_query(statement);
                    while (rs.next()) {
                        id = rs.getString(1);
                        name = rs.getString(2);
                        password = rs.getString(3);
                    }
                } catch (SQLException ex) {
                }
                Tools.closeConnection();
                if (txt_name.getText().equals(name) && pass.getText().equals(password)) {
                    Vector<String> btnnumber = new Vector();
                    statement = "SELECT btnnumber FROM permistion WHERE id = "+id+" ;";
                    try {
                        ResultSet rs = Tools.select_query(statement);
                        while (rs.next()) {
                            btnnumber.add(rs.getString(1));
                        }
                    } catch (SQLException ex) {
                    }
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new ClinicsAdministration(btnnumber).setVisible(true);
                        }
                    });
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, " Please check your username or password", "False", JOptionPane.WARNING_MESSAGE);
                }
//            }
        } else {
            JOptionPane.showMessageDialog(null, "Please check your username or password", "False", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            logIN();
        } else if (e.getSource() == cancel) {
            int c = JOptionPane.showConfirmDialog(null, "Do you want to Exit?", "Select", JOptionPane.YES_NO_OPTION);
            if (c == 0) {
                System.exit(0);
            }
        } else if (e.getSource() == show) {
            if (show.isSelected() == true) {
                pass.setEchoChar('\0');
                show.setText("Hide the password");
            } else {
                pass.setEchoChar('*');
//                pass.setEchoChar('•');
                show.setText("Hide the password");
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == txt_name || e.getSource() == pass) {
            switch (e.getKeyCode()) {
                case 37:
                case 38:
                    login.setBackground(select_btn);
                    cancel.setBackground(new JButton().getBackground());
                    break;
                case 39:
                case 40:
                    cancel.setBackground(select_btn);
                    login.setBackground(new JButton().getBackground());
                    break;
                case 10:
                    if (login.getBackground() == select_btn) {
                        logIN();
                    } else {
                        int c = JOptionPane.showConfirmDialog(null, "Do you want to close the program?", "Select", JOptionPane.YES_NO_OPTION);
                        if (c == 0) {
                            System.exit(0);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        new Login_Form();
    }

}
