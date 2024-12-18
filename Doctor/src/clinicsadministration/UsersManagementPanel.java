/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicsadministration;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author engmu
 */
public class UsersManagementPanel extends javax.swing.JPanel {

    int row = -1;
    Vector<String> selectednumber = new Vector();
    Vector<String> idusers = new Vector();
    Vector<String> btnnumber = new Vector();

    /**
     * Creates new form UsersManagementPanel
     */
    public UsersManagementPanel() {
        initComponents();
        Tools.HeaderRendererCenter(table);
        Tools.rowRenderCenter(table);
        Tools.setComponentBackGroundColor(this);
        Tools.setComponentBackGroundColor(jPanel1);
        Tools.setComponentBackGroundColor(jPanel2);
        Tools.setComponentBackGroundColor(jPanel3);
        Tools.setScrollBackGroundColor(jScrollPane1);
        Tools.setComponentBackGroundColor(jPanel1);
        Tools.setComponentBackGroundColor(reception);
        Tools.setComponentBackGroundColor(next);
        Tools.setComponentBackGroundColor(patientinformation);
        Tools.setComponentBackGroundColor(clincservice);
        Tools.setComponentBackGroundColor(adddoctors);
        Tools.setComponentBackGroundColor(addemployee);
        Tools.setComponentBackGroundColor(outcome);
        Tools.setComponentBackGroundColor(restdoctors);
        Tools.setComponentBackGroundColor(restemployee);
        Tools.setComponentBackGroundColor(help);
        Tools.setComponentBackGroundColor(users);
        Tools.setComponentBackGroundColor(settings);
        Tools.setComponentBackGroundColor(comboselect);
        getSelect();
        updateTable();
    }

    public void getSelect() {
        int select = comboselect.getSelectedIndex();
        if (select == 0) {
            setSelected(true);
            setEnabled(false);
        } else {
            setSelected(false);
            setEnabled(true);
        }
    }

    public void setSelected(boolean select) {
        reception.setSelected(select);
        next.setSelected(select);
        patientinformation.setSelected(select);
        clincservice.setSelected(select);
        adddoctors.setSelected(select);
        addemployee.setSelected(select);
        outcome.setSelected(select);
        restdoctors.setSelected(select);
        restemployee.setSelected(select);
        help.setSelected(select);
        users.setSelected(select);
        settings.setSelected(select);
    }

    public void setEnabled(boolean enabled) {
        reception.setEnabled(enabled);
        next.setEnabled(enabled);
        patientinformation.setEnabled(enabled);
        clincservice.setEnabled(enabled);
        adddoctors.setEnabled(enabled);
        addemployee.setEnabled(enabled);
        outcome.setEnabled(enabled);
        restdoctors.setEnabled(enabled);
        restemployee.setEnabled(enabled);
        help.setEnabled(enabled);
        users.setEnabled(enabled);
        settings.setEnabled(enabled);
    }

    public void isSelected () {
        selectednumber.removeAllElements();
        if (reception.isSelected()) {
            selectednumber.add("1");
        }
        if (next.isSelected()) {
            selectednumber.add("2");
        }
        if (patientinformation.isSelected()) {
            selectednumber.add("3");
        }
        if (clincservice.isSelected()) {
            selectednumber.add("4");
        }
        if (adddoctors.isSelected()) {
            selectednumber.add("5");
        }
        if (addemployee.isSelected()) {
            selectednumber.add("6");
        }
        if (outcome.isSelected()) {
            selectednumber.add("7");
        }
        if (restdoctors.isSelected()) {
            selectednumber.add("8");
        }
        if (restemployee.isSelected()) {
            selectednumber.add("9");
        }
        if (help.isSelected()) {
            selectednumber.add("10");
        }
        if (users.isSelected()) {
            selectednumber.add("11");
        }
        if (settings.isSelected()) {
            selectednumber.add("12");
        }
    }

    public void resetValue () {
        row = -1;
        txtname.setText("");
        txtpass.setText("");
        comboselect.setSelectedIndex(0);
        getSelect();
    }

