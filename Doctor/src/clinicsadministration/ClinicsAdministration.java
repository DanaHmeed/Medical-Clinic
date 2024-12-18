/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicsadministration;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.io.File;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author engmu
 */
public class ClinicsAdministration extends javax.swing.JFrame {

    Vector<String> permision = new Vector();

    /**
     * Creates new form ClinicsAdministration
     */
    public ClinicsAdministration(Vector v) {
        initComponents();
        try {
            ImagePanel Ip = new ImagePanel();
            addPanel(Ip);
            Tools.setComponentBackGroundColor(panel);
            Tools.setComponentBackGroundColor(btnpanel);
            Vector color = getBackGroundColor();
            permision = v;
            getpermision();
            this.getContentPane().setBackground(new Color(Integer.parseInt(String.valueOf(color.get(0))), Integer.parseInt(String.valueOf(color.get(1))), Integer.parseInt(String.valueOf(color.get(2)))));
        } catch (Exception ex) {
        }
        jLabel1.setText(getCliencName());
        jMenuBar1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        adding.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        information.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        regester.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        accounts.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        settings.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        help.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    }

    public void getpermision() {
        if (!checkbtnnumber("1")) {
            reception.setEnabled(false);
            jMenuItem1.setEnabled(false);
        }
        if (!checkbtnnumber("2")) {
            next.setEnabled(false);
            jMenuItem5.setEnabled(false);
        }
        if (!checkbtnnumber("3")) {
            patientinformation.setEnabled(false);
            jMenuItem6.setEnabled(false);
        }
        if (!checkbtnnumber("4")) {
            clincservice.setEnabled(false);
            jMenuItem2.setEnabled(false);
            jMenuItem7.setEnabled(false);
        }
        if (!checkbtnnumber("5")) {
            adddoctors.setEnabled(false);
            jMenuItem3.setEnabled(false);
        }
        if (!checkbtnnumber("6")) {
            addemployee.setEnabled(false);
            jMenuItem4.setEnabled(false);
        }
        if (!checkbtnnumber("7")) {
            outcome.setEnabled(false);
            jMenuItem8.setEnabled(false);
        }
        if (!checkbtnnumber("8")) {
            restdoctors.setEnabled(false);
            jMenuItem9.setEnabled(false);
        }
        if (!checkbtnnumber("9")) {
            restemployee.setEnabled(false);
            jMenuItem10.setEnabled(false);
        }
        if (!checkbtnnumber("10")) {
            btnhelp.setEnabled(false);
            help.setEnabled(false);
        }
        if (!checkbtnnumber("11")) {
            users.setEnabled(false);
            jMenuItem12.setEnabled(false);
        }
        if (!checkbtnnumber("12")) {
            settings.setEnabled(false);
        }
    }

    public boolean checkbtnnumber(String num) {
        for (int i = 0; i < permision.size(); i++) {
            if (permision.get(i).equals(num)) {
                return true;
            }
        }
        return false;
    }

    public void addPanel(javax.swing.JPanel panel) {
        this.panel.removeAll();
        this.panel.revalidate();
        this.panel.repaint();
        panel.setBounds(0, 0, 1100, 700);
        this.panel.add(panel);
        panel.setVisible(true);
    }

    public String getCliencName() {
        String statement = "SELECT value FROM settings WHERE id = 1 ;";
        String name = "";
        ResultSet rs = Tools.select_query(statement);
        try {
            while (rs.next()) {
                name = rs.getString(1);
            }
            Tools.closeConnection();
        } catch (Exception ex) {
        }
        return name;
    }

    public Vector getBackGroundColor() {
        Vector arr = new Vector();
        String statement = "SELECT value FROM settings WHERE id = 2 OR id = 3 OR id = 4";
        ResultSet rs = Tools.select_query(statement);
        try {
            while (rs.next()) {
                arr.add(rs.getString(1));
            }
            Tools.closeConnection();
        } catch (Exception ex) {
        }
        return arr;
    }

    public Vector getPanelBackGroundColor() {
        Vector arr = new Vector();
        String statement = "SELECT value FROM settings WHERE id = 5 OR id = 6 OR id = 7";
        ResultSet rs = Tools.select_query(statement);
        try {
            while (rs.next()) {
                arr.add(rs.getString(1));
            }
            Tools.closeConnection();
        } catch (Exception ex) {
        }
        return arr;
    }

