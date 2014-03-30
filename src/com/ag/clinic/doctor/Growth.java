/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.clinic.doctor;

import com.ag.clinic.DB.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author osama
 */
public class Growth extends javax.swing.JPanel {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private DefaultTableModel model;
    private final int patientId;

    private enum button {

        add, edit
    };
    private button selectedButton;
    private DateFormat format;

    public Growth(int id) {
        initComponents();
        patientId = id;
        viewPanel.setVisible(true);
        editPanel.setVisible(false);

        format = new SimpleDateFormat("yyyy-MM-dd");
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(0);
        tcm.getColumn(1).setPreferredWidth(0);
        model = (DefaultTableModel) table.getModel();
        setName();
        setData();

        bDelete.setEnabled(false);
        bEdit.setEnabled(false);
    }

    private void setName() {
        try {
            String query = "SELECT patient_name FROM patient WHERE patient_id = " + patientId
                    + " LIMIT 1";
            con = new DB().getMySqlConn();
            st = con.createStatement();
            rs = st.executeQuery(query);
            rs.absolute(1);
            lName.setText(rs.getString("patient_name"));
            lID.setText(String.valueOf(patientId));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void setData() {
        try {
            con = new DB().getMySqlConn();
            st = con.createStatement();

            String query = "SELECT * FROM patient_growth WHERE patient_id = " + patientId;
            rs = st.executeQuery(query);
            while (rs.next()) {
                DateFormat fromat = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println("row inserted");

                model.addRow(new Object[]{
                    rs.getInt("growth_id"), rs.getInt("weight"), fromat.format(rs.getDate("date")),
                    rs.getString("hc")
                });
            }

        } catch (SQLException ex) {
            System.out.println("exception setting the data");
            ex.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TaHc = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TfWeight = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bConfirm = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        DateChooser = new com.toedter.calendar.JDateChooser();
        viewPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        bAdd = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lName = new javax.swing.JLabel();
        lID = new javax.swing.JLabel();

        TaHc.setColumns(20);
        TaHc.setRows(5);
        jScrollPane1.setViewportView(TaHc);

        jLabel5.setText("hc:");

        jLabel3.setText("weight:");

        jLabel4.setText("date:");

        bConfirm.setText("confirm");
        bConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConfirmActionPerformed(evt);
            }
        });

        bCancel.setText("cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editPanelLayout = new javax.swing.GroupLayout(editPanel);
        editPanel.setLayout(editPanelLayout);
        editPanelLayout.setHorizontalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editPanelLayout.createSequentialGroup()
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(64, 64, 64)
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(editPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(96, 96, 96)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCancel)
                .addGap(18, 18, 18)
                .addComponent(bConfirm)
                .addContainerGap())
        );
        editPanelLayout.setVerticalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TfWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancel)
                    .addComponent(bConfirm))
                .addGap(31, 31, 31))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "growth ID", "weight", "date", "hc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        table.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        bAdd.setText("add");
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });

        bEdit.setText("edit");
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });

        bDelete.setText("delete");
        bDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bDeleteMouseReleased(evt);
            }
        });
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        jLabel1.setText("patient name:");

        jLabel2.setText("patient D:");

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bEdit)
                .addGap(12, 12, 12)
                .addComponent(bDelete)
                .addContainerGap())
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewPanelLayout.createSequentialGroup()
                        .addComponent(lName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(96, 96, 96))
                    .addGroup(viewPanelLayout.createSequentialGroup()
                        .addComponent(lID, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAdd)
                    .addComponent(bEdit)
                    .addComponent(bDelete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lID, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(editPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(editPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableFocusGained
        bDelete.setEnabled(true);
        bEdit.setEnabled(true);
    }//GEN-LAST:event_tableFocusGained

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        try {
            // remove the data from the database
            int growthId = (int) model.getValueAt(table.getSelectedRow(), 0);
            con = new DB().getMySqlConn();
            try {
                st = con.createStatement();
                String query = "DELETE FROM patient_growth WHERE growth_id = " + growthId;
                st.executeUpdate(query);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            // remove the data from the table
            int row = table.getSelectedRow();
            model.removeRow(row);

//        bDelete.setEnabled(false);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "please choose data to delete", "warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bDeleteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bDeleteMouseReleased
    }//GEN-LAST:event_bDeleteMouseReleased

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        viewPanel.setVisible(false);
        editPanel.setVisible(true);
        selectedButton = button.add;

        DateChooser.setDate(new Date());
    }//GEN-LAST:event_bAddActionPerformed

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        editPanel.setVisible(false);
        viewPanel.setVisible(true);
    }//GEN-LAST:event_bCancelActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        TfWeight.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 1)));
        try {
            DateChooser.setDate(format.parse(String.valueOf(model.getValueAt(table.getSelectedRow(), 2))));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        TaHc.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 3)));

        viewPanel.setVisible(false);
        editPanel.setVisible(true);
        selectedButton = button.edit;
    }//GEN-LAST:event_bEditActionPerformed

    private void bConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConfirmActionPerformed
        // dicide to save or update
        if (selectedButton == button.add) {
            try {
                // add data to the table and the database
                // adding data to the database
                con = new DB().getMySqlConn();
                st = con.createStatement();

                String query = "INSERT INTO patient_growth (weight, date, hc, patient_id) "
                        + "VALUES (" + Float.parseFloat(TfWeight.getText()) + ", '"
                        + format.format(DateChooser.getDate()) + "', '" + TaHc.getText() + "', " + patientId + ")";
                st.executeUpdate(query);

                // adding data to the table
//                get the new id inserted
                query = "Select growth_id FROM patient_growth ORDER BY growth_id DESC LIMIT 1";
                rs = st.executeQuery(query);
                rs.absolute(1);
                int growthId = rs.getInt("growth_id");
                model.addRow(new Object[]{
                    growthId, Float.parseFloat(TfWeight.getText()), format.format(DateChooser.getDate()), TaHc.getText()
                });

                editPanel.setVisible(false);
                viewPanel.setVisible(true);
                TfWeight.setText(null);
                TaHc.setText(null);
            } catch (SQLException ex) {
                System.out.println("exception adding");
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "please select a valid number", "warning", JOptionPane.WARNING_MESSAGE);
            } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        } else if (selectedButton == button.edit) {
            try {
                // update the data on database and table
                // update the database
                int growthId = (int) model.getValueAt(table.getSelectedRow(), 0);
                String query = "UPDATE patient_growth SET weight = " + Float.parseFloat(TfWeight.getText())
                        + ", date = '" + format.format(DateChooser.getDate())
                        + "', hc = '" + TaHc.getText() + "' WHERE growth_id = " + growthId;
                con = new DB().getMySqlConn();
                st = con.createStatement();
                st.executeUpdate(query);
                // update the data on the table
                model.setValueAt(Float.parseFloat(TfWeight.getText()), table.getSelectedRow(), 1);
                model.setValueAt(format.format(DateChooser.getDate()), table.getSelectedRow(), 2);
                model.setValueAt(TaHc.getText(), table.getSelectedRow(), 3);
                
                editPanel.setVisible(false);
                viewPanel.setVisible(true);
            } catch (SQLException ex) {
                System.out.println("exception updating");
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "please select a valid number", "warning", JOptionPane.WARNING_MESSAGE);
            } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_bConfirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JTextArea TaHc;
    private javax.swing.JTextField TfWeight;
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bConfirm;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bEdit;
    private javax.swing.JPanel editPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lID;
    private javax.swing.JLabel lName;
    private javax.swing.JTable table;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
