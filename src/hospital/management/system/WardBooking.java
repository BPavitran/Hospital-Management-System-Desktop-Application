/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Pavi
 */
public class WardBooking extends javax.swing.JFrame {
    String id;
    String value;
    String patient_doctor_id;
    String type="";
    String ward_no="";
    String first;
    /**
     * Creates new form Booking
     */
    public WardBooking() {
        initComponents();
    }
    
    public WardBooking(String ID) {
        initComponents();
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xsize=(int)tk.getScreenSize().getWidth();
        int ysize=(int)tk.getScreenSize().getHeight();
        this.setSize(xsize,ysize);
        id=ID;
        jTypePanel.setVisible(false);
        first=jFirst.getText();
    }
    
    public WardBooking(String ID, String Value) {
        initComponents();
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xsize=(int)tk.getScreenSize().getWidth();
        int ysize=(int)tk.getScreenSize().getHeight();
        this.setSize(xsize,ysize);
        
        id=ID;
        value=Value;
        first=jFirst.getText();
        
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select * from patient where id=?";
        try{
            st=con.prepareStatement(sql);
            st.setString(1,value);
            rs=st.executeQuery();

            if(rs.next()){
                jFirst.setText(rs.getString("name"));
                jLast.setText(rs.getString("surname"));
                jAge.setText(rs.getString("age"));
                jGender.setText(rs.getString("gender"));
                jBlood.setText(rs.getString("blood"));
                jAddress.setText(rs.getString("address"));
                jCity.setText(rs.getString("city"));
                jEmail.setText(rs.getString("email"));
                jPhone.setText(rs.getString("phone"));
                jNIC.setText(rs.getString("NIC"));
                
                jTypePanel.setVisible(true);
                
                jLabel20.setVisible(false);
                jSetupWard.setVisible(false);
                
                jLabel17.setVisible(false);
                jSetupBed.setVisible(false);
                
                String sql1 = "select * from patient_stage where patient_id=?";
                           try{
                                st=con.prepareStatement(sql1);
                                st.setString(1,value);
                                rs=st.executeQuery();
                                
                                if(rs.next()){
                                    String type=rs.getString("patient_type");
                                    jState.setText(type);
                                    if(type.equals("Outdoor")){
                                        
                                        jLabel18.setVisible(false);
                                        jLabel25.setVisible(false);
                                        jWard.setVisible(false);
                                        jBed.setVisible(false);
                                        jBook.setVisible(false);
                                    }
                                    else{
                                        jLabel25.setVisible(true);
                                        jWard.setVisible(true);
                                        jWard.setText(rs.getString("ward_no"));
                                        
                                        jBook.setVisible(false);
                                        
                                        String bed_no=rs.getString("bed_no");
                                        if(!bed_no.equals("0")){
                                            jLabel18.setVisible(true);
                                            jBed.setVisible(true);
                                            jBed.setText(bed_no);
                                        }else{
                                            jLabel18.setVisible(false);
                                            jBed.setVisible(false);
                                        }
                                    }
                                }
                           }
                           catch(Exception e){
                            e.printStackTrace();
        }

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public JFrame getClosed(){
        WardBooking close=this;
        return close;
    }
    
    public JLabel getReturn(){
        return jSearch; 
    }
    
    public JLabel getBack(){
        return jBack; 
    }
    
    public JPanel getVisible(){
        return jTypePanel; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTypePanel = new javax.swing.JPanel();
        jBook = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jBed = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jState = new javax.swing.JTextField();
        jSetupWard = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jWard = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jSetupBed = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jType = new javax.swing.JComboBox<>();
        jHome = new javax.swing.JLabel();
        jLogout = new javax.swing.JLabel();
        jClose = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPhone = new javax.swing.JTextField();
        jCity = new javax.swing.JTextField();
        jAddress = new javax.swing.JTextField();
        jBlood = new javax.swing.JTextField();
        jAge = new javax.swing.JTextField();
        jFirst = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jDate1 = new javax.swing.JTextField();
        jNIC = new javax.swing.JTextField();
        jEmail = new javax.swing.JTextField();
        jGender = new javax.swing.JTextField();
        jLast = new javax.swing.JTextField();
        jBack = new javax.swing.JLabel();
        jSearch = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Raleway SemiBold", 0, 13), new java.awt.Color(11, 159, 207))); // NOI18N
        jTypePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bookWardButton.png"))); // NOI18N
        jBook.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jBookMouseMoved(evt);
            }
        });
        jBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBookMouseClicked(evt);
            }
        });
        jTypePanel.add(jBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, -1));

        jLabel18.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(11, 159, 207));
        jLabel18.setText("Current Bed");
        jTypePanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel17.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(11, 159, 207));
        jLabel17.setText("Bed_No");
        jTypePanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        jBed.setEditable(false);
        jTypePanel.add(jBed, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 140, 30));

        jLabel25.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(11, 159, 207));
        jLabel25.setText("Current Ward");
        jTypePanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jState.setEditable(false);
        jTypePanel.add(jState, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 140, 30));

        jSetupWard.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jSetupWard.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jSetupWardMouseMoved(evt);
            }
        });
        jSetupWard.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jSetupWardPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jTypePanel.add(jSetupWard, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 140, 30));

        jLabel26.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(11, 159, 207));
        jLabel26.setText("Previous State");
        jTypePanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jWard.setEditable(false);
        jTypePanel.add(jWard, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 140, 30));

        jLabel19.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(11, 159, 207));
        jLabel19.setText("Ward Type");
        jTypePanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jSetupBed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jSetupBed.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jSetupBedMouseMoved(evt);
            }
        });
        jSetupBed.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jSetupBedPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jTypePanel.add(jSetupBed, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 140, 30));

        jLabel20.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(11, 159, 207));
        jLabel20.setText("Ward_No");
        jTypePanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        jType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Luxury", "Normal" }));
        jType.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTypeMouseMoved(evt);
            }
        });
        jType.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jTypePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jTypePanel.add(jType, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 140, 30));

        getContentPane().add(jTypePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 510, 250));

        jHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home.png"))); // NOI18N
        jHome.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jHomeMouseMoved(evt);
            }
        });
        jHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jHomeMouseClicked(evt);
            }
        });
        getContentPane().add(jHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 60, -1, -1));

        jLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout_icon.png"))); // NOI18N
        jLogout.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLogoutMouseMoved(evt);
            }
        });
        jLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLogoutMouseClicked(evt);
            }
        });
        getContentPane().add(jLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 60, -1, -1));

        jClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        jClose.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jCloseMouseMoved(evt);
            }
        });
        jClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCloseMouseClicked(evt);
            }
        });
        getContentPane().add(jClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 55, -1, -1));

        jLabel28.setFont(new java.awt.Font("Raleway Medium", 0, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Booking Ward");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 260, 50));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bookWard.png"))); // NOI18N
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 150, 140));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bar.png"))); // NOI18N
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(11, 159, 207));
        jLabel2.setText("First Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(11, 159, 207));
        jLabel4.setText("Age");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel6.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(11, 159, 207));
        jLabel6.setText("Blood type");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel9.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(11, 159, 207));
        jLabel9.setText("Address");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel10.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(11, 159, 207));
        jLabel10.setText("City");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jLabel11.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(11, 159, 207));
        jLabel11.setText("Phone No.");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jPhone.setEditable(false);
        getContentPane().add(jPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 140, 30));

        jCity.setEditable(false);
        getContentPane().add(jCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 140, 30));

        jAddress.setEditable(false);
        getContentPane().add(jAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 280, 30));

        jBlood.setEditable(false);
        getContentPane().add(jBlood, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 140, 30));

        jAge.setEditable(false);
        getContentPane().add(jAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 140, 30));

        jFirst.setEditable(false);
        getContentPane().add(jFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 140, 30));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bar.png"))); // NOI18N
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jLabel31.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(11, 159, 207));
        jLabel31.setText("Last Name");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(11, 159, 207));
        jLabel5.setText("Gender");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, -1));

        jLabel13.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(11, 159, 207));
        jLabel13.setText("Email");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, -1, -1));

        jLabel12.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(11, 159, 207));
        jLabel12.setText("NIC");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, -1, -1));

        jLabel16.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(11, 159, 207));
        jLabel16.setText("Date");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, -1, -1));

        jDate1.setEditable(false);
        getContentPane().add(jDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 140, 30));

        jNIC.setEditable(false);
        getContentPane().add(jNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 140, 30));

        jEmail.setEditable(false);
        getContentPane().add(jEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 190, 30));

        jGender.setEditable(false);
        getContentPane().add(jGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 140, 30));

        jLast.setEditable(false);
        getContentPane().add(jLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 140, 30));

        jBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Back_1.png"))); // NOI18N
        jBack.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jBackMouseMoved(evt);
            }
        });
        jBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMouseClicked(evt);
            }
        });
        getContentPane().add(jBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, -1, -1));

        jSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search patient.png"))); // NOI18N
        jSearch.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jSearchMouseMoved(evt);
            }
        });
        jSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSearchMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jSearchMousePressed(evt);
            }
        });
        getContentPane().add(jSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBookMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBookMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jBook.setCursor(cur1);
    }//GEN-LAST:event_jBookMouseMoved

    private void jBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBookMouseClicked
        // TODO add your handling code here:
        String ward=(String)jSetupWard.getSelectedItem();
        String bed=(String)jSetupBed.getSelectedItem();
        if(type.equals("Luxury")){
            bed="0";
        }
        Connection con = null;
        PreparedStatement st=null;
        con = Link.getConnection();
        if(!(ward.isEmpty() || bed.isEmpty())){
            String sql="update patient_stage set patient_type=?,ward_no=?,bed_no=? where patient_id="+value;
            try{
                st=con.prepareStatement(sql);
                st.setString(1,"Indoor");
                st.setString(2,ward);
                st.setString(3,bed);
                st.executeUpdate();
                JOptionPane.showMessageDialog(null,"Booked Successfully");
                jState.setText("");
                jState.setText("Indoor");
                
                jWard.setText(ward);
                jBed.setText(bed);
                
                jLabel20.setVisible(false);
                jSetupWard.setVisible(false);
                
                jLabel17.setVisible(false);
                jSetupBed.setVisible(false);
                
                String sql1="update ward set booked=? where ward_no="+ward+" and bed_no="+bed;
                try{
                st=con.prepareStatement(sql1);
                st.setString(1,"Yes");
                st.executeUpdate();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Please enter ward number and bed number", 
                               "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBookMouseClicked

    private void jSetupWardMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSetupWardMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jSetupWard.setCursor(cur1);
    }//GEN-LAST:event_jSetupWardMouseMoved

    private void jSetupWardPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jSetupWardPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        jLabel17.setVisible(false);
        jSetupBed.setVisible(false);
        
        jBook.setVisible(false);
        
        ward_no=(String)jSetupWard.getSelectedItem();
        if(type.equals("Normal")){
            jSetupBed.removeAllItems();
            jSetupBed.addItem("Select");
            Connection con = null;
            PreparedStatement st=null;
            ResultSet rs = null;
            con = Link.getConnection();
            String sql="select bed_no from ward where ward_no=? and booked=?";
            try{
                st=con.prepareStatement(sql);
                st.setString(1,ward_no);
                st.setString(2,"No");
                rs=st.executeQuery();
                while(rs.next()){
                jSetupBed.addItem(rs.getString("bed_no"));
                }
                
                int items = jSetupBed.getItemCount();
                if(items>1){
                    jSetupBed.setVisible(true);
                    jLabel17.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"All Beds in Ward no "+ward_no+"are booked", 
                               "WARNING", JOptionPane.WARNING_MESSAGE);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            } 
        }else if(type.equals("Luxury")){
            jBook.setVisible(true);
        }
        
        
    }//GEN-LAST:event_jSetupWardPopupMenuWillBecomeInvisible

    private void jSetupBedMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSetupBedMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jSetupBed.setCursor(cur1);
    }//GEN-LAST:event_jSetupBedMouseMoved

    private void jSetupBedPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jSetupBedPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        jBook.setVisible(true);
    }//GEN-LAST:event_jSetupBedPopupMenuWillBecomeInvisible

    private void jSearchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jSearch.setCursor(cur1);
    }//GEN-LAST:event_jSearchMouseMoved

    private void jSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchMouseClicked
        // TODO add your handling code here:
        jBack.setVisible(false);
        jSearch.setVisible(false);
        JFrame frame=this.getClosed();
        JLabel label=this.getReturn();
        JLabel label2=this.getBack();
        JPanel panel=this.getVisible();
        WardBookingList list = new WardBookingList(id,frame,label,label2,panel,first);
        list.setVisible(true);
    }//GEN-LAST:event_jSearchMouseClicked

    private void jSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchMousePressed
        // TODO add your handling code here:
        jLabel20.setVisible(false);
        jLabel17.setVisible(false);
        jSetupWard.setVisible(false);
        jSetupBed.setVisible(false);
        jBook.setVisible(false);
    }//GEN-LAST:event_jSearchMousePressed

    private void jBackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jBack.setCursor(cur1);
    }//GEN-LAST:event_jBackMouseMoved

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        // TODO add your handling code here:
        ReceptionistPanel portal=new ReceptionistPanel(id);
        portal.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBackMouseClicked

    private void jTypeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTypeMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jType.setCursor(cur1);
    }//GEN-LAST:event_jTypeMouseMoved

    private void jTypePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jTypePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        jLabel17.setVisible(false);
        jSetupBed.setVisible(false);
        
        jLabel20.setVisible(false);
        jSetupWard.setVisible(false);
        
        jBook.setVisible(false);
        
        jSetupWard.removeAllItems();
        jSetupWard.addItem("Select");
        type=(String)jType.getSelectedItem();
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select distinct ward_no from ward where type=? and booked=?";
        try{
            st=con.prepareStatement(sql);
            st.setString(1,type);
            st.setString(2,"No");
            rs=st.executeQuery();
            while(rs.next()){
                jSetupWard.addItem(rs.getString("ward_no"));
            }
            
            int items = jSetupWard.getItemCount();
            System.out.println(items);
                if(items>1){
                    jLabel20.setVisible(true);
                    jSetupWard.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"All "+type+" Wards are booked", 
                               "WARNING", JOptionPane.WARNING_MESSAGE);
                }
                
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jTypePopupMenuWillBecomeInvisible

    private void jHomeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jHome.setCursor(cur1);
    }//GEN-LAST:event_jHomeMouseMoved

    private void jHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMouseClicked
        // TODO add your handling code here:
        ReceptionistPanel panel = new ReceptionistPanel(id);
        panel.setVisible(true);
        dispose();
    }//GEN-LAST:event_jHomeMouseClicked

    private void jLogoutMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogoutMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jLogout.setCursor(cur1);
    }//GEN-LAST:event_jLogoutMouseMoved

    private void jLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogoutMouseClicked
        // TODO add your handling code here:
        LoginPanel panel = new LoginPanel();
        panel.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLogoutMouseClicked

    private void jCloseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCloseMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jClose.setCursor(cur1);
    }//GEN-LAST:event_jCloseMouseMoved

    private void jCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCloseMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jCloseMouseClicked

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
            java.util.logging.Logger.getLogger(WardBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WardBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WardBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WardBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WardBooking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAddress;
    private javax.swing.JTextField jAge;
    private javax.swing.JLabel jBack;
    private javax.swing.JTextField jBed;
    private javax.swing.JTextField jBlood;
    private javax.swing.JLabel jBook;
    private javax.swing.JTextField jCity;
    private javax.swing.JLabel jClose;
    private javax.swing.JTextField jDate1;
    private javax.swing.JTextField jEmail;
    private javax.swing.JTextField jFirst;
    private javax.swing.JTextField jGender;
    private javax.swing.JLabel jHome;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLast;
    private javax.swing.JLabel jLogout;
    private javax.swing.JTextField jNIC;
    private javax.swing.JTextField jPhone;
    private javax.swing.JLabel jSearch;
    private javax.swing.JComboBox<String> jSetupBed;
    private javax.swing.JComboBox<String> jSetupWard;
    private javax.swing.JTextField jState;
    private javax.swing.JComboBox<String> jType;
    private javax.swing.JPanel jTypePanel;
    private javax.swing.JTextField jWard;
    // End of variables declaration//GEN-END:variables
}