    public void backup() {
        Tools.closeConnection();
        String location = Tools.pathSaveFileChooser("Clinc_Administration.db");
        File from = new File("Clinc_Administration.db");
        File to = new File(location);
        try {
            if (!location.isEmpty()) {
                Tools.copyDirectory(from, to);
                JOptionPane.showMessageDialog(null, "Done Successfully");
            }
        } catch (Exception ex) {
        }
    }

    public void recovery() {
        Tools.closeConnection();
        String path = Tools.pathSelectDatabaseFile();
        File from = new File(path);
        File to = new File("Clinc_Administration.db");
        try {
            if (!path.isEmpty()) {
                to.delete();
                Tools.copyDirectory(from, to);
                JOptionPane.showMessageDialog(null, " Done Successfully ");
            }
        } catch (Exception ex) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        btnpanel = new javax.swing.JPanel();
        addemployee = new javax.swing.JButton();
        adddoctors = new javax.swing.JButton();
        patientinformation = new javax.swing.JButton();
        restemployee = new javax.swing.JButton();
        restdoctors = new javax.swing.JButton();
        btnhelp = new javax.swing.JButton();
        outcome = new javax.swing.JButton();
        clincservice = new javax.swing.JButton();
        next = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        users = new javax.swing.JButton();
        reception = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        adding = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        information = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        regester = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        accounts = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        settings = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("الشاشه الرئيسيه");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setBackground(new java.awt.Color(1, 1, 1));
        jLabel1.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("  Medical Clinic");
        jLabel1.setMaximumSize(new java.awt.Dimension(86, 36));
        jLabel1.setMinimumSize(new java.awt.Dimension(86, 36));
        jLabel1.setPreferredSize(new java.awt.Dimension(86, 36));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(455, 455, 455)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.getAccessibleContext().setAccessibleName("Medical Clinic");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1240, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
        );

        btnpanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        addemployee.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addemployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        addemployee.setText("Add Employee ");
        addemployee.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        addemployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addemployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addemployeeMouseExited(evt);
            }
        });
        addemployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addemployeeActionPerformed(evt);
            }
        });

        adddoctors.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        adddoctors.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        adddoctors.setText("Add Doctors ");
        adddoctors.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        adddoctors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adddoctorsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adddoctorsMouseExited(evt);
            }
        });
        adddoctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adddoctorsActionPerformed(evt);
            }
        });

        patientinformation.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        patientinformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        patientinformation.setText("Patients Info ");
        patientinformation.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        patientinformation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patientinformationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patientinformationMouseExited(evt);
            }
        });
        patientinformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientinformationActionPerformed(evt);
            }
        });

        restemployee.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        restemployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        restemployee.setText("Employees Accounts ");
        restemployee.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        restemployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                restemployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                restemployeeMouseExited(evt);
            }
        });
        restemployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restemployeeActionPerformed(evt);
            }
        });

        restdoctors.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        restdoctors.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        restdoctors.setText(" Doctors Accounts");
        restdoctors.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        restdoctors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                restdoctorsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                restdoctorsMouseExited(evt);
            }
        });
        restdoctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restdoctorsActionPerformed(evt);
            }
        });

        btnhelp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnhelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        btnhelp.setText("Help");
        btnhelp.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnhelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhelpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhelpMouseExited(evt);
            }
        });
        btnhelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhelpActionPerformed(evt);
            }
        });

        outcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        outcome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        outcome.setText("Salary ");
        outcome.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        outcome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                outcomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                outcomeMouseExited(evt);
            }
        });
        outcome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outcomeActionPerformed(evt);
            }
        });

        clincservice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clincservice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        clincservice.setText("Services/Clinics ");
        clincservice.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        clincservice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clincserviceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clincserviceMouseExited(evt);
            }
        });
        clincservice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clincserviceActionPerformed(evt);
            }
        });

        next.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        next.setText(" Next");
        next.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextMouseExited(evt);
            }
        });
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        exit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        exit.setText("Exit");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        users.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        users.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        users.setText("Users  Management");
        users.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                usersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                usersMouseExited(evt);
            }
        });
        users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersActionPerformed(evt);
            }
        });

        reception.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        reception.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        reception.setText("Reception");
        reception.setActionCommand("Reception");
        reception.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        reception.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                receptionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                receptionMouseExited(evt);
            }
        });
        reception.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnpanelLayout = new javax.swing.GroupLayout(btnpanel);
        btnpanel.setLayout(btnpanelLayout);
        btnpanelLayout.setHorizontalGroup(
            btnpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(patientinformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(clincservice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(adddoctors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addemployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(outcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(restemployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnhelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(users, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(restdoctors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reception, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnpanelLayout.setVerticalGroup(
            btnpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reception, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientinformation, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clincservice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adddoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addemployee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outcome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(restdoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(restemployee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnhelp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(users, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        adding.setText("Edit");
        adding.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem1.setText("Reception");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        adding.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem2.setText("Services/Clinics");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        adding.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem3.setText("Add Doctors ");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        adding.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem4.setText("Add Employees");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        adding.add(jMenuItem4);

        jMenuItem12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem12.setText("Users Management");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        adding.add(jMenuItem12);

        jMenuBar1.add(adding);

        information.setText("Information");
        information.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem5.setText("Next");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        information.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem6.setText("Patients Info");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        information.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem7.setText("Clinics Info");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        information.add(jMenuItem7);

        jMenuBar1.add(information);

        regester.setText("Records");
        regester.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jMenuItem8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem8.setText("Salary");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        regester.add(jMenuItem8);

        jMenuBar1.add(regester);

        accounts.setText("Accounts");
        accounts.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jMenuItem9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem9.setText("Doctors Accounts");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        accounts.add(jMenuItem9);

        jMenuItem10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem10.setText("Employees Accounts");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        accounts.add(jMenuItem10);

        jMenuBar1.add(accounts);

        settings.setText("Settings");
        settings.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jMenu1.setText("Advanced Settings");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jMenuItem13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem13.setText("Backup ");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenuItem14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem14.setText(" Data Recovery");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem14);

        settings.add(jMenu1);

        jMenu7.setText("change colors");
        jMenu7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jMenuItem20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem20.setText("Back ground color");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem20);

        jMenuItem21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem21.setText("Interface color");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem21);

        settings.add(jMenu7);

        jMenuItem17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem17.setText("Chanage Background");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        settings.add(jMenuItem17);

        jMenuItem15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem15.setText("Clinic Name");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        settings.add(jMenuItem15);

        jMenuBar1.add(settings);

        help.setText("Help");
        help.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jMenuItem18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        help.add(jMenuItem18);

        jMenuItem19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        help.add(jMenuItem19);

        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void receptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receptionActionPerformed
        // TODO add your handling code here:
        PatientPanel pp = new PatientPanel();
        addPanel(pp);
    }//GEN-LAST:event_receptionActionPerformed

    private void addemployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addemployeeActionPerformed
        // TODO add your handling code here:
        EmployeePanel ep = new EmployeePanel();
        addPanel(ep);
    }//GEN-LAST:event_addemployeeActionPerformed

    private void clincserviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clincserviceActionPerformed
        // TODO add your handling code here:
        ClincAndServicePanel csp = new ClincAndServicePanel();
        addPanel(csp);
    }//GEN-LAST:event_clincserviceActionPerformed

    private void adddoctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adddoctorsActionPerformed
        // TODO add your handling code here:
        DoctoresPanel dp = new DoctoresPanel();
        addPanel(dp);
    }//GEN-LAST:event_adddoctorsActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        new PatientNext().setVisible(true);
    }//GEN-LAST:event_nextActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        int choose = JOptionPane.showConfirmDialog(null, "  Do you want to Exit?", "exit", JOptionPane.YES_NO_OPTION);
        if (choose == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        PatientPanel pp = new PatientPanel();
        addPanel(pp);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
        Vector color = getBackGroundColor();
        Color c = JColorChooser.showDialog(null, "Color Picker", new Color(Integer.parseInt(String.valueOf(color.get(0))), Integer.parseInt(String.valueOf(color.get(1))), Integer.parseInt(String.valueOf(color.get(2)))));
        if (c != null) {
            boolean check = false;
            String statement = "UPDATE settings SET value = '" + c.getRed() + "' WHERE id = 2 ;";
            check = Tools.ExecuteStatement(statement);
            if (check) {
                statement = "UPDATE settings SET value = '" + c.getGreen() + "' WHERE id = 3 ;";
                Tools.ExecuteStatement(statement);
                statement = "UPDATE settings SET value = '" + c.getBlue() + "' WHERE id = 4 ;";
                Tools.ExecuteStatement(statement);
                color = getBackGroundColor();
                this.getContentPane().setBackground(new Color(Integer.parseInt(String.valueOf(color.get(0))), Integer.parseInt(String.valueOf(color.get(1))), Integer.parseInt(String.valueOf(color.get(2)))));
            }
        }
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void patientinformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientinformationActionPerformed
        // TODO add your handling code here:
        InformationPatientAndClientPanel ip = new InformationPatientAndClientPanel();
        addPanel(ip);
    }//GEN-LAST:event_patientinformationActionPerformed

    private void outcomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outcomeActionPerformed
        // TODO add your handling code here:
        OutCome op = new OutCome();
        addPanel(op);
    }//GEN-LAST:event_outcomeActionPerformed

    private void usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersActionPerformed
        // TODO add your handling code here:
        UsersManagementPanel up = new UsersManagementPanel();
        addPanel(up);
    }//GEN-LAST:event_usersActionPerformed

    private void receptionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receptionMouseEntered
        // TODO add your handling code here:
        reception.setBackground(new Color(0, 120, 215));
    }//GEN-LAST:event_receptionMouseEntered

    private void nextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseEntered
        // TODO add your handling code here:
        next.setBackground(new Color(0, 120, 215));
    }//GEN-LAST:event_nextMouseEntered

    private void patientinformationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientinformationMouseEntered
        // TODO add your handling code here:
        patientinformation.setBackground(new Color(0, 120, 215));
    }//GEN-LAST:event_patientinformationMouseEntered

    private void clincserviceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clincserviceMouseEntered
        // TODO add your handling code here:
        clincservice.setBackground(new Color(0, 120, 215));
    }//GEN-LAST:event_clincserviceMouseEntered

    private void adddoctorsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adddoctorsMouseEntered
        // TODO add your handling code here:
        adddoctors.setBackground(new Color(0, 120, 215));
    }//GEN-LAST:event_adddoctorsMouseEntered

    private void addemployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addemployeeMouseEntered
        // TODO add your handling code here:
        addemployee.setBackground(new Color(0, 120, 215));
    }//GEN-LAST:event_addemployeeMouseEntered

    private void outcomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outcomeMouseEntered
        // TODO add your handling code here:
        outcome.setBackground(new Color(0, 120, 215));
    }//GEN-LAST:event_outcomeMouseEntered

    private void restdoctorsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restdoctorsMouseEntered
        // TODO add your handling code here:
        restdoctors.setBackground(new Color(0, 120, 215));
    }//GEN-LAST:event_restdoctorsMouseEntered

    private void restemployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restemployeeMouseEntered
        // TODO add your handling code here:
        restemployee.setBackground(new Color(0, 120, 215));
    }//GEN-LAST:event_restemployeeMouseEntered

    private void usersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersMouseEntered
        // TODO add your handling code here:
        users.setBackground(new Color(0, 120, 215));
    }//GEN-LAST:event_usersMouseEntered

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        // TODO add your handling code here:
        exit.setBackground(new Color(0, 120, 215));
    }//GEN-LAST:event_exitMouseEntered

    private void receptionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receptionMouseExited
        // TODO add your handling code here:
        reception.setBackground(new javax.swing.JButton().getBackground());
    }//GEN-LAST:event_receptionMouseExited

    private void nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseExited
        // TODO add your handling code here:
        next.setBackground(new javax.swing.JButton().getBackground());
    }//GEN-LAST:event_nextMouseExited

    private void patientinformationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientinformationMouseExited
        // TODO add your handling code here:
        patientinformation.setBackground(new javax.swing.JButton().getBackground());
    }//GEN-LAST:event_patientinformationMouseExited

    private void clincserviceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clincserviceMouseExited
        // TODO add your handling code here:
        clincservice.setBackground(new javax.swing.JButton().getBackground());
    }//GEN-LAST:event_clincserviceMouseExited

    private void adddoctorsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adddoctorsMouseExited
        // TODO add your handling code here:
        adddoctors.setBackground(new javax.swing.JButton().getBackground());
    }//GEN-LAST:event_adddoctorsMouseExited

    private void addemployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addemployeeMouseExited
        // TODO add your handling code here:
        addemployee.setBackground(new javax.swing.JButton().getBackground());
    }//GEN-LAST:event_addemployeeMouseExited

    private void outcomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outcomeMouseExited
        // TODO add your handling code here:
        outcome.setBackground(new javax.swing.JButton().getBackground());
    }//GEN-LAST:event_outcomeMouseExited

    private void restdoctorsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restdoctorsMouseExited
        // TODO add your handling code here:
        restdoctors.setBackground(new javax.swing.JButton().getBackground());
    }//GEN-LAST:event_restdoctorsMouseExited

    private void restemployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restemployeeMouseExited
        // TODO add your handling code here:
        restemployee.setBackground(new javax.swing.JButton().getBackground());
    }//GEN-LAST:event_restemployeeMouseExited

    private void usersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersMouseExited
        // TODO add your handling code here:
        users.setBackground(new javax.swing.JButton().getBackground());
    }//GEN-LAST:event_usersMouseExited

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        // TODO add your handling code here:
        exit.setBackground(new javax.swing.JButton().getBackground());
    }//GEN-LAST:event_exitMouseExited

    private void restdoctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restdoctorsActionPerformed
        // TODO add your handling code here:
        DoctorsAccount da = new DoctorsAccount();
        addPanel(da);
    }//GEN-LAST:event_restdoctorsActionPerformed

    private void restemployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restemployeeActionPerformed
        // TODO add your handling code here:
        AccountEmployee ae = new AccountEmployee();
        addPanel(ae);
    }//GEN-LAST:event_restemployeeActionPerformed

    private void btnhelpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhelpMouseExited
        // TODO add your handling code here:
        btnhelp.setBackground(new javax.swing.JButton().getBackground());
    }//GEN-LAST:event_btnhelpMouseExited

    private void btnhelpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhelpMouseEntered
        // TODO add your handling code here:
        btnhelp.setBackground(new Color(0, 120, 215));
    }//GEN-LAST:event_btnhelpMouseEntered

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        DoctoresPanel dp = new DoctoresPanel();
        addPanel(dp);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btnhelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhelpActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        ClincAndServicePanel csp = new ClincAndServicePanel();
        addPanel(csp);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        EmployeePanel ep = new EmployeePanel();
        addPanel(ep);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        UsersManagementPanel up = new UsersManagementPanel();
        addPanel(up);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        new PatientNext().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        InformationPatientAndClientPanel ip = new InformationPatientAndClientPanel();
        addPanel(ip);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        new InformationCilncAndServices().setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        OutCome op = new OutCome();
        addPanel(op);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        DoctorsAccount da = new DoctorsAccount();
        addPanel(da);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        AccountEmployee ae = new AccountEmployee();
        addPanel(ae);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(null, "Clienc Name", getCliencName());
        try {
            if (!input.isEmpty() && !input.equals("null")) {
                String statement = "UPDATE settings SET name = 'clienc name', value = '" + input + "' WHERE id = 1 ;";
                boolean check = Tools.ExecuteStatement(statement);
                if (check) {
                    JOptionPane.showMessageDialog(null, " Added Successfully");
                }
                jLabel1.setText(getCliencName());
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        // TODO add your handling code here:
        Vector color = getPanelBackGroundColor();
        Color c = JColorChooser.showDialog(null, "Color Picker", new Color(Integer.parseInt(String.valueOf(color.get(0))), Integer.parseInt(String.valueOf(color.get(1))), Integer.parseInt(String.valueOf(color.get(2)))));
        if (c != null) {
            boolean check = false;
            String statement = "UPDATE settings SET value = '" + c.getRed() + "' WHERE id = 5 ;";
            check = Tools.ExecuteStatement(statement);
            if (check) {
                statement = "UPDATE settings SET value = '" + c.getGreen() + "' WHERE id = 6 ;";
                Tools.ExecuteStatement(statement);
                statement = "UPDATE settings SET value = '" + c.getBlue() + "' WHERE id = 7 ;";
                Tools.ExecuteStatement(statement);
                Tools.setComponentBackGroundColor(btnpanel);
            }
        }
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        backup();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        recovery();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        new BackgroundImage(this, true).setVisible(true);
        Tools.setImagePanel();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClinicsAdministration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClinicsAdministration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClinicsAdministration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClinicsAdministration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu accounts;
    private javax.swing.JButton adddoctors;
    private javax.swing.JButton addemployee;
    private javax.swing.JMenu adding;
    private javax.swing.JButton btnhelp;
    private javax.swing.JPanel btnpanel;
    private javax.swing.JButton clincservice;
    private javax.swing.JButton exit;
    private javax.swing.JMenu help;
    private javax.swing.JMenu information;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton next;
    private javax.swing.JButton outcome;
    public static javax.swing.JPanel panel;
    private javax.swing.JButton patientinformation;
    private javax.swing.JButton reception;
    private javax.swing.JMenu regester;
    private javax.swing.JButton restdoctors;
    private javax.swing.JButton restemployee;
    private javax.swing.JMenu settings;
    private javax.swing.JButton users;
    // End of variables declaration//GEN-END:variables
}
