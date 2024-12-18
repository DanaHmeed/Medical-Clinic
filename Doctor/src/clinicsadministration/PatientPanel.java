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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author engmu
 */
public class PatientPanel extends javax.swing.JPanel {

    Vector<String> priceclincname = new Vector();
    Vector<String> idclincname = new Vector();
    Vector<String> iddoctors = new Vector();

    /**
     * Creates new form PatientPanel
     */
    public PatientPanel() {
        initComponents();
        setItemcombospecial();
        updateTable();
        try {
            txtvalue.setText(priceclincname.get(combospecial.getSelectedIndex()));
        } catch (Exception ex) {
        }
        gettxtDoctorName();
        txtvisitdate.setText(Tools.date());
        Tools.setComponentBackGroundColor(jPanel1);
        Tools.setComponentBackGroundColor(jPanel2);
        Tools.setComponentBackGroundColor(jPanel3);
        Tools.setComponentBackGroundColor(jPanel4);
        Tools.setComponentBackGroundColor(rdname);
        Tools.setComponentBackGroundColor(rdcode);
        Tools.setComponentBackGroundColor(this);
        Tools.setScrollBackGroundColor(jScrollPane1);
        Tools.setComponentBackGroundColor(combosex);
        Tools.setComponentBackGroundColor(combospecial);
        Tools.setComponentBackGroundColor(txtdoctorname);
    }

    public void setItemcombospecial() {
        combospecial.removeAllItems();
        String statement = "SELECT * FROM clincname";
        ResultSet rs = Tools.select_query(statement);
        try {
            while (rs.next()) {
                idclincname.add(rs.getString(1));
                combospecial.addItem(rs.getString(2));
                priceclincname.add(rs.getString(3));
            }
        } catch (Exception ex) {
        }
        Tools.closeConnection();
    }

    public void updateTable() {
        try {
            String statement = "SELECT name, price FROM clincservice WHERE id = " + idclincname.get(combospecial.getSelectedIndex()) + " ;";
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Tools.tableUpdate(model, statement, 2);
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            for (int i = 0; i < table.getColumnCount() - 1; i++) {
                table.getColumnModel().getColumn(i).setCellRenderer(renderer);
            }
        } catch (Exception ex) {
        }
    }

