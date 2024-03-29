/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Pavi
 */
public class OPDPatientList extends javax.swing.JFrame {
    String id;
    JFrame frame;
    JLabel label;
    JLabel label2;
    /**
     * Creates new form OPDPatientList
     */
    public OPDPatientList() {
        initComponents();
    }
    
    public OPDPatientList(String ID,JFrame Frame,JLabel Label,JLabel Label2) {
        initComponents();
        id=ID;
        frame=Frame;
        label=Label;
        label2=Label2;
        
        jPatientList.getTableHeader().setFont(new Font("Raleway SemiBold", Font.PLAIN, 13));
        jPatientList.getTableHeader().setForeground(Color.BLUE);
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select name,surname,phone from patient";
        try{
        st=con.prepareStatement(sql);
        rs=st.executeQuery();
        DefaultTableModel model=(DefaultTableModel)jPatientList.getModel();
        model.setRowCount(0);
        while(rs.next()){
            Object o[]={rs.getString("name"),rs.getString("surname"),rs.getString("phone")};
            model.addRow(o);
        }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
                }
        
        OPDPatientList close=this;
        close.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        label.setVisible(true);
        label2.setVisible(true);
    }
});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jName = new javax.swing.JTextField();
        jSelect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPatientList = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(612, 300));
        setPreferredSize(new java.awt.Dimension(612, 300));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Patient Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jNameKeyTyped(evt);
            }
        });
        getContentPane().add(jName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 200, -1));

        jSelect.setBackground(new java.awt.Color(11, 159, 207));
        jSelect.setForeground(new java.awt.Color(255, 255, 255));
        jSelect.setText("Select");
        jSelect.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jSelectMouseMoved(evt);
            }
        });
        jSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSelectMouseClicked(evt);
            }
        });
        getContentPane().add(jSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        jPatientList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Patient Name", "Patient Surname", "Patient Phone Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jPatientList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 520, 90));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNameKeyTyped
        // TODO add your handling code here:
        String start=jName.getText();
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select name,surname,phone from patient where name like '"+start+"%'";
        try{
            st=con.prepareStatement(sql);
            rs=st.executeQuery();
            DefaultTableModel model=(DefaultTableModel)jPatientList.getModel();
            model.setRowCount(0);
            while(rs.next()){
                Object o[]={rs.getString("name"),rs.getString("surname"),rs.getString("phone")};
                model.addRow(o);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jNameKeyTyped

    private void jSelectMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSelectMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jSelect.setCursor(cur1);
    }//GEN-LAST:event_jSelectMouseMoved

    private void jSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSelectMouseClicked
        // TODO add your handling code here:
        int column = 0;
        int column2 = 1;
        int row = jPatientList.getSelectedRow();
        if(row!=-1){
            String value1 = jPatientList.getModel().getValueAt(row, column).toString();
            String value2 = jPatientList.getModel().getValueAt(row, column2).toString();
            String full_name=value1+" "+value2;
            String ID="";

            Connection con = null;
            PreparedStatement st=null;
            ResultSet rs = null;
            con = Link.getConnection();
            String sql="select * from patient where full_name=?";
            try{
                st=con.prepareStatement(sql);
                st.setString(1,full_name);
                rs=st.executeQuery();
                if(rs.next()){
                    ID=rs.getString("id");
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }

            OPDPatient patient = new OPDPatient(id,ID);
            patient.setVisible(true);
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Select wanted patient and test line");
        }
    }//GEN-LAST:event_jSelectMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        frame.dispose();
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(OPDPatientList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OPDPatientList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OPDPatientList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OPDPatientList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OPDPatientList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jName;
    private javax.swing.JTable jPatientList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSelect;
    // End of variables declaration//GEN-END:variables
}
