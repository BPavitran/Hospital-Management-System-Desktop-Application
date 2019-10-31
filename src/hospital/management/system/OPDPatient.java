/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Pavi
 */
public class OPDPatient extends javax.swing.JFrame {
    String first;
    String last;
    String test;
    String old;
    String id;
    String value;
    String patient_doctor_id;
    String date;
    byte[] report;
    int x,y;
    /**
     * Creates new form OPDPatient
     */
    public OPDPatient() {
        initComponents();
    }
    
    public OPDPatient(String ID) {
        initComponents();
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xsize=(int)tk.getScreenSize().getWidth();
        int ysize=(int)tk.getScreenSize().getHeight();
        this.setSize(xsize,ysize);
           
           jOperationPanel.setVisible(false);
           jTestPanel.setVisible(false);
           
           jChange.setVisible(false);
           jUpdate.setVisible(false);
           jCancel.setVisible(false);
           
           jScrollPane5.setVisible(false);
           jScrollPane3.setBorder(null);
           
        id=ID;
    }
    
    public OPDPatient(String ID,String Value) {
        initComponents();
        id=ID;
        value=Value;
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xsize=(int)tk.getScreenSize().getWidth();
        int ysize=(int)tk.getScreenSize().getHeight();
        this.setSize(xsize,ysize);
        
        jPendingTest.getTableHeader().setFont(new Font("Raleway SemiBold", Font.PLAIN, 13));
        jPendingTest.getTableHeader().setForeground(Color.BLUE);
        
        jOldOperation.getTableHeader().setFont(new Font("Raleway SemiBold", Font.PLAIN, 13));
        jOldOperation.getTableHeader().setForeground(Color.BLUE);
        
        jPendingOperation.getTableHeader().setFont(new Font("Raleway SemiBold", Font.PLAIN, 13));
        jPendingOperation.getTableHeader().setForeground(Color.BLUE);
           
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
            jEmail.setText(rs.getString("email"));
            jCity.setText(rs.getString("city"));
            jPhone.setText(rs.getString("phone"));
            jNIC.setText(rs.getString("NIC"));
            
            jSpecification.setText(rs.getString("specification"));
            
            first=rs.getString("name");
            last=rs.getString("surname");
            jDate.setText("");
            jPrevious.setText("");
            
            DefaultListModel cleanList = new DefaultListModel();
            cleanList.clear();
            jOldPrescription.setModel(cleanList);
            
            jTestPanel.setVisible(true);
            jView.setVisible(false);
            jSelectOldDate.setVisible(false);
            jOperationPanel.setVisible(true);
           
           jChange.setVisible(true);
           
           jScrollPane5.setVisible(true);
           jScrollPane3.setBorder((BorderFactory.createLineBorder(Color.gray, 1)));
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        String sql4="select * from operation where done=? and patient_doctor_id in (select patient_doctor_id from patient_doctor where patient_id=?)";
        try{
        st=con.prepareStatement(sql4);
        st.setString(1,"No");
        st.setString(2,value);
        rs=st.executeQuery();
        DefaultTableModel tm = (DefaultTableModel)jPendingOperation.getModel();
        tm.setRowCount(0);
        
        while(rs.next()){
            Object o[]={rs.getString("operation")};
            tm.addRow(o);
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        String sql3="select * from operation where done=? and patient_doctor_id in (select patient_doctor_id from patient_doctor where patient_id=?)";
        try{
        st=con.prepareStatement(sql3);
        st.setString(1,"Yes");
        st.setString(2,value);
        rs=st.executeQuery();
        DefaultTableModel tm = (DefaultTableModel)jOldOperation.getModel();
        tm.setRowCount(0);
        
        while(rs.next()){
            Object o[]={rs.getString("operation"),rs.getString("date")};
            tm.addRow(o);
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        String sql5="select * from patient_test where done=? and patient_doctor_id in (select patient_doctor_id from patient_doctor where patient_id=?)";
        try{
        st=con.prepareStatement(sql5);
        st.setString(1,"No");
        st.setString(2,value);
        rs=st.executeQuery();
        DefaultTableModel tm = (DefaultTableModel)jPendingTest.getModel();
        tm.setRowCount(0);
        
        while(rs.next()){
            Object o[]={rs.getString("test")};
            tm.addRow(o);
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
     }
    
    public JFrame getClosed(){
        OPDPatient close=this;
        return close;
    }
    
    public JLabel getReturn(){
        return jSearch; 
    }
    
    public JLabel getBack(){
        return jExit; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOperationPanel = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jOldOperation = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPendingOperation = new javax.swing.JTable();
        jTestPanel = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPendingTest = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jSelectOldTest = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jSelectOldDate = new javax.swing.JComboBox<>();
        jView = new javax.swing.JLabel();
        jExit = new javax.swing.JLabel();
        jIndoor = new javax.swing.JLabel();
        jHome = new javax.swing.JLabel();
        jLogout = new javax.swing.JLabel();
        jClose = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSpecificationPanel = new javax.swing.JPanel();
        jChange = new javax.swing.JLabel();
        jUpdate = new javax.swing.JLabel();
        jCancel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jSpecification = new javax.swing.JTextArea();
        jSearch = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFirst = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLast = new javax.swing.JTextField();
        jGender = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jAge = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBlood = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jEmail = new javax.swing.JTextField();
        jAddress = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCity = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPhone = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPrevious = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jOld = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jOldPrescription = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jNIC = new javax.swing.JTextField();
        jDate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jOperationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Raleway SemiBold", 0, 13), new java.awt.Color(11, 159, 207))); // NOI18N
        jOperationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(11, 159, 207));
        jLabel26.setText("Pending Operations Details");
        jOperationPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 180, -1));

        jOldOperation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Operation", "Date"
            }
        ));
        jScrollPane1.setViewportView(jOldOperation);

        jOperationPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 260, 90));
        jOperationPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 280, 20));

        jLabel28.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(11, 159, 207));
        jLabel28.setText("Old Operations Details");
        jOperationPanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        jPendingOperation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Operation"
            }
        ));
        jScrollPane3.setViewportView(jPendingOperation);

        jOperationPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 260, 90));

        getContentPane().add(jOperationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 110, 280, 430));

        jTestPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Test", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Raleway SemiBold", 0, 13), new java.awt.Color(11, 159, 207))); // NOI18N
        jTestPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(11, 159, 207));
        jLabel23.setText("Pending Test");
        jTestPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jTestPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 10, 160));

        jPendingTest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Test"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jPendingTest);

        jTestPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 330, 90));

        jLabel30.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(11, 159, 207));
        jLabel30.setText("Old Test");
        jTestPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 27, -1, -1));

        jSelectOldTest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jSelectOldTest.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jSelectOldTestMouseMoved(evt);
            }
        });
        jSelectOldTest.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jSelectOldTestPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jTestPanel.add(jSelectOldTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 140, 30));

        jLabel29.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(11, 159, 207));
        jLabel29.setText("Date");
        jTestPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 27, -1, -1));

        jSelectOldDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jSelectOldDate.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jSelectOldDateMouseMoved(evt);
            }
        });
        jSelectOldDate.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jSelectOldDatePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jTestPanel.add(jSelectOldDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 100, 30));

        jView.setBackground(new java.awt.Color(11, 159, 207));
        jView.setForeground(new java.awt.Color(255, 255, 255));
        jView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jView.setText("View Report");
        jView.setOpaque(true);
        jView.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jViewMouseMoved(evt);
            }
        });
        jView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewMouseClicked(evt);
            }
        });
        jTestPanel.add(jView, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 71, 23));

        getContentPane().add(jTestPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 540, 750, 170));

        jExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        jExit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jExitMouseMoved(evt);
            }
        });
        jExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jExitMouseClicked(evt);
            }
        });
        getContentPane().add(jExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 710, -1, -1));

        jIndoor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/makeIndoorPatient.png"))); // NOI18N
        jIndoor.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jIndoorMouseMoved(evt);
            }
        });
        jIndoor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jIndoorMouseClicked(evt);
            }
        });
        getContentPane().add(jIndoor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 600, -1, -1));

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
        getContentPane().add(jHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 30, -1, -1));

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
        getContentPane().add(jLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 30, -1, -1));

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
        getContentPane().add(jClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 25, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OPDpatienticon.png"))); // NOI18N
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 140));

        jLabel32.setFont(new java.awt.Font("Raleway Medium", 0, 36)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("OPD Patients Details");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 350, 50));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bar.png"))); // NOI18N
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jSpecificationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Specification", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Raleway SemiBold", 0, 13), new java.awt.Color(11, 159, 207))); // NOI18N
        jSpecificationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jChange.setBackground(new java.awt.Color(11, 159, 207));
        jChange.setForeground(new java.awt.Color(255, 255, 255));
        jChange.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jChange.setText("Change");
        jChange.setOpaque(true);
        jChange.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jChangeMouseMoved(evt);
            }
        });
        jChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jChangeMouseClicked(evt);
            }
        });
        jSpecificationPanel.add(jChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 61, 23));

        jUpdate.setBackground(new java.awt.Color(11, 159, 207));
        jUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jUpdate.setText("Update");
        jUpdate.setOpaque(true);
        jUpdate.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jUpdateMouseMoved(evt);
            }
        });
        jUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateMouseClicked(evt);
            }
        });
        jSpecificationPanel.add(jUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 61, 23));

        jCancel.setBackground(new java.awt.Color(11, 159, 207));
        jCancel.setForeground(new java.awt.Color(255, 255, 255));
        jCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCancel.setText("Cancel");
        jCancel.setOpaque(true);
        jCancel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jCancelMouseMoved(evt);
            }
        });
        jCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCancelMouseClicked(evt);
            }
        });
        jSpecificationPanel.add(jCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 61, 23));

        jSpecification.setEditable(false);
        jSpecification.setColumns(20);
        jSpecification.setRows(5);
        jScrollPane4.setViewportView(jSpecification);

        jSpecificationPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 320, 150));

        getContentPane().add(jSpecificationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 430, 200));

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
        getContentPane().add(jSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 107, -1, -1));

        jLabel2.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(11, 159, 207));
        jLabel2.setText("First Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jFirst.setEditable(false);
        getContentPane().add(jFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 167, 140, 30));

        jLabel31.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(11, 159, 207));
        jLabel31.setText("Last Name");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));

        jLast.setEditable(false);
        getContentPane().add(jLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 167, 140, 30));

        jGender.setEditable(false);
        getContentPane().add(jGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 207, 140, 30));

        jLabel5.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(11, 159, 207));
        jLabel5.setText("Gender");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        jAge.setEditable(false);
        getContentPane().add(jAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 207, 140, 30));

        jLabel4.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(11, 159, 207));
        jLabel4.setText("Age");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(11, 159, 207));
        jLabel6.setText("Blood type");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jBlood.setEditable(false);
        getContentPane().add(jBlood, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 242, 140, 30));

        jLabel13.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(11, 159, 207));
        jLabel13.setText("Email");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, -1));

        jEmail.setEditable(false);
        getContentPane().add(jEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 242, 190, 30));

        jAddress.setEditable(false);
        getContentPane().add(jAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 280, 30));

        jLabel9.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(11, 159, 207));
        jLabel9.setText("Address");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel10.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(11, 159, 207));
        jLabel10.setText("City");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 325, -1, -1));

        jCity.setEditable(false);
        getContentPane().add(jCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 140, 30));

        jLabel11.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(11, 159, 207));
        jLabel11.setText("Phone No.");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jPhone.setEditable(false);
        getContentPane().add(jPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 140, 30));

        jLabel21.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(11, 159, 207));
        jLabel21.setText("Old Appointments");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 120, -1));

        jPrevious.setEditable(false);
        getContentPane().add(jPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 140, 30));

        jLabel20.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(11, 159, 207));
        jLabel20.setText("Previous Diagnosis");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        jOld.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jOld.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jOldMouseMoved(evt);
            }
        });
        jOld.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jOldPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        getContentPane().add(jOld, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 140, 30));

        jLabel14.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(11, 159, 207));
        jLabel14.setText("Previous Prescription");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        jScrollPane2.setViewportView(jOldPrescription);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 210, 100));

        jLabel8.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(11, 159, 207));
        jLabel8.setText("Date");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, -1, -1));

        jLabel12.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(11, 159, 207));
        jLabel12.setText("NIC");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, -1, -1));

        jNIC.setEditable(false);
        getContentPane().add(jNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 140, 30));

        jDate.setEditable(false);
        getContentPane().add(jDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 140, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jExitMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jExitMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jExit.setCursor(cur1);
    }//GEN-LAST:event_jExitMouseMoved

    private void jExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jExitMouseClicked
        // TODO add your handling code here:
        DoctorPanel panel=new DoctorPanel(id);
        panel.setVisible(true);
        dispose();
    }//GEN-LAST:event_jExitMouseClicked

    private void jIndoorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jIndoorMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jIndoor.setCursor(cur1);
    }//GEN-LAST:event_jIndoorMouseMoved

    private void jIndoorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jIndoorMouseClicked
        // TODO add your handling code here:
        Connection con = null;
        PreparedStatement st=null;
        con = Link.getConnection();
        String sql="update patient_stage set accept=? where id="+value;
        try{
            st=con.prepareStatement(sql);
            st.setString(1,"Yes");
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Patient can stay at ward");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jIndoorMouseClicked

    private void jChangeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChangeMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jChange.setCursor(cur1);
    }//GEN-LAST:event_jChangeMouseMoved

    private void jChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChangeMouseClicked
        // TODO add your handling code here:
        jSpecification.setEditable(true);

        jChange.setVisible(false);

        jUpdate.setVisible(true);
        jCancel.setVisible(true);
    }//GEN-LAST:event_jChangeMouseClicked

    private void jUpdateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jUpdate.setCursor(cur1);
    }//GEN-LAST:event_jUpdateMouseMoved

    private void jUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateMouseClicked
        // TODO add your handling code here:
        String specification=jSpecification.getText();
        Connection con = null;
        PreparedStatement st=null;
        con = Link.getConnection();
        String sql="update patient set specification=? where id="+value;
        try{
            st=con.prepareStatement(sql);
            st.setString(1,specification);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Specification Updated");

            jUpdate.setVisible(false);
            jCancel.setVisible(false);

            jChange.setVisible(true);

            jSpecification.setEditable(false);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jUpdateMouseClicked

    private void jCancelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jCancel.setCursor(cur1);
    }//GEN-LAST:event_jCancelMouseMoved

    private void jCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelMouseClicked
        // TODO add your handling code here:
        jSpecification.setText("");
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
                jSpecification.setText(rs.getString("specification"));

                jUpdate.setVisible(false);
                jCancel.setVisible(false);

                jChange.setVisible(true);

                jSpecification.setEditable(false);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jCancelMouseClicked

    private void jSearchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jSearch.setCursor(cur1);
    }//GEN-LAST:event_jSearchMouseMoved

    private void jSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchMouseClicked
        // TODO add your handling code here:
        jExit.setVisible(false);
        jSearch.setVisible(false);
        JFrame frame=this.getClosed();
        JLabel label=this.getReturn();
        JLabel label2=this.getBack();
        OPDPatientList list = new OPDPatientList(id,frame,label,label2);
        list.setVisible(true);
    }//GEN-LAST:event_jSearchMouseClicked

    private void jSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchMousePressed
        // TODO add your handling code here:
        jOperationPanel.setVisible(false);
        jTestPanel.setVisible(false);

        jChange.setVisible(false);
        jUpdate.setVisible(false);
        jCancel.setVisible(false);

        jScrollPane5.setVisible(false);
        jScrollPane3.setBorder(null);
        
        jFirst.setText("");
        jLast.setText("");
        jAge.setText("");
        jGender.setText("");
        jBlood.setText("");
        jAddress.setText("");
        jCity.setText("");
        jEmail.setText("");
        jPhone.setText("");
        jNIC.setText("");
        jDate.setText("");
        jPrevious.setText("");
        jSpecification.setText("");
        jOld.removeAllItems();
        jOld.addItem("Select");

        DefaultListModel cleanList = new DefaultListModel();
        cleanList.clear();
        jOldPrescription.setModel(cleanList);

        jDate.setText("");
        jOld.removeAllItems();
        jOld.addItem("Select");
    }//GEN-LAST:event_jSearchMousePressed

    private void jOldMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jOldMouseMoved
        // TODO add your handling code here:
        jOld.removeAllItems();
        jOld.addItem("Select");
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select distinct date from patient_prescription where patient_doctor_id in (select id from patient_doctor where doctor_id=? and patient_id=?)";
        try{
            st=con.prepareStatement(sql);
            st.setString(1,id);
            st.setString(2,value);
            rs=st.executeQuery();
            while(rs.next()){
                jOld.addItem(rs.getString("date"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jOldMouseMoved

    private void jOldPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jOldPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String tmp2=(String)jOld.getSelectedItem();
        String sql="select diagnosis,prescription from patient_prescription where date=? and patient_doctor_id in (select id from patient_doctor where doctor_id=? and patient_id=?)";
        try{
            st=con.prepareStatement(sql);
            st.setString(1,tmp2);
            st.setString(2,id);
            st.setString(3,value);
            rs=st.executeQuery();
            DefaultListModel list2=new DefaultListModel();
            while(rs.next()){

                jDate.setText(tmp2);
                jPrevious.setText(rs.getString("diagnosis"));
                list2.addElement(rs.getString("prescription"));
                jOldPrescription.setModel(list2);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jOldPopupMenuWillBecomeInvisible

    private void jSelectOldTestMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSelectOldTestMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jSelectOldTest.setCursor(cur1);

        jSelectOldTest.setCursor(cur1);
        jSelectOldTest.removeAllItems();
        jSelectOldTest.addItem("Select");
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select distinct test from patient_test where done=? and patient_doctor_id in (select id from patient_doctor where patient_id=?)";
        try{
            st=con.prepareStatement(sql);
            st.setString(1,"Yes");
            st.setString(2,value);
            rs=st.executeQuery();
            while(rs.next()){
                jSelectOldTest.addItem(rs.getString("test"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

        if(old!=null){
            jSelectOldTest.setSelectedItem(old);
        }
    }//GEN-LAST:event_jSelectOldTestMouseMoved

    private void jSelectOldTestPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jSelectOldTestPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        old=(String)jSelectOldTest.getSelectedItem();
        if(!old.equals("Select")){
            jSelectOldDate.setVisible(true);
        }
    }//GEN-LAST:event_jSelectOldTestPopupMenuWillBecomeInvisible

    private void jSelectOldDateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSelectOldDateMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jSelectOldDate.setCursor(cur1);
        jSelectOldDate.removeAllItems();
        jSelectOldDate.addItem("Select");
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select distinct today_date from patient_test where test=? and patient_doctor_id in (select id from patient_doctor where patient_id=?)";
        try{
            st=con.prepareStatement(sql);
            st.setString(1,old);
            st.setString(2,value);
            rs=st.executeQuery();
            while(rs.next()){
                jSelectOldDate.addItem(rs.getString("today_date"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

        if(date!=null){
            jSelectOldDate.setSelectedItem(date);
        }
    }//GEN-LAST:event_jSelectOldDateMouseMoved

    private void jSelectOldDatePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jSelectOldDatePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        date=(String)jSelectOldDate.getSelectedItem();
        if(!date.equals("Select")){
            jView.setVisible(true);
        }
    }//GEN-LAST:event_jSelectOldDatePopupMenuWillBecomeInvisible

    private void jViewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jView.setCursor(cur1);
    }//GEN-LAST:event_jViewMouseMoved

    private void jViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewMouseClicked
        // TODO add your handling code here:
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;

        InputStream input=null;
        FileOutputStream output=null;

        con = Link.getConnection();
        String sql="select report from patient_test where test=? and today_date=? and patient_doctor_id in (select id from patient_doctor where patient_id=?)";
        try{
            st=con.prepareStatement(sql);
            st.setString(1,old);
            st.setString(2,date);
            st.setString(3,value);
            rs=st.executeQuery();

            File theFile=new File("report.pdf");
            output=new FileOutputStream(theFile);

            while(rs.next()){
                input=rs.getBinaryStream("report");

                byte[] buffer=new byte[1024];
                while(input.read(buffer)>0){
                    output.write(buffer);
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException ex) {
                    Logger.getLogger(CurrentPatient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(output!=null){
                try {
                    output.close();
                } catch (IOException ex) {
                    Logger.getLogger(CurrentPatient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("report.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Any file not added");
            }
        }
    }//GEN-LAST:event_jViewMouseClicked

    private void jHomeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jHome.setCursor(cur1);
    }//GEN-LAST:event_jHomeMouseMoved

    private void jHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMouseClicked
        // TODO add your handling code here:
        DoctorPanel panel = new DoctorPanel(id);
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
            java.util.logging.Logger.getLogger(OPDPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OPDPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OPDPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OPDPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OPDPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAddress;
    private javax.swing.JTextField jAge;
    private javax.swing.JTextField jBlood;
    private javax.swing.JLabel jCancel;
    private javax.swing.JLabel jChange;
    private javax.swing.JTextField jCity;
    private javax.swing.JLabel jClose;
    private javax.swing.JTextField jDate;
    private javax.swing.JTextField jEmail;
    private javax.swing.JLabel jExit;
    private javax.swing.JTextField jFirst;
    private javax.swing.JTextField jGender;
    private javax.swing.JLabel jHome;
    private javax.swing.JLabel jIndoor;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLast;
    private javax.swing.JLabel jLogout;
    private javax.swing.JTextField jNIC;
    private javax.swing.JComboBox<String> jOld;
    private javax.swing.JTable jOldOperation;
    private javax.swing.JList<String> jOldPrescription;
    private javax.swing.JPanel jOperationPanel;
    private javax.swing.JTable jPendingOperation;
    private javax.swing.JTable jPendingTest;
    private javax.swing.JTextField jPhone;
    private javax.swing.JTextField jPrevious;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel jSearch;
    private javax.swing.JComboBox<String> jSelectOldDate;
    private javax.swing.JComboBox<String> jSelectOldTest;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jSpecification;
    private javax.swing.JPanel jSpecificationPanel;
    private javax.swing.JPanel jTestPanel;
    private javax.swing.JLabel jUpdate;
    private javax.swing.JLabel jView;
    // End of variables declaration//GEN-END:variables
}