    public int getTotalTable() {
        int total = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            try {
                if ((boolean) table.getValueAt(i, 2)) {
                    int sum = Integer.parseInt(String.valueOf(table.getValueAt(i, 1)));
                    total += sum;
                }
            } catch (Exception ex) {
            }
        }
        return total;
    }

    public int getPercent(String perc, String value) {
        int percent = Integer.parseInt(perc);
        percent *= Integer.parseInt(value);
        percent /= 100;
        int sum = Integer.parseInt(value);
        sum -= percent;
        return sum;
    }

    public void gettxtDoctorName() {
        iddoctors.removeAllElements();
        txtdoctorname.removeAllItems();
        String statement = "SELECT id, name FROM doctors ;";
        ResultSet rs = Tools.select_query(statement);
        try {
            while (rs.next()) {
                iddoctors.add(rs.getString(1));
                txtdoctorname.addItem(rs.getString(2));
            }
        } catch (Exception ex) {
        }
        Tools.closeConnection();
    }

    public void resetValue() {
        txtcode.setText("");
        txtname.setText("");
        txtaddress.setText("");
        txtphone.setText("");
        txtemail.setText("");
        txtbirthdate.setText("");
        try {
            combosex.setSelectedIndex(0);
        } catch (Exception ex) {
        }
        try {
            combospecial.setSelectedIndex(0);
        } catch (Exception ex) {
        }
        txtvisitdate.setText(Tools.date());
        txtvisitnumber.setValue(1);
        try {
            txtdoctorname.setSelectedIndex(0);
        } catch (Exception ex) {
        }
        txtnotes.setText("");
        txtvalue.setText(priceclincname.get(combospecial.getSelectedIndex()));
        txtdiscount.setText("0");
        txtpay.setText("0");
        txtrest.setText("0");
        updateTable();
    }

    public int sumrest() {
        int sum = 0;
        try {
            sum = Integer.parseInt(txtvalue.getText());
            sum -= Integer.parseInt(txtpay.getText());
        } catch (Exception ex) {
        }
        return sum;
    }

    public int sumdiscont() {
        int sum = 0;
        sum = Integer.parseInt(txtvalue.getText());
        sum -= Integer.parseInt(txtdiscount.getText());
        return sum;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        txtcode = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        combospecial = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        combosex = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtvisitdate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtbirthdate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtvisitnumber = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnotes = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtvalue = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdiscount = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtpay = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtrest = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnadd1 = new javax.swing.JButton();
        btnupdate1 = new javax.swing.JButton();
        btndelete1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtdoctorname = new javax.swing.JComboBox<>();
        btnsearch = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        rdname = new javax.swing.JRadioButton();
        rdcode = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        txtcode.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtcode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Name");

        txtname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtname.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Address");

        txtaddress.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtaddress.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddressActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Phone");

        txtphone.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtphone.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Email");

        txtemail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Birth Date");

        combospecial.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        combospecial.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combospecialItemStateChanged(evt);
            }
        });
        combospecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combospecialActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Gender");

        combosex.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        combosex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Famale" }));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("visiting Date ");

        txtvisitdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtvisitdate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtvisitdate.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clinic");

        txtbirthdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("visiting Number");

        txtvisitnumber.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtvisitnumber.setToolTipText("رقم الزياره الحاليه");
        txtvisitnumber.setRequestFocusEnabled(false);
        txtvisitnumber.setValue(1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Doctor Name ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Notes");

        txtnotes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtnotes.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("The value");

        txtvalue.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtvalue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtvalue.setText("0");
        txtvalue.setToolTipText("اجمالي المبلغ المستحق");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Discount");

        txtdiscount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtdiscount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdiscount.setText("0");
        txtdiscount.setToolTipText("وضع القيمه بالنسبه المئويه");
        txtdiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscountKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Paid");

        txtpay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtpay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpay.setText("0");
        txtpay.setToolTipText("المبلغ المدفوع من قبل المريض");
        txtpay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpayKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Rest");

        txtrest.setEditable(false);
        txtrest.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtrest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtrest.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(txtrest, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtpay, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrest, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        table.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        table.getTableHeader().setFont(new Font("NewTimeRoman", Font.BOLD, 18));
        table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Service Name", "Price", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(0, 255, 255));
        table.setRowHeight(40);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        btnadd1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnadd1.setText("Add");
        btnadd1.setToolTipText("اضافه مريض جديد او اضافه زياره جديده لمريض قديم");
        btnadd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadd1ActionPerformed(evt);
            }
        });

        btnupdate1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnupdate1.setText("Edit");
        btnupdate1.setToolTipText("تعديل المعلومات الشخصيه فقط");
        btnupdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate1ActionPerformed(evt);
            }
        });

        btndelete1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btndelete1.setText("Delete");
        btndelete1.setToolTipText("حذف جميع معلومات المريض");
        btndelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelete1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Show Info");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btndelete1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                        .addComponent(btnupdate1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnadd1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnadd1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnupdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        txtdoctorname.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtdoctorname.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtdoctornameItemStateChanged(evt);
            }
        });
        txtdoctorname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdoctornameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combosex, 0, 158, Short.MAX_VALUE)
                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtvisitnumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtvisitdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtbirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(68, 68, 68)
                                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtnotes, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combospecial, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdoctorname, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(combosex, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtbirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1))))
                    .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combospecial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtvisitnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtvisitdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnotes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdoctorname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)))
        );

        btnsearch.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        txtsearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtsearch.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        jButton2.setBackground(new java.awt.Color(0, 0, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reseticon.png"))); // NOI18N
        jButton2.setToolTipText("اعاده تهيئه الجميع");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        jButton3.setToolTipText("الرجوع الى الشاشه الرئيسيه");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdname);
        rdname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdname.setSelected(true);
        rdname.setText("Name");
        rdname.setToolTipText("بحث عن طريق الاسم");

        buttonGroup1.add(rdcode);
        rdcode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdcode.setText("Code");
        rdcode.setToolTipText("بحث عن طريق الكود");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdcode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnsearch)
                                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdname)
                                .addComponent(rdcode))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void combospecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combospecialActionPerformed
        // TODO add your handling code here:
//        System.out.println("yes");
//        setItemcombospecial();
//        updateTable();
    }//GEN-LAST:event_combospecialActionPerformed

    private void combospecialItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combospecialItemStateChanged
        // TODO add your handling code here:
        try {
            txtvalue.setText(priceclincname.get(combospecial.getSelectedIndex()));
        } catch (Exception ex) {
        }
        try {
            updateTable();
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_combospecialItemStateChanged

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        try {
            int row = table.getSelectedRow();
            int total = getTotalTable();
            total += Integer.parseInt(priceclincname.get(combospecial.getSelectedIndex()));
            txtvalue.setText(String.valueOf(total));
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_tableMouseClicked

    private void txtdiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscountKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            txtvalue.setText(String.valueOf(getPercent(txtdiscount.getText(), txtvalue.getText())));
        }
    }//GEN-LAST:event_txtdiscountKeyReleased

    private void btnadd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadd1ActionPerformed
        // TODO add your handling code here:
        ResultSet rs = Tools.select_query("SELECT * FROM patient; ");
        int count = 1;
        try {
            while (rs.next()) {
                count++;
            }
        } catch (Exception ex) {
        }
        if (count <= 5) {
            if (!txtname.getText().isEmpty()) {
                String statement = "INSERT INTO next(name, clinecname, doctorname, date, time) VALUES "
                        + "('" + txtname.getText() + "', '" + combospecial.getSelectedItem() + "', '" + txtdoctorname.getSelectedItem() + "', "
                        + "'" + Tools.date() + "', '" + Tools.time() + "' ) ;";
                Tools.ExecuteStatement(statement);
                Tools.closeConnection();
            }
            if (txtcode.getText().isEmpty()) {
                if (!txtname.getText().isEmpty() && combospecial.getSelectedIndex() > -1) {
                    String statement = "INSERT INTO patient (name, address, phone, email, birthdate, sex) "
                            + "VALUES('" + txtname.getText() + "', '" + txtaddress.getText() + "', '" + txtphone.getText() + "', '" + txtemail.getText() + "',"
                            + " '" + txtbirthdate.getText() + "', " + combosex.getSelectedIndex() + " ) ;";
                    boolean cheack = Tools.ExecuteStatement(statement);
                    if (cheack) {
                        String id = "";
                        statement = "SELECT id FROM patient ;";
                        rs = Tools.select_query(statement);
                        try {
                            while (rs.next()) {
                                id = rs.getString(1);
                            }
                        } catch (Exception ex) {
                        }
                        statement = "INSERT INTO patientdoctor(patientid, doctorid, price) VALUES (" + id + ", " + iddoctors.get(txtdoctorname.getSelectedIndex()) + ", " + txtvalue.getText() + " ) ;";
                        Tools.ExecuteStatement(statement);

                        statement = "INSERT INTO patientclinic(id, clinicid, visitdate, visitnumber, doctorid, notes) "
                                + "VALUES (" + id + ", " + idclincname.get(combospecial.getSelectedIndex()) + ", '" + txtvisitdate.getText() + "', "
                                + "" + txtvisitnumber.getValue() + ", " + iddoctors.get(txtdoctorname.getSelectedIndex()) + ", '" + txtnotes.getText() + "' );";
                        Tools.ExecuteStatement(statement);

                        int num = Integer.parseInt(String.valueOf(txtvalue.getText()));
                        num -= Integer.parseInt(String.valueOf(txtrest.getText()));
                        statement = "INSERT INTO patientaccounts(id, value, rest) VALUES(" + id + ", " + num + ", " + txtpay.getText() + " ) ;";
                        Tools.ExecuteStatement(statement);

                        for (int i = 0; i < table.getRowCount(); i++) {
                            try {
                                if ((boolean) table.getValueAt(i, 2)) {
                                    statement = "INSERT INTO patientservice(id, name, price) VALUES (" + id + ", '" + table.getValueAt(i, 0) + "', " + table.getValueAt(i, 1) + ") ;";
                                    Tools.ExecuteStatement(statement);
                                }
                            } catch (Exception ex) {
                            }
                        }
                        JOptionPane.showMessageDialog(null, "تمت الاضافه بنجاح");
                        resetValue();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "يجب اضافه اسم المريض  والعياده");
                }
                Tools.closeConnection();
            }
            if (!txtcode.getText().isEmpty()) {
                String statement = "INSERT INTO patientdoctor(patientid, doctorid, price) VALUES (" + txtcode.getText() + ", " + iddoctors.get(txtdoctorname.getSelectedIndex()) + ", " + txtvalue.getText() + " ) ;";
                Tools.ExecuteStatement(statement);

                statement = "INSERT INTO patientclinic(id, clinicid, visitdate, visitnumber, doctorid, notes) "
                        + "VALUES (" + txtcode.getText() + ", " + idclincname.get(combospecial.getSelectedIndex()) + ", '" + txtvisitdate.getText() + "', "
                        + "" + txtvisitnumber.getValue() + ", " + iddoctors.get(txtdoctorname.getSelectedIndex()) + ", '" + txtnotes.getText() + "' );";
                Tools.ExecuteStatement(statement);

                statement = "INSERT INTO patientaccounts(id, value, rest) VALUES(" + txtcode.getText() + ", " + txtvalue.getText() + ", " + txtpay.getText() + " ) ;";
                Tools.ExecuteStatement(statement);

                for (int i = 0; i < table.getRowCount(); i++) {
                    try {
                        if ((boolean) table.getValueAt(i, 2)) {
                            statement = "INSERT INTO patientservice(id, name, price) VALUES (" + txtcode.getText() + ", '" + table.getValueAt(i, 0) + "', " + table.getValueAt(i, 1) + ") ;";
                            Tools.ExecuteStatement(statement);
                        }
                    } catch (Exception ex) {
                    }
                }
                JOptionPane.showMessageDialog(null, "تمت الاضافه بنجاح");
                resetValue();
                Tools.closeConnection();
            }
        } else {
            JOptionPane.showMessageDialog(null, "يجب شراء النسخه الكامله لتهيئه الحد الاستيعابي للبرنامج");
        }
    }//GEN-LAST:event_btnadd1ActionPerformed

    private void txtdoctornameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtdoctornameItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdoctornameItemStateChanged

    private void txtdoctornameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdoctornameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdoctornameActionPerformed

    private void btndelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelete1ActionPerformed
        // TODO add your handling code here:
        if (!txtcode.getText().isEmpty()) {
            boolean cheack = false;
            String statement = "DELETE FROM patientaccounts WHERE id = " + txtcode.getText() + " ;";
            cheack = Tools.ExecuteStatement(statement);
            statement = "DELETE FROM patientservice WHERE id = " + txtcode.getText() + " ;";
            cheack = Tools.ExecuteStatement(statement);
            statement = "DELETE FROM patientclinic WHERE id = " + txtcode.getText() + " ;";
            cheack = Tools.ExecuteStatement(statement);
            statement = "DELETE FROM patient WHERE id = " + txtcode.getText() + " ;";
            cheack = Tools.ExecuteStatement(statement);
            if (cheack) {
                JOptionPane.showMessageDialog(null, "تم الحذف بنجاح");
                resetValue();
            }
            Tools.closeConnection();
        } else {
            JOptionPane.showMessageDialog(null, "يجب اجراء عمليه بحث اولا");
        }
    }//GEN-LAST:event_btndelete1ActionPerformed

    private void btnupdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate1ActionPerformed
        // TODO add your handling code here:
        if (!txtcode.getText().isEmpty()) {
            boolean cheack = false;
            String statement = "UPDATE patientaccounts  SET value = " + txtvalue.getText() + ", rest = " + txtrest.getText() + "  WHERE id = " + txtcode.getText() + " ;";
//            cheack = Tools.ExecuteStatement(statement);
//            statement = "UPDATE patientservice SET name = '"++"'    WHERE id = " + txtcode.getText() + " ;";
//            cheack = Tools.ExecuteStatement(statement);
//            statement = "UPDATE patientclinic SET clinicid = " + idclincname.get(combospecial.getSelectedIndex()) + ", "
//                    + "visitdate = '" + txtvisitdate.getText() + "', visitnumber = " + txtvisitnumber.getValue() + ", "
//                    + "doctorid = " + iddoctors.get(txtdoctorname.getSelectedIndex()) + ", notes = '" + txtnotes.getText() + "' "
//                    + " WHERE id = " + txtcode.getText() + " ;";
//            cheack = Tools.ExecuteStatement(statement);
            statement = "UPDATE patient SET name = '" + txtname.getText() + "', address = '" + txtaddress.getText() + "', "
                    + "phone = '" + txtphone.getText() + "', email = '" + txtemail.getText() + "', birthdate = '" + txtbirthdate.getText() + "', "
                    + "sex = " + combosex.getSelectedIndex() + " "
                    + " WHERE id = " + txtcode.getText() + " ;";
            cheack = Tools.ExecuteStatement(statement);
            if (cheack) {
                JOptionPane.showMessageDialog(null, "تم التعديل بنجاح");
                resetValue();
            }
            Tools.closeConnection();
        } else {
            JOptionPane.showMessageDialog(null, "يجب اجراء عمليه بحث اولا");
        }
    }//GEN-LAST:event_btnupdate1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new InformationPatientAndClient().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        if (!txtsearch.getText().isEmpty()) {
            String statement;
            boolean check = false;
            if (rdname.isSelected()) {
                statement = "SELECT * FROM patient WHERE name = '" + txtsearch.getText() + "' ;";
            } else {
                statement = "SELECT * FROM patient WHERE id = " + txtsearch.getText() + " ;";
            }
            ResultSet rs = Tools.select_query(statement);
            try {
                while (rs.next()) {
                    check = true;
                    txtcode.setText(rs.getString(1));
                    txtname.setText(rs.getString(2));
                    txtaddress.setText(rs.getString(3));
                    txtphone.setText(rs.getString(4));
                    txtemail.setText(rs.getString(5));
                    txtbirthdate.setText(rs.getString(6));
                    combosex.setSelectedIndex(Integer.parseInt(rs.getString(7)));
                }
                if (!txtcode.getText().isEmpty()) {
                    statement = "SELECT visitnumber FROM patientclinic WHERE id = " + txtcode.getText() + " ;";
                    rs = Tools.select_query(statement);
                    Vector<String> v = new Vector();
                    while (rs.next()) {
                        v.add(rs.getString(1));
                    }
                    int num = 0;
                    for (int i = 0; i < v.size(); i++) {
                        if (Integer.parseInt(v.get(i)) > num) {
                            num = Integer.parseInt(v.get(i));
                        }
                    }
                    num++;
                    txtvisitnumber.setValue(num);
                }
                if (!check) {
                    JOptionPane.showMessageDialog(null, "لم يتم العثور على اي معلومات");
                }
            } catch (Exception ex) {
            }
            Tools.closeConnection();
        } else {
            JOptionPane.showMessageDialog(null, "يجب كتابه اسم او كود المريض");
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void txtpayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpayKeyReleased
        // TODO add your handling code here:
        txtrest.setText(String.valueOf(sumrest()));
    }//GEN-LAST:event_txtpayKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        resetValue();
        setItemcombospecial();
        updateTable();
        txtvalue.setText(priceclincname.get(combospecial.getSelectedIndex()));
        gettxtDoctorName();
        txtvisitdate.setText(Tools.date());
        txtsearch.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Tools.setImagePanel();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddressActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd1;
    private javax.swing.JButton btndelete1;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnupdate1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combosex;
    private javax.swing.JComboBox<String> combospecial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdcode;
    private javax.swing.JRadioButton rdname;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtbirthdate;
    private javax.swing.JLabel txtcode;
    private javax.swing.JTextField txtdiscount;
    private javax.swing.JComboBox<String> txtdoctorname;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnotes;
    private javax.swing.JTextField txtpay;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtrest;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtvalue;
    private javax.swing.JTextField txtvisitdate;
    private javax.swing.JSpinner txtvisitnumber;
    // End of variables declaration//GEN-END:variables
}