    public void updateTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        idusers.removeAllElements();
        String statement = "SELECT * FROM users";
        ResultSet rs = Tools.select_query(statement);
        try {
            String state = "";
            while (rs.next()) {
                idusers.add(rs.getString(1));
                Vector v = new Vector();
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                if (rs.getString(4).equals("0")) {
                    state = "ادمن";
                } else {
                    state = "مخصص";
                }
                v.add(state);
                model.addRow(v);
            }
        } catch (Exception ex) {
        }
        Tools.closeConnection();
    }

    public void clicktable () {
        btnnumber.removeAllElements();
        String statement = "SELECT btnnumber FROM permistion WHERE id = " + idusers.get(row) + " ;";
        ResultSet rs = Tools.select_query(statement);
        try {
            while (rs.next()) {
                btnnumber.add(rs.getString(1));
            }
        } catch (Exception ex) {
        }
        Tools.closeConnection();
        if (checkbtnnumber("1")) {
            reception.setSelected(true);
        }
        if (checkbtnnumber("2")) {
            next.setSelected(true);
        }
        if (checkbtnnumber("3")) {
            patientinformation.setSelected(true);
        }
        if (checkbtnnumber("4")) {
            clincservice.setSelected(true);
        }
        if (checkbtnnumber("5")) {
            adddoctors.setSelected(true);
        }
        if (checkbtnnumber("6")) {
            addemployee.setSelected(true);
        }
        if (checkbtnnumber("7")) {
            outcome.setSelected(true);
        }
        if (checkbtnnumber("8")) {
            restdoctors.setSelected(true);
        }
        if (checkbtnnumber("9")) {
            restemployee.setSelected(true);
        }
        if (checkbtnnumber("10")) {
            help.setSelected(true);
        }
        if (checkbtnnumber("11")) {
            users.setSelected(true);
        }
        if (checkbtnnumber("12"))
            settings.setSelected(true);
    }

    public boolean checkbtnnumber(String num) {
        for (int i = 0; i < btnnumber.size(); i++) {
            if (btnnumber.get(i).equals(num)) {
                return true;
            }
        }
        return false;
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
        txtname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboselect = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtpass = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        reception = new javax.swing.JCheckBox();
        next = new javax.swing.JCheckBox();
        patientinformation = new javax.swing.JCheckBox();
        clincservice = new javax.swing.JCheckBox();
        adddoctors = new javax.swing.JCheckBox();
        addemployee = new javax.swing.JCheckBox();
        outcome = new javax.swing.JCheckBox();
        restdoctors = new javax.swing.JCheckBox();
        restemployee = new javax.swing.JCheckBox();
        users = new javax.swing.JCheckBox();
        help = new javax.swing.JCheckBox();
        settings = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Username");

        txtname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtname.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Stauts");

        comboselect.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        comboselect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin" }));
        comboselect.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboselectItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Password");

        txtpass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtpass.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        jButton1.setToolTipText("الرجوع الى الشاشه الرئيسيه");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboselect, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(164, 164, 164)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(comboselect, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        table.getTableHeader().setFont(new Font("NewTimeRoman", Font.BOLD, 18));
        table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", " password", "stauts"
            }
        ));
        table.setRowHeight(40);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        reception.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        reception.setText("Reception");
        reception.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receptionActionPerformed(evt);
            }
        });

        next.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        next.setText("Next");

        patientinformation.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        patientinformation.setText("Patient Info");
        patientinformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientinformationActionPerformed(evt);
            }
        });

        clincservice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clincservice.setText("Services");

        adddoctors.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        adddoctors.setText("Add Doctors");

        addemployee.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addemployee.setText("Add Employees");
        addemployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addemployeeActionPerformed(evt);
            }
        });

        outcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        outcome.setText("Salary");

        restdoctors.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        restdoctors.setText("Doctors Accounts");

        restemployee.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        restemployee.setText("Employees Accounts");

        users.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        users.setText("Useres Management");

        help.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        help.setText("Help");

        settings.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        settings.setText("Settings");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(help, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(settings, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(users, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(next, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(patientinformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(clincservice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(outcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adddoctors, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(restemployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reception, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addemployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(restdoctors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reception, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientinformation, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clincservice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adddoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addemployee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outcome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(restdoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(restemployee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(help, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(users, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnadd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnupdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnupdate.setText("Edit");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnupdate, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btndelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnadd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(286, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        row = table.getSelectedRow();
        txtname.setText(String.valueOf(table.getValueAt(row, 0)));
        txtpass.setText(String.valueOf(table.getValueAt(row, 1)));
        comboselect.setSelectedItem(String.valueOf(table.getValueAt(row, 2)));
        clicktable();
    }//GEN-LAST:event_tableMouseClicked

    private void comboselectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboselectItemStateChanged
        // TODO add your handling code here:
        try {
            getSelect();
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_comboselectItemStateChanged

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        if (!txtname.getText().isEmpty() && !txtpass.getText().isEmpty()) {
            String statement = "INSERT INTO users(name, password, states) VALUES('" + txtname.getText() + "', '" + txtpass.getText() + "', " + comboselect.getSelectedIndex() + " ) ;";
            boolean check = Tools.ExecuteStatement(statement);
            if (check) {
                isSelected();
                String id = "";
                statement = "SELECT id FROM users ;";
                ResultSet rs = Tools.select_query(statement);
                try {
                    while (rs.next()) {
                        id = rs.getString(1);
                    }
                } catch (Exception ex) {
                }
                for (int i = 0; i < selectednumber.size(); i++) {
                    statement = "INSERT INTO permistion(id, btnnumber) VALUES(" + id + ", " + selectednumber.get(i) + ");";
                    Tools.ExecuteStatement(statement);
                }
                JOptionPane.showMessageDialog(null, "تمت الاضافه بنجاح");
                updateTable();
                resetValue();
            }
            Tools.closeConnection();
        } else {
            JOptionPane.showMessageDialog(null, "يجب ادخال اسم المستخدم وكلمه المرور");
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        if (row > -1) {
            String statement = "DELETE FROM permistion WHERE id = " + idusers.get(row) + " ;";
            boolean check = Tools.ExecuteStatement(statement);
            if (check) {
                statement = "UPDATE users SET name = '" + txtname.getText() + "', password = '" + txtpass.getText() + "', states = " + comboselect.getSelectedIndex() + " WHERE id = " + idusers.get(row) + " ;";
                Tools.ExecuteStatement(statement);
                isSelected();
                for (int i = 0; i < selectednumber.size(); i++) {
                    statement = "INSERT INTO permistion(id, btnnumber) VALUES(" + idusers.get(row) + ", " + selectednumber.get(i) + ");";
                    Tools.ExecuteStatement(statement);
                }
                JOptionPane.showMessageDialog(null, "تم التعديل بنجاح");
                updateTable();
                resetValue();
            }
            Tools.closeConnection();
        } else {
            JOptionPane.showMessageDialog(null, "يجب اختيار سطر من الجدول");
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        if (row > -1) {
            String statement = "DELETE FROM permistion WHERE id = " + idusers.get(row) + " ;";
            boolean check = Tools.ExecuteStatement(statement);
            if (check) {
                statement = "DELETE FROM users WHERE id = " + idusers.get(row) + " ;";
                Tools.ExecuteStatement(statement);
                JOptionPane.showMessageDialog(null, "تم الحذف بنجاح");
                updateTable();
                resetValue();
            }
            Tools.closeConnection();
        } else {
            JOptionPane.showMessageDialog(null, "يجب اختيار سطر من الجدول");
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Tools.setImagePanel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void receptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receptionActionPerformed

    private void patientinformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientinformationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientinformationActionPerformed

    private void addemployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addemployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addemployeeActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox adddoctors;
    private javax.swing.JCheckBox addemployee;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnupdate;
    private javax.swing.JCheckBox clincservice;
    private javax.swing.JComboBox<String> comboselect;
    private javax.swing.JCheckBox help;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox next;
    private javax.swing.JCheckBox outcome;
    private javax.swing.JCheckBox patientinformation;
    private javax.swing.JCheckBox reception;
    private javax.swing.JCheckBox restdoctors;
    private javax.swing.JCheckBox restemployee;
    private javax.swing.JCheckBox settings;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpass;
    private javax.swing.JCheckBox users;
    // End of variables declaration//GEN-END:variables
}
