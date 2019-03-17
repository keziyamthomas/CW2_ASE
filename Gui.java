package coffeeshopapp;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Gui extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    DefaultTableModel model;
    HashMap<String, Item> hash;
    LinkedList<Order> orderList;
    ProcessClass processClass ;	
    
 
    public Gui() {
        initComponents();
        model = (DefaultTableModel)orderTable.getModel();
        processClass = new ProcessClass();
        
        //Load the Menu
        processClass.readItems();
        hash = processClass.getItemList();
        
        //Load the unprocessed 
        processClass.readOrder();
        
        //Start servicing the orders
        processClass.startService();
      }

                              
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        newOrderBtn = new javax.swing.JButton();
        hotBeverageBtn = new javax.swing.JButton();
        coldBeveragesBtn = new javax.swing.JButton();
        quickBitesBtn = new javax.swing.JButton();
        shakesBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        addBtn1 = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        itemsCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        quantityTextbox = new javax.swing.JTextField();
        unitPriceLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        totalBtn = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        warningLabel = new javax.swing.JLabel();
        discountLabel = new javax.swing.JLabel();
        discountAmtLabel = new javax.swing.JLabel();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sitka Banner", 3, 24)); // NOI18N
        jLabel1.setText("Cafe Coffee Beans");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        newOrderBtn.setText("New Order");
        newOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrderBtnActionPerformed(evt);
            }
        });

        hotBeverageBtn.setText("Hot Beverages");
        hotBeverageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotBeverageBtnActionPerformed(evt);
            }
        });

        coldBeveragesBtn.setText("Cold Beverages");
        coldBeveragesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coldBeveragesBtnActionPerformed(evt);
            }
        });

        quickBitesBtn.setText("Quick bites");
        quickBitesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quickBitesBtnActionPerformed(evt);
            }
        });

        shakesBtn.setText("Shakes");
        shakesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shakesBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quickBitesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hotBeverageBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(coldBeveragesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shakesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(newOrderBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(newOrderBtn)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hotBeverageBtn)
                    .addComponent(coldBeveragesBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quickBitesBtn)
                    .addComponent(shakesBtn))
                .addGap(0, 57, Short.MAX_VALUE))
        );

        newOrderBtn.getAccessibleContext().setAccessibleName("newOrderBtn");
        hotBeverageBtn.getAccessibleContext().setAccessibleName("hotBeveragesBtn");
        coldBeveragesBtn.getAccessibleContext().setAccessibleName("coldBeveragesBtn");
        quickBitesBtn.getAccessibleContext().setAccessibleName("quickBitesBtn");
        shakesBtn.getAccessibleContext().setAccessibleName("shakesBtn");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        addBtn1.setText("Add");
        addBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn1ActionPerformed(evt);
            }
        });

        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        itemsCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"--Select a category--" }));
        itemsCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemsComboActionPerformed(evt);
            }
        });

        jLabel2.setText("UnitPrice");

        jLabel3.setText("Quantity");

        jLabel4.setText("Select Item");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(addBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantityTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unitPriceLabel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(itemsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(itemsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(unitPriceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(quantityTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn1)
                    .addComponent(editBtn)
                    .addComponent(deleteBtn))
                .addContainerGap())
        );

        deleteBtn.getAccessibleContext().setAccessibleName("addBtn");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Item Name", "Unit Price", "Quantity"
            }
        ));
        orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(orderTable);
        orderTable.getAccessibleContext().setAccessibleName("orderTable");

        
        totalBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalBtn.setText("Total");
        totalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalBtnActionPerformed(evt);
            }
        });

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        warningLabel.setForeground(new java.awt.Color(255, 0, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(totalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalLabel)
                .addGap(120, 120, 120))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalBtn)
                    .addComponent(totalLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        discountLabel.setText("Discount");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(discountLabel)
                    .addGap(62, 62, 62)
                    .addComponent(discountAmtLabel)
                    .addGap(142, 142, 142))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(warningLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountLabel)
                    .addComponent(discountAmtLabel))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try{model.removeRow(orderTable.getSelectedRow());}catch(Exception e) {}
        quantityTextbox.setText(null);
        for(int i=0;i<model.getRowCount();i++)
        {
        	model.setValueAt(i+1, i, 0);
        }
       
        
    }                                         

    private void addBtn1ActionPerformed(java.awt.event.ActionEvent evt) { 
    	int x;
    	totalLabel.setText(null);
        discountAmtLabel.setText(null);
    	try {
    		x = Integer.parseInt((String) quantityTextbox.getText());
    	}
    	catch(Exception e) {
    		x = 1;
    	}
    	if(itemsCombo.getSelectedItem()!="--Select a category--")
    	{
    	if(x < 10 ) {
            model.insertRow(model.getRowCount(),new Object[]{model.getRowCount()+1,
            		itemsCombo.getSelectedItem(),
            		unitPriceLabel.getText(),
            		Integer.toString(x)});
       	}
    	else {
    		warningLabel.setText("Quantity should be less than 10!!!");
    		quantityTextbox.setText(null);
    	}
    	}
    }                                               

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {
    	try
    	{
        int x = Integer.parseInt((String) quantityTextbox.getText());
    	if(x < 10 ) {
    		model.setValueAt(quantityTextbox.getText(), orderTable.getSelectedRow(),3);
       	}
    	else {
    		warningLabel.setText("Quantity should be less than 10!!!");
    		quantityTextbox.setText(null);
    	}
    	}
    	catch(Exception e) {}

    }                                       

    private void orderTableMouseClicked(java.awt.event.MouseEvent evt) {                                        
        itemsCombo.setSelectedItem(model.getValueAt(orderTable.getSelectedRow(), 1));
        unitPriceLabel.setText(model.getValueAt(orderTable.getSelectedRow(), 2).toString());
        quantityTextbox.setText(model.getValueAt(orderTable.getSelectedRow(), 3).toString());
    }                                       

    private void totalBtnActionPerformed(java.awt.event.ActionEvent evt) {  
        /**
        * Display the total amount 
        */
    	orderList = new LinkedList<Order>();
        int total = 0, quantity = 0 ;
        double unitPrice = 0;
        double discountAmt=0;
        Discount discount = new Discount();
        
                
        for (int i = 0; i < orderTable.getRowCount(); i++){
            quantity = Integer.parseInt((String) orderTable.getValueAt(i, 3));
            unitPrice = Double.parseDouble((String) orderTable.getValueAt(i, 2));
            total += quantity * unitPrice;
        }
        
        orderList=getCurrentOrderList();
        discountAmt = discount.calculateDiscount((double)total,orderList);
        totalLabel.setText(Double.toString((double)total - discountAmt));
        discountAmtLabel.setText(Double.toString(discountAmt));
        processClass.addOrder(orderList);
    }                                        

    private void hotBeverageBtnActionPerformed(java.awt.event.ActionEvent evt) {                                               
    	List<String> list = processClass.getItemsByCategory("HotBeverage");
    	DefaultComboBoxModel<String> df = new DefaultComboBoxModel<String>();
    	for(String str: list) {
    		df.addElement(str);
    	}
    	itemsCombo.setModel(df);
    	unitPriceLabel.setText(Double.toString(processClass.getUnitPriceByItemName(itemsCombo.getSelectedItem().toString())));
    	
    }                                              

    private void itemsComboActionPerformed(java.awt.event.ActionEvent evt) {                              
    	Double var = (processClass.getUnitPriceByItemName(itemsCombo.getSelectedItem().toString()));
    	String s = Double.toString(var);
    	unitPriceLabel.setText(s);
    	quantityTextbox.setText("1");
    }                                          

    private void newOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {                                            
        quantityTextbox.setText(null);
        totalLabel.setText(null);
        discountAmtLabel.setText(null);
        model.setRowCount(0);
    }                                           

    private void shakesBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	List<String> list = processClass.getItemsByCategory("Shake");
    	DefaultComboBoxModel<String> df = new DefaultComboBoxModel<String>();
    	for(String str: list) {
    		df.addElement(str);
    	}
    	itemsCombo.setModel(df);
    	unitPriceLabel.setText(Double.toString(processClass.getUnitPriceByItemName(itemsCombo.getSelectedItem().toString())));
        
    }                                         

    private void coldBeveragesBtnActionPerformed(java.awt.event.ActionEvent evt) {                                                 
    	List<String> list = processClass.getItemsByCategory("ColdBeverage");
    	DefaultComboBoxModel<String> df = new DefaultComboBoxModel<String>();
    	for(String str: list) {
    		df.addElement(str);
    	}
    	itemsCombo.setModel(df);
    	unitPriceLabel.setText(Double.toString(processClass.getUnitPriceByItemName(itemsCombo.getSelectedItem().toString())));
  
    }                                                

    private void quickBitesBtnActionPerformed(java.awt.event.ActionEvent evt) {                                              
        List<String> list = processClass.getItemsByCategory("Quick bites");
    	DefaultComboBoxModel<String> df = new DefaultComboBoxModel<String>();
    	for(String str: list) {
    		df.addElement(str);
      	}
    	itemsCombo.setModel(df);
    	unitPriceLabel.setText(Double.toString(processClass.getUnitPriceByItemName(itemsCombo.getSelectedItem().toString())));
    }   
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        // Generate Report
    	processClass.populateReportList();
    	processClass.WriteToFile();
    }   
    
    public void saveOrderToList(Timestamp time, String custId, String item, int quantity, double amount)
    {
    	/* save the order to the linked list of current orderList */
    	try
    	{
    	Order order = new Order(time,custId,item,quantity,amount);
        orderList.add(order);
    	}
    	catch(PatternException pe) {
			JOptionPane.showMessageDialog(null, pe.getMessage());
		}
    }
    
    public LinkedList<Order> getCurrentOrderList()
    {
        // Iterate through the table and add return the full order as list
    	for (int row=0; row < orderTable.getRowCount(); row++) {
    		Timestamp time = new Timestamp(System.currentTimeMillis());
    		String custId = processClass.generateOrderId();
    		String item = processClass.getItemIdByItemName(orderTable.getValueAt(row, 1).toString());
    		int quantity = Integer.parseInt((String) orderTable.getValueAt(row, 3));
    		double amount = Double.parseDouble((String) orderTable.getValueAt(row, 2))*quantity;
    		saveOrderToList(time,custId,item,quantity,amount);
    	}
    	return orderList;
    		   
    }

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
               
            }
           
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton addBtn1;
    private javax.swing.JButton coldBeveragesBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel discountAmtLabel;
    private javax.swing.JLabel discountLabel;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton hotBeverageBtn;
    private javax.swing.JComboBox<String> itemsCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newOrderBtn;
    private javax.swing.JTable orderTable;
    private javax.swing.JTextField quantityTextbox;
    private javax.swing.JButton quickBitesBtn;
    private javax.swing.JButton shakesBtn;
    private javax.swing.JButton totalBtn;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel unitPriceLabel;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration                   
}
