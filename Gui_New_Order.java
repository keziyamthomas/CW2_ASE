/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;
import controller.*;

public class Gui_New_Order extends javax.swing.JFrame {

    /**
     * Creates new form Gui_New_Order
     */
	DefaultTableModel model;
    HashMap<String, Item> hash;
    LinkedList<Order> orderList;
    static ProcessClass processClass ;
    
    public Gui_New_Order() {
        initComponents();
        model = (DefaultTableModel)jTable_order.getModel();
        processClass = new ProcessClass();
        
        //Load the Menu
        processClass.readItems();
        hash = processClass.getItemList();
        
        //Load the unprocessed 
        processClass.readOrder();
        
              
        //Start servicing the orders
        processClass.startService();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton_hot_beverage = new javax.swing.JButton();
        jButton_cold_beverage = new javax.swing.JButton();
        jButton_quick_bites = new javax.swing.JButton();
        jButton_shakes = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_items = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel_unit_price = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_quantity = new javax.swing.JTextField();
        jButton_add = new javax.swing.JButton();
        jButton_edit = new javax.swing.JButton();
        jButton_remove = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jCheckBox_online = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_order = new javax.swing.JTable();
        jButton_add_to_queue = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel_total = new javax.swing.JLabel();
        jLabel_discount = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel_warning_msg = new javax.swing.JLabel();
        jButton_new_order = new javax.swing.JButton();
        jButton_view = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        setLocation(new java.awt.Point(0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Cafe Coffee Beans");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Categories");

        jButton_hot_beverage.setText("Hot Beverages");
        jButton_hot_beverage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_hot_beverageActionPerformed(evt);
            }
        });

        jButton_cold_beverage.setText("Cold Beverages");
        jButton_cold_beverage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cold_beverageActionPerformed(evt);
            }
        });

        jButton_quick_bites.setText("Quick Bites");
        jButton_quick_bites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_quick_bitesActionPerformed(evt);
            }
        });

        jButton_shakes.setText("Shakes");
        jButton_shakes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_shakesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_hot_beverage, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_quick_bites, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_shakes, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cold_beverage, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_cold_beverage)
                    .addComponent(jButton_hot_beverage, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_shakes)
                    .addComponent(jButton_quick_bites))
                .addGap(0, 62, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel3.setText("Select Item");

        jComboBox_items.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"--Select a category--" }));
        jComboBox_items.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_itemsActionPerformed(evt);
            }
        });

        jLabel4.setText("Unit Price");

        jLabel_unit_price.setText(" ");

        jLabel6.setText("Quantity");

        jTextField_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_quantityActionPerformed(evt);
            }
        });

        jButton_add.setText("Add");
        jButton_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addActionPerformed(evt);
            }
        });

        jButton_edit.setText("Edit");
        jButton_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_editActionPerformed(evt);
            }
        });

        jButton_remove.setText("Remove");
        jButton_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_removeActionPerformed(evt);
            }
        });

        jLabel11.setText("Online Order");

        jCheckBox_online.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_onlineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jButton_add, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addGap(60, 60, 60)
                            .addComponent(jButton_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(63, 63, 63)
                            .addComponent(jButton_remove))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField_quantity))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBox_items, 0, 249, Short.MAX_VALUE)
                                .addComponent(jLabel_unit_price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox_online)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox_items, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel_unit_price))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jCheckBox_online))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_add)
                    .addComponent(jButton_edit)
                    .addComponent(jButton_remove))
                .addGap(23, 23, 23))
        );

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTable_order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "#No", "Item", "Unit Price", "Quantity", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            @Override
            public boolean isCellEditable(int row, int column) {
            	return column == 3 ? true : false ;
            }
            
        });
        jTable_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_orderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_order);

        jButton_add_to_queue.setText("Confirm Order");
        jButton_add_to_queue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add_to_queueActionPerformed(evt);
            }
        });

        jLabel7.setText("Total");

        jLabel8.setText("Discount");

        jLabel_total.setText(" ");

        jLabel_discount.setText(" ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(562, 562, 562)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel_discount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(156, 156, 156))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel_total, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jButton_add_to_queue)))
                .addGap(0, 50, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel_total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel_discount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_add_to_queue)
                .addGap(24, 24, 24))
        );

        jLabel_warning_msg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_warning_msg.setForeground(new java.awt.Color(204, 0, 102));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_warning_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel_warning_msg)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jButton_new_order.setText("New Order");
        jButton_new_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_new_orderActionPerformed(evt);
            }
        });
        
        jButton_view.setText("Update Staff / View Status");
        jButton_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_viewActionPerformed(evt);
            }
        });

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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jButton_new_order, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton_view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(58, 58, 58)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 18, Short.MAX_VALUE)))
                    .addContainerGap())
            );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(60, 60, 60)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(36, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton_new_order)
                                .addComponent(jButton_view))
                            .addGap(28, 28, 28))))
            );

        pack();
    }// </editor-fold>                        

    private void jButton_add_to_queueActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // Add to Queue
        processClass.addOrder(orderList);
        
    }                                                    

    private void jButton_hot_beverageActionPerformed(java.awt.event.ActionEvent evt) {                                                     
    	List<String> list = processClass.getItemsByCategory("HotBeverage");
    	DefaultComboBoxModel<String> df = new DefaultComboBoxModel<String>();
    	for(String str: list) {
    		df.addElement(str);
    	}
    	jComboBox_items.setModel(df);
    	jLabel_unit_price.setText(Double.toString(processClass.getUnitPriceByItemName(jComboBox_items.getSelectedItem().toString())));
    	
    }                                                    

    private void jButton_cold_beverageActionPerformed(java.awt.event.ActionEvent evt) {                                                      
    	List<String> list = processClass.getItemsByCategory("ColdBeverage");
    	DefaultComboBoxModel<String> df = new DefaultComboBoxModel<String>();
    	for(String str: list) {
    		df.addElement(str);
    	}
    	jComboBox_items.setModel(df);
    	jLabel_unit_price.setText(Double.toString(processClass.getUnitPriceByItemName(jComboBox_items.getSelectedItem().toString())));
  
    }                                                     

    private void jButton_quick_bitesActionPerformed(java.awt.event.ActionEvent evt) {                                                    
    	List<String> list = processClass.getItemsByCategory("Quick bites");
    	DefaultComboBoxModel<String> df = new DefaultComboBoxModel<String>();
    	for(String str: list) {
    		df.addElement(str);
      	}
    	jComboBox_items.setModel(df);
    	jLabel_unit_price.setText(Double.toString(processClass.getUnitPriceByItemName(jComboBox_items.getSelectedItem().toString())));
    }                                                   

    private void jButton_shakesActionPerformed(java.awt.event.ActionEvent evt) {                                               
    	List<String> list = processClass.getItemsByCategory("Shake");
    	DefaultComboBoxModel<String> df = new DefaultComboBoxModel<String>();
    	for(String str: list) {
    		df.addElement(str);
    	}
    	jComboBox_items.setModel(df);
    	jLabel_unit_price.setText(Double.toString(processClass.getUnitPriceByItemName(jComboBox_items.getSelectedItem().toString())));
        
    }                                              

    private void jTextField_quantityActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    private void jCheckBox_onlineActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if(jCheckBox_online.isSelected()) {
        	ProcessClass.online = true;
        }
        else {
        	ProcessClass.online = false;
        }
    }                                                

    private void jComboBox_itemsActionPerformed(java.awt.event.ActionEvent evt) {                                                
    	Double var = (processClass.getUnitPriceByItemName(jComboBox_items.getSelectedItem().toString()));
    	String s = Double.toString(var);
    	jLabel_unit_price.setText(s);
    	jTextField_quantity.setText("1");
    }                                               

    private void jButton_addActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	int x;
    	jLabel_total.setText(null);
        jLabel_discount.setText(null);
    	try {
    		x = Integer.parseInt((String) jTextField_quantity.getText());
    	}
    	catch(Exception e) {
    		x = 1;
    	}
    	if(jComboBox_items.getSelectedItem()!="--Select a category--")
    	{
    	if(x < 10 ) {
            model.insertRow(model.getRowCount(),new Object[]{model.getRowCount()+1,
            		jComboBox_items.getSelectedItem(),
            		jLabel_unit_price.getText(),
            		Integer.toString(x)});
       	}
    	else {
    		jLabel_warning_msg.setText("Quantity should be less than 10!!!");
    		jTextField_quantity.setText(null);
    	}
    	}
    	jTextField_quantity.setText(null);
    	//Display total
    	calculate_total();
    }                                           

    private void jButton_editActionPerformed(java.awt.event.ActionEvent evt) {                                             
    	try
    	{
        int x = Integer.parseInt((String) jTextField_quantity.getText());
    	if(x < 10 ) {
    		model.setValueAt(jTextField_quantity.getText(), jTable_order.getSelectedRow(),3);
       	}
    	else {
    		jLabel_warning_msg.setText("Quantity should be less than 10!!!");
    		jTextField_quantity.setText(null);
    	}
    	}
    	catch(Exception e) {}
    }                                            

    private void jButton_removeActionPerformed(java.awt.event.ActionEvent evt) {                                               
    	try{model.removeRow(jTable_order.getSelectedRow());}catch(Exception e) {}
        jTextField_quantity.setText(null);
        for(int i=0;i<model.getRowCount();i++)
        {
        	model.setValueAt(i+1, i, 0);
        }
    }  
    
    private void jTable_orderMouseClicked(java.awt.event.MouseEvent evt) {                                          
    	jComboBox_items.setSelectedItem(model.getValueAt(jTable_order.getSelectedRow(), 1));
        jLabel_unit_price.setText(model.getValueAt(jTable_order.getSelectedRow(), 2).toString());
        jTextField_quantity.setText(model.getValueAt(jTable_order.getSelectedRow(), 3).toString());
    } 
    
    private void jButton_new_orderActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    	jTextField_quantity.setText(null);
        jLabel_total.setText(null);
        jLabel_discount.setText(null);
        model.setRowCount(0);
    }  
    
    private void jButton_viewActionPerformed(java.awt.event.ActionEvent evt) {                                             
        Gui_2 view = new Gui_2();
        view.setVisible(true);
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        // Generate Report
    	processClass.populateReportList();
    	processClass.WriteToFile();
    	String report_text = processClass.generateReport();
    	Gui_Report report = new Gui_Report(report_text);
    	report.setVisible(true);
    	
    }
    
    private void calculate_total() {
    	/**
         * Display the total amount 
         */
     	orderList = new LinkedList<Order>();
         int total = 0, quantity = 0 ;
         double unitPrice = 0;
         double discountAmt=0;
         Discount discount = new Discount();
         
                 
         for (int i = 0; i < jTable_order.getRowCount(); i++){
             quantity = Integer.parseInt((String) jTable_order.getValueAt(i, 3));
             unitPrice = Double.parseDouble((String) jTable_order.getValueAt(i, 2));
             total += quantity * unitPrice;
         }
         
         orderList=getCurrentOrderList();
         discountAmt = discount.calculateDiscount((double)total,orderList);
         jLabel_total.setText(Double.toString((double)total - discountAmt));
         jLabel_discount.setText(Double.toString(discountAmt));
         
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
    	for (int row=0; row < jTable_order.getRowCount(); row++) {
    		Timestamp time = new Timestamp(System.currentTimeMillis());
    		String custId = processClass.generateOrderId();
    		String item = processClass.getItemIdByItemName(jTable_order.getValueAt(row, 1).toString());
    		int quantity = Integer.parseInt((String) jTable_order.getValueAt(row, 3));
    		double amount = Double.parseDouble((String) jTable_order.getValueAt(row, 2))*quantity;
    		saveOrderToList(time,custId,item,quantity,amount);
    	}
    	return orderList;
    		   
    }
    

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
            java.util.logging.Logger.getLogger(Gui_New_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_New_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_New_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_New_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_New_Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton_add;
    private javax.swing.JButton jButton_add_to_queue;
    private javax.swing.JButton jButton_cold_beverage;
    private javax.swing.JButton jButton_edit;
    private javax.swing.JButton jButton_hot_beverage;
    private javax.swing.JButton jButton_new_order;
    private javax.swing.JButton jButton_view;
    private javax.swing.JButton jButton_quick_bites;
    private javax.swing.JButton jButton_remove;
    private javax.swing.JButton jButton_shakes;
    private javax.swing.JCheckBox jCheckBox_online;
    private javax.swing.JComboBox<String> jComboBox_items;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_discount;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_total;
    private javax.swing.JLabel jLabel_unit_price;
    private javax.swing.JLabel jLabel_warning_msg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_order;
    private javax.swing.JTextField jTextField_quantity;
    // End of variables declaration                   
}
