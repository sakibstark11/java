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
        turnOffButtons();
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
        updateButtonPurchase = new javax.swing.JButton();
        removeButtonPurchase = new javax.swing.JButton();
        refreshButtonPurchase = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseOrderTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        manufacturerTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        partNumberTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        kanbanSizeIntField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        safetyStockIntField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        createButtonStore = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        updateButtonStore = new javax.swing.JButton();
        removeButtonStore = new javax.swing.JButton();
        refreshButtonStore = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        storeOrderTable = new javax.swing.JTable();
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

        jPanel3.setBackground(new java.awt.Color(48, 63, 159));

        jPanel1.setBackground(new java.awt.Color(21, 101, 192));

        deptCodeTextField.setText("Enter");
        deptCodeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptCodeTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Department code");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Status");

        devAttentionTextField.setText("Enter");
        devAttentionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devAttentionTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Delivery attention");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Completed status");

        statComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ordered", "on-hold", "cancelled", "dispatched", "completed" }));
        statComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statComboBoxActionPerformed(evt);
            }
        });

        compStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "true", "false" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
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

        jLabel5.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Purchase Order");

        createButtonPurchase.setText("Create");
        createButtonPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonPurchaseActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Current Purchase Orders");

        updateButtonPurchase.setText("Update");
        updateButtonPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonPurchaseActionPerformed(evt);
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(createButtonPurchase)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(249, 249, 249)
                                .addComponent(refreshButtonPurchase))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(updateButtonPurchase)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(removeButtonPurchase)))))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButtonPurchase)
                    .addComponent(removeButtonPurchase))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tabs.addTab("Purchase", jPanel3);

        jPanel6.setBackground(new java.awt.Color(48, 63, 159));

        jPanel9.setBackground(new java.awt.Color(21, 101, 192));

        manufacturerTextField.setText("Enter");
        manufacturerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manufacturerTextFieldActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Manufacturer");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Part Number");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));

        partNumberTextField.setText("Enter");
        partNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partNumberTextFieldActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Low Stock Level");

        kanbanSizeIntField.setText("10");
        kanbanSizeIntField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kanbanSizeIntFieldActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Safety Stock Level");

        safetyStockIntField.setText("5");
        safetyStockIntField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                safetyStockIntFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(safetyStockIntField)
                    .addComponent(kanbanSizeIntField)
                    .addComponent(manufacturerTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(partNumberTextField))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manufacturerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(partNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(kanbanSizeIntField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(safetyStockIntField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Store Room Stock");

        createButtonStore.setText("Create");
        createButtonStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonStoreActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Current Stock");

        updateButtonStore.setText("Update");
        updateButtonStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonStoreActionPerformed(evt);
            }
        });

        removeButtonStore.setText("Remove");
        removeButtonStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonStoreActionPerformed(evt);
            }
        });

        refreshButtonStore.setText("Refresh");
        refreshButtonStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonStoreActionPerformed(evt);
            }
        });

        storeOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        storeOrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                storeOrderTableMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(storeOrderTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(createButtonStore))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(refreshButtonStore))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(updateButtonStore)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(removeButtonStore))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(createButtonStore)
                    .addComponent(refreshButtonStore)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButtonStore)
                    .addComponent(removeButtonStore))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tabs.addTab("Store Room", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
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
        keys.add("status");
        keys.add("completedstatus");
        keys.add("departmentcode");
        keys.add("deliveryattention");
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
        performRefresh("purchase",keys,values,columnNames,purchaseOrderTable);
        updateButtonPurchase.setEnabled(true);
        removeButtonPurchase.setEnabled(true);
    }//GEN-LAST:event_refreshButtonPurchaseActionPerformed
    
    private void removeButtonPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonPurchaseActionPerformed
        performRemove(purchaseOrderTable, "purchase"); 
        refreshButtonPurchaseActionPerformed(evt);
    }//GEN-LAST:event_removeButtonPurchaseActionPerformed

    private void updateButtonPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonPurchaseActionPerformed
        performUpdate(purchaseOrderTable, "purchase");
        refreshButtonPurchaseActionPerformed(evt);
    }//GEN-LAST:event_updateButtonPurchaseActionPerformed

    private void createButtonPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonPurchaseActionPerformed
        String stat = statComboBox.getSelectedItem().toString();
        String comp = compStatusComboBox.getSelectedItem().toString();
        String dept = deptCodeTextField.getText();
        String dev  = devAttentionTextField.getText();
        Vector <String> keys = new Vector <> ();
        keys.add("status");
        keys.add("completedstatus");
        keys.add("departmentcode");
        keys.add("deliveryattention");
        Vector <String> values = new Vector <> ();
        values.add(stat);
        values.add(comp);
        values.add(dept);
        values.add(dev);
        this.data.sendObject(this.json.parseJsonIntoString("purchase", keys,values, "create"));
        refreshButtonPurchaseActionPerformed(evt);
        
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

    private void manufacturerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manufacturerTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manufacturerTextFieldActionPerformed

    private void createButtonStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonStoreActionPerformed
        String manufacturer = manufacturerTextField.getText();
        String partNumber = partNumberTextField.getText();
        try {
            int kan = Integer.parseInt(kanbanSizeIntField.getText());
            int safety = Integer.parseInt(safetyStockIntField.getText());
            Vector <String> keys = new Vector <> ();
            keys.add("manufacturer");
            keys.add("manufacturerpartnumber");
            keys.add("kanbansize");
            keys.add("safetylevel");
            Vector <String> values = new Vector <> ();
            values.add(manufacturer);
            values.add(partNumber);
            values.add(String.valueOf(kan));
            values.add(String.valueOf(safety));
            this.data.sendObject(this.json.parseJsonIntoString("store", keys,values, "create"));

        } catch (NumberFormatException e) {
            System.out.println("invalid type");
        }
        refreshButtonStoreActionPerformed(evt);
        
    }//GEN-LAST:event_createButtonStoreActionPerformed

    private void updateButtonStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonStoreActionPerformed
        performUpdate(storeOrderTable, "store");
        refreshButtonStoreActionPerformed(evt);
    }//GEN-LAST:event_updateButtonStoreActionPerformed

    private void removeButtonStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonStoreActionPerformed
        performRemove(storeOrderTable, "store"); 
        refreshButtonStoreActionPerformed(evt);
    }//GEN-LAST:event_removeButtonStoreActionPerformed

    private void refreshButtonStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonStoreActionPerformed
        Vector <String> keys = new Vector <> ();
        keys.add("manufacturer");
        keys.add("manufacturerpartnumber");
        keys.add("kanbansize");
        keys.add("safetylevel");
        Vector <String> values = new Vector <> ();
        values.add("x");
        values.add("x");
        values.add("x");
        values.add("x");
        Vector<String> columnNames = new Vector<>(); // create columns
        columnNames.add("partid");
        columnNames.add("manufacturer");
        columnNames.add("manufacturerpartnumber");
        columnNames.add("kanbansize");
        columnNames.add("safetylevel");
        performRefresh("store",keys,values,columnNames,storeOrderTable);
        updateButtonStore.setEnabled(true);
        removeButtonStore.setEnabled(true);
        
    }//GEN-LAST:event_refreshButtonStoreActionPerformed

    private void storeOrderTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_storeOrderTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_storeOrderTableMousePressed

    private void partNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_partNumberTextFieldActionPerformed

    private void kanbanSizeIntFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kanbanSizeIntFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kanbanSizeIntFieldActionPerformed

    private void safetyStockIntFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_safetyStockIntFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_safetyStockIntFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> compStatusComboBox;
    private javax.swing.JButton createButtonPurchase;
    private javax.swing.JButton createButtonStore;
    private javax.swing.JTextField deptCodeTextField;
    private javax.swing.JTextField devAttentionTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField kanbanSizeIntField;
    private javax.swing.JTextField manufacturerTextField;
    private javax.swing.JTextField partNumberTextField;
    private javax.swing.JTable purchaseOrderTable;
    private javax.swing.JButton refreshButtonPurchase;
    private javax.swing.JButton refreshButtonStore;
    private javax.swing.JButton removeButtonPurchase;
    private javax.swing.JButton removeButtonStore;
    private javax.swing.JTextField safetyStockIntField;
    private javax.swing.JComboBox<String> statComboBox;
    private javax.swing.JTable storeOrderTable;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JButton updateButtonPurchase;
    private javax.swing.JButton updateButtonStore;
    // End of variables declaration//GEN-END:variables

    private void displayTable(JSONArray refreshAray, Vector<String> columnNames, JTable OrderTable) {
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
        OrderTable.setModel(model);
    }
    private void performRefresh(String part, Vector<String> keys, Vector<String> values, Vector<String> columnNames,JTable OrderTable) {
        this.data.sendObject(this.json.parseJsonIntoString(part, keys,values, "refresh"));
        JSONArray refresh = json.parseStringIntoArray(this.data.recieveObject());
        displayTable(refresh,columnNames,OrderTable); // display table
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
    private void turnOffButtons(){
        updateButtonPurchase.setEnabled(false);
        removeButtonPurchase.setEnabled(false);
        updateButtonStore.setEnabled(false);
        removeButtonStore.setEnabled(false);        
    }
    private void performUpdate(JTable OrderTable, String table){
        int index = OrderTable.getSelectedRow();
        JSONObject objectjson = new JSONObject();
        for (int c = 0; c < OrderTable.getColumnCount(); c++ )
        {
            objectjson.put(OrderTable.getColumnName(c),OrderTable.getValueAt(index, c));
        }
        System.out.println("selected "+ objectjson);
        objectjson.put("order",table);
        objectjson.put("command", "update");
        this.data.sendObject(objectjson.toString());
    }
}
