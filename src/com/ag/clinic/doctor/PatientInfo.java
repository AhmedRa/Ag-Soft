/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.clinic.doctor;

import com.ag.clinic.DB.DB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author osama
 */
public class PatientInfo extends javax.swing.JPanel {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private final int patientId;
    private DefaultComboBoxModel BDDayModel;
    private DefaultComboBoxModel BDMonthModel;
    private DefaultComboBoxModel BDYearModel;
    private DefaultComboBoxModel VDDayModel;
    private DefaultComboBoxModel VDMonthModel;
    private DefaultComboBoxModel VDYearModel;

    public PatientInfo(int id) {
        initComponents();
        patientId = id;
        System.out.println("patient id is : " + patientId);

        // intitializing models
        BDDayModel = (DefaultComboBoxModel) CbBDDay.getModel();
        BDMonthModel = (DefaultComboBoxModel) CbBDMonth.getModel();
        BDYearModel = (DefaultComboBoxModel) CbBDYear.getModel();
        VDDayModel = (DefaultComboBoxModel) CbVDDay.getModel();
        VDMonthModel = (DefaultComboBoxModel) CbVDMonth.getModel();
        VDYearModel = (DefaultComboBoxModel) CbVDYear.getModel();

        fillDate(BDDayModel, BDMonthModel, BDYearModel);
        fillDate(VDDayModel, VDMonthModel, VDYearModel);
        try {
            setData();
        } catch (SQLException ex) {
            System.out.println("filling data faileur");
            ex.printStackTrace();
        }
    }

    public void fillDate(DefaultComboBoxModel day, DefaultComboBoxModel month, DefaultComboBoxModel year) {
        for (int i = 1; i <= 31; i++) {
            day.addElement(i);

            if (i <= 12) {
                month.addElement(i);
            }

            year.addElement(1990 + i);
        }
    }

    private void setData() throws SQLException {
        // get the data first
        con = new DB().getMySqlConn();
        st = con.createStatement();
        String query;
        query = "SELECT * FROM patient WHERE active = 1 AND patient_id = " + patientId;
        rs = st.executeQuery(query);
        rs.absolute(1);

        // set the id 
        lpatientId.setText(rs.getString("patient_id"));

        // set the patient name
        TfPatientName.setText(rs.getString("patient_name"));

        // set the phone
        TfPatientPhone.setText(rs.getString("patient_phone"));

        // set the address
        TfPatientAdress.setText(rs.getString("patient_address"));

        // set the birthday date
        Date BDDate = rs.getDate("patient_birthday");
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String date = df.format(BDDate);
        String day = date.substring(0, 2);
        String month = date.substring(3, 5);
        String year = date.substring(6);
        date = null;
        CbBDDay.setSelectedIndex(Integer.parseInt(day));
        CbBDMonth.setSelectedIndex(Integer.parseInt(month));
        // substract the initial year from current 
        CbBDYear.setSelectedIndex(Integer.parseInt(year) - 1990);
        BDDate = null;

        // set the last visit date
        Date VDDate = rs.getDate("date");
        date = df.format(VDDate);
        day = date.substring(0, 2);
        month = date.substring(3, 5);
        year = date.substring(6);
        CbVDDay.setSelectedIndex(Integer.parseInt(day));
        CbVDMonth.setSelectedIndex(Integer.parseInt(month));
        // substract the initial year from current 
        CbVDYear.setSelectedIndex(Integer.parseInt(year) - 1990);
        year = null;
        day = null;
        month = null;
        
        // set the notes
        TaNotes.setText(rs.getString("notes"));
        // TO DO: add the age
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
     * @param args
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lpatientId = new javax.swing.JLabel();
        TfPatientName = new javax.swing.JTextField();
        TfPatientPhone = new javax.swing.JTextField();
        TfPatientAdress = new javax.swing.JTextField();
        CbBDDay = new javax.swing.JComboBox();
        CbBDMonth = new javax.swing.JComboBox();
        CbBDYear = new javax.swing.JComboBox();
        CbVDDay = new javax.swing.JComboBox();
        CbVDMonth = new javax.swing.JComboBox();
        CbVDYear = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        TaNotes = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("patient ID:");

        jLabel2.setText("patient name:");

        jLabel3.setText("patient phone:");

        jLabel4.setText("patient address:");

        jLabel5.setText("patient birthday:");

        jLabel6.setText("visit date:");

        jLabel7.setText("notes:");

        TfPatientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfPatientNameActionPerformed(evt);
            }
        });

        CbBDDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "..." }));

        CbBDMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "..." }));
        CbBDMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CbBDMonthMouseClicked(evt);
            }
        });

        CbBDYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "..." }));

        CbVDDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "..." }));

        CbVDMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "..." }));

        CbVDYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "..." }));

        TaNotes.setColumns(20);
        TaNotes.setRows(5);
        jScrollPane2.setViewportView(TaNotes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(TfPatientAdress))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TfPatientName)
                                    .addComponent(TfPatientPhone)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lpatientId, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(100, 100, 100))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CbVDDay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(CbBDDay, 0, 58, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(CbBDMonth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(CbVDMonth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CbBDYear, 0, 80, Short.MAX_VALUE)
                                            .addComponent(CbVDYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(38, 38, 38)))
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lpatientId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(TfPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TfPatientPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TfPatientAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CbBDDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbBDMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbBDYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(CbVDDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbVDMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbVDYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TfPatientNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfPatientNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfPatientNameActionPerformed

    private void CbBDMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CbBDMonthMouseClicked
//  TO DO:      handle the leap year and different month days

//        GregorianCalendar gc = new GregorianCalendar(Integer.parseInt((String) CbBDYear.getSelectedItem()),
//                Integer.parseInt((String) CbBDMonth.getSelectedItem()), Integer.parseInt((String) CbBDDay.getSelectedItem()));
////        GregorianCalendar gc = new GregorianCalendar((int) CbBDYear.getSelectedItem(), (int) CbBDMonth.getSelectedItem(),
////                (int) CbBDDay.getSelectedItem());
//        int monthMax = gc.getActualMaximum(GregorianCalendar.MONTH);
//        while ((int) BDDayModel.getElementAt(BDDayModel.getSize() - 1) > monthMax) {
//            BDDayModel.removeElementAt(BDDayModel.getSize() - 1);
//        }
    }//GEN-LAST:event_CbBDMonthMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CbBDDay;
    private javax.swing.JComboBox CbBDMonth;
    private javax.swing.JComboBox CbBDYear;
    private javax.swing.JComboBox CbVDDay;
    private javax.swing.JComboBox CbVDMonth;
    private javax.swing.JComboBox CbVDYear;
    private javax.swing.JTextArea TaNotes;
    private javax.swing.JTextField TfPatientAdress;
    private javax.swing.JTextField TfPatientName;
    private javax.swing.JTextField TfPatientPhone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JLabel lpatientId;
    // End of variables declaration//GEN-END:variables
}
