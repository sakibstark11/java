package clientPackage;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.json.JSONArray;
import org.json.JSONObject;
 
public class ClientGUI extends javax.swing.JFrame {
ClientConnection data;
public JsonParsing json = new JsonParsing();
String hyphen = "-";
    public ClientGUI() {
        initComponents();
        this.data = new ClientConnection("localhost", 1999);
        this.data.connect();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        tabs = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        deptCodeTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        devAttentionTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        statComboBox = new javax.swing.JComboBox<>();
        compStatusComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        createButtonPurchase = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        removeButtonPurchase = new javax.swing.JButton();
        refreshButtonPurchase = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseOrderTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        createButtonPurchase1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        purchaseOrderTable1 = new javax.swing.JTable();
        refreshButtonPurchase1 = new javax.swing.JButton();
        updateButton1 = new javax.swing.JButton();
        modifyButton1 = new javax.swing.JButton();
        removeButtonPurchase1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        deptCodeTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        devAttentionTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        statComboBox1 = new javax.swing.JComboBox<>();
        compStatusComboBox1 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Cambria Math", 0, 12)); // NOI18N

        jPanel2.setPreferredSize(new java.awt.Dimension(268, 120));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tabs.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel1.setBackground(new java.awt.Color(169, 169, 169));

        deptCodeTextField.setText("Enter");
        deptCodeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptCodeTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Department code");

        jLabel2.setText("Status");

        devAttentionTextField.setText("Enter");
        devAttentionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devAttentionTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Delivery attention");

        jLabel4.setText("Completed status");

        statComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ordered", "on-hold", "cancelled", "dispatched", "completed" }));
        statComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statComboBoxActionPerformed(evt);
            }
        });

        compStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "yes", "no" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(devAttentionTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deptCodeTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statComboBox, 0, 120, Short.MAX_VALUE)
                    .addComponent(compStatusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deptCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(statComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(devAttentionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(compStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel5.setText("Purchase Order");

        createButtonPurchase.setText("Create");
        createButtonPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonPurchaseActionPerformed(evt);
            }
        });

        jLabel6.setText("Current Purchase Orders");

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        modifyButton.setText("Modify");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        removeButtonPurchase.setText("Remove");
        removeButtonPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonPurchaseActionPerformed(evt);
            }
        });

        refreshButtonPurchase.setText("Refresh");
        refreshButtonPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonPurchaseActionPerformed(evt);
            }
        });

        purchaseOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        purchaseOrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                purchaseOrderTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(purchaseOrderTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(createButtonPurchase)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshButtonPurchase))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(updateButton)
                                .addGap(18, 18, 18)
                                .addComponent(modifyButton)
                                .addGap(18, 18, 18)
                                .addComponent(removeButtonPurchase))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(createButtonPurchase)
                    .addComponent(refreshButtonPurchase)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(modifyButton)
                    .addComponent(removeButtonPurchase))
                .addContainerGap())
        );

        tabs.addTab("Purchase", jPanel3);

        jLabel7.setText("Store room Stock");

        createButtonPurchase1.setText("Create");
        createButtonPurchase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonPurchase1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Current Store room shelf");

        purchaseOrderTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        purchaseOrderTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                purchaseOrderTable1MousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(purchaseOrderTable1);

        refreshButtonPurchase1.setText("Refresh");
        refreshButtonPurchase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonPurchase1ActionPerformed(evt);
            }
        });

        updateButton1.setText("Update");
        updateButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton1ActionPerformed(evt);
            }
        });

        modifyButton1.setText("Modify");
        modifyButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButton1ActionPerformed(evt);
            }
        });

        removeButtonPurchase1.setText("Remove");
        removeButtonPurchase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonPurchase1ActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(169, 169, 169));

        deptCodeTextField1.setText("Enter");
        deptCodeTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptCodeTextField1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Department code");

        jLabel10.setText("Status");

        devAttentionTextField1.setText("Enter");
        devAttentionTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devAttentionTextField1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Delivery attention");

        jLabel12.setText("Completed status");

        statComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ordered", "on-hold", "cancelled", "dispatched", "completed" }));
        statComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statComboBox1ActionPerformed(evt);
            }
        });

        compStatusComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "yes", "no" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(18, 52, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(devAttentionTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deptCodeTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statComboBox1, 0, 120, Short.MAX_VALUE)
                    .addComponent(compStatusComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deptCodeTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(statComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(devAttentionTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(compStatusComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(createButtonPurchase1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshButtonPurchase1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(updateButton1)
                                .addGap(18, 18, 18)
                                .addComponent(modifyButton1)
                                .addGap(18, 18, 18)
                                .addComponent(removeButtonPurchase1))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(createButtonPurchase1)
                    .addComponent(refreshButtonPurchase1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton1)
                    .addComponent(modifyButton1)
                    .addComponent(removeButtonPurchase1))
                .addContainerGap())
        );

        tabs.addTab("Store Room", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 758, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        tabs.addTab("Purchase Order Line", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
        );

        tabs.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonPurchaseActionPerformed
        Vector <String> keys = new Vector <> ();
        keys.add("stat");
        keys.add("comp");
        keys.add("dept");
        keys.add("dev");
        Vector <String> values = new Vector <> ();
        values.add("x");
        values.add("x");
        values.add("x");
        values.add("x");
        Vector<String> columnNames = new Vector<>(); // create columns
        columnNames.add("purchaseid");
        columnNames.add("departmentcode");
        columnNames.add("deliveryattention");
        columnNames.add("completedstatus");
        columnNames.add("status");
        performRefresh("purchase",keys,values,columnNames);
    }//GEN-LAST:event_refreshButtonPurchaseActionPerformed
    
    private void removeButtonPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonPurchaseActionPerformed
        performRemove(purchaseOrderTable, "purchase");        
    }//GEN-LAST:event_removeButtonPurchaseActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed

    }//GEN-LAST:event_updateButtonActionPerformed

    private void createButtonPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonPurchaseActionPerformed
        String stat = statComboBox.getSelectedItem().toString();
        String comp = compStatusComboBox.getSelectedItem().toString();
        String dept = deptCodeTextField.getText();
        String dev  = devAttentionTextField.getText();
        Vector <String> keys = new Vector <> ();
        keys.add("stat");
        keys.add("comp");
        keys.add("dept");
        keys.add("dev");
        Vector <String> values = new Vector <> ();
        values.add(stat);
        values.add(comp);
        values.add(dept);
        values.add(dev);
        this.data.sendObject(this.json.parseJsonIntoString("purchase", keys,values, "create"));
    }//GEN-LAST:event_createButtonPurchaseActionPerformed

    private void statComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statComboBoxActionPerformed

    private void devAttentionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devAttentionTextFieldActionPerformed
        
    }//GEN-LAST:event_devAttentionTextFieldActionPerformed

    private void deptCodeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptCodeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deptCodeTextFieldActionPerformed

    private void purchaseOrderTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseOrderTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseOrderTableMousePressed

    private void createButtonPurchase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonPurchase1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createButtonPurchase1ActionPerformed

    private void purchaseOrderTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseOrderTable1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseOrderTable1MousePressed

    private void refreshButtonPurchase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonPurchase1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshButtonPurchase1ActionPerformed

    private void updateButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton1ActionPerformed

    private void modifyButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modifyButton1ActionPerformed

    private void removeButtonPurchase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonPurchase1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeButtonPurchase1ActionPerformed

    private void deptCodeTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptCodeTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deptCodeTextField1ActionPerformed

    private void devAttentionTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devAttentionTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_devAttentionTextField1ActionPerformed

    private void statComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> compStatusComboBox;
    private javax.swing.JComboBox<String> compStatusComboBox1;
    private javax.swing.JButton createButtonPurchase;
    private javax.swing.JButton createButtonPurchase1;
    private javax.swing.JTextField deptCodeTextField;
    private javax.swing.JTextField deptCodeTextField1;
    private javax.swing.JTextField devAttentionTextField;
    private javax.swing.JTextField devAttentionTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton modifyButton1;
    private javax.swing.JTable purchaseOrderTable;
    private javax.swing.JTable purchaseOrderTable1;
    private javax.swing.JButton refreshButtonPurchase;
    private javax.swing.JButton refreshButtonPurchase1;
    private javax.swing.JButton removeButtonPurchase;
    private javax.swing.JButton removeButtonPurchase1;
    private javax.swing.JComboBox<String> statComboBox;
    private javax.swing.JComboBox<String> statComboBox1;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton updateButton1;
    // End of variables declaration//GEN-END:variables

    private void displayTable(JSONArray refreshAray,Vector<String> columnNames) {
        Vector<Vector<String>> dataList = new Vector<>();
        for (int x = 0; x <refreshAray.length(); x++){
            JSONObject jsonTable = refreshAray.getJSONObject(x);
            Vector <String> data = new Vector <> ();
            for(int y = 0; y < columnNames.size();y++)          
            {data.add(jsonTable.getString(columnNames.get(y)));
            }
            dataList.add(data);
        }
        System.out.println(dataList);
        DefaultTableModel model = new DefaultTableModel(dataList,columnNames); ;              
        purchaseOrderTable.setModel(model);
    }

    private void performRefresh(String part, Vector<String> keys, Vector<String> values, Vector<String> columnNames) {
        this.data.sendObject(this.json.parseJsonIntoString(part, keys,values, "refresh"));
        JSONArray refresh = json.parseStringIntoArray(this.data.recieveObject());
        displayTable(refresh,columnNames); // display table
    }

    private void performRemove(JTable OrderTable, String table) {
        int index = OrderTable.getSelectedRow();
        JSONObject objectjson = new JSONObject();
        for (int c = 0; c < OrderTable.getColumnCount(); c++ )
        {
            objectjson.put(OrderTable.getColumnName(c),OrderTable.getValueAt(index, c));
        }
        System.out.println("selected "+ objectjson);
        objectjson.put("order",table);
        objectjson.put("command", "delete");
        this.data.sendObject(objectjson.toString());
    }
}
