/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Pavi
 */
public class UpdateDoctor extends javax.swing.JFrame {
    String filename;
    byte[] person_image;
    byte[] imageBytes;
    String id;
    String value;
    int submit_check=0;
    int check=0;

    /**
     * Creates new form UpdateDoctor
     */
    public UpdateDoctor() {
        initComponents();
    }
    
    public UpdateDoctor(String ID){
        initComponents();
        id=ID;
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xsize=(int)tk.getScreenSize().getWidth();
        int ysize=(int)tk.getScreenSize().getHeight();
        this.setSize(xsize,ysize);
        
        jPrevious.setVisible(false);
        jSubmit.setVisible(false);
        
        byte[] imageBytes;
        Image image;
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select * from doctor where id=?";
        try{
        st=con.prepareStatement(sql);
        st.setString(1,"1");
        rs=st.executeQuery();
            
       while(rs.next()){
           jFirst.setText(rs.getString("name"));
           jLast.setText(rs.getString("surname"));
           jAge.setText(rs.getString("age"));
           jSpecial.setText(rs.getString("specialization"));
           jGender.setText(rs.getString("gender"));
           jBlood.setText(rs.getString("blood"));
           jAddress.setText(rs.getString("address"));
           jCity.setText(rs.getString("city"));
           jPhone.setText(rs.getString("phone"));
           jNIC.setText(rs.getString("NIC"));
           jEmail.setText(rs.getString("email"));
           jDate.setText(rs.getString("joining"));
           
           imageBytes=rs.getBytes("photo");
           if(imageBytes!=null && imageBytes.length>0){
           image=getToolkit().createImage(imageBytes);
           ImageIcon icon=new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(jImage.getWidth(),jImage.getHeight(),Image.SCALE_SMOOTH));
           jImage.setIcon(icon);
           }
       }
        }
        catch(Exception e){
           e.printStackTrace(); 
        }
    }
    
    public UpdateDoctor(String ID,String Value){
        initComponents();
        id=ID;
        value=Value;
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xsize=(int)tk.getScreenSize().getWidth();
        int ysize=(int)tk.getScreenSize().getHeight();
        this.setSize(xsize,ysize);
        
        jPrevious.setVisible(false);
        jSubmit.setVisible(false);
        
        byte[] imageBytes;
        Image image;
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select * from doctor where id=?";
        try{
        st=con.prepareStatement(sql);
        st.setString(1,value);
        rs=st.executeQuery();
            
       while(rs.next()){
           jFirst.setText(rs.getString("name"));
           jLast.setText(rs.getString("surname"));
           jAge.setText(rs.getString("age"));
           jSpecial.setText(rs.getString("specialization"));
           jGender.setText(rs.getString("gender"));
           jBlood.setText(rs.getString("blood"));
           jAddress.setText(rs.getString("address"));
           jCity.setText(rs.getString("city"));
           jPhone.setText(rs.getString("phone"));
           jNIC.setText(rs.getString("NIC"));
           jEmail.setText(rs.getString("email"));
           jDate.setText(rs.getString("joining"));
           imageBytes=rs.getBytes("photo");
           if(imageBytes!=null && imageBytes.length>0){
           image=getToolkit().createImage(imageBytes);
           ImageIcon icon=new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(jImage.getWidth(),jImage.getHeight(),Image.SCALE_SMOOTH));
           jImage.setIcon(icon);
           }
       }
        }
        catch(Exception e){
           e.printStackTrace(); 
        }
    }
    
    public JFrame getClosed(){
        UpdateDoctor close=this;
        return close;
    }
    
    public JLabel getReturn(){
        return jSearch; 
    }
    
    public JLabel getBack(){
        return jBack; 
    }
    
    public JMenuBar getMenu(){
        return jMenuBar2; 
    }
    
    public JLabel getChange(){
        return jChange; 
    }
    
    public JLabel getSave(){
        return jSave; 
    }
    
    public JLabel getPrevious(){
        return jPrevious; 
    }
    
    public JLabel getSubmit(){
        return jSubmit; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jLast = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jSubmit = new javax.swing.JLabel();
        jChange = new javax.swing.JLabel();
        jPrevious = new javax.swing.JLabel();
        jImage = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDate = new javax.swing.JTextField();
        jBlood = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPhone = new javax.swing.JTextField();
        jCity = new javax.swing.JTextField();
        jAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jBack = new javax.swing.JLabel();
        jAge = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jEmail = new javax.swing.JTextField();
        jFirst = new javax.swing.JTextField();
        jSpecial = new javax.swing.JTextField();
        jNIC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSave = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jGender = new javax.swing.JTextField();
        jClose = new javax.swing.JLabel();
        jLogout = new javax.swing.JLabel();
        jHome = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSearch = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jViewProfile = new javax.swing.JMenu();
        jInsertProfile = new javax.swing.JMenu();
        jUpdateProfile = new javax.swing.JMenu();
        jTimeTable = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 153));
        jLabel13.setText("Joining Date");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, -1, -1));
        getContentPane().add(jLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, 140, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Photo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Raleway SemiBold", 0, 13), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(null);

        jSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/submitwhite.png"))); // NOI18N
        jSubmit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jSubmitMouseMoved(evt);
            }
        });
        jSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSubmitMouseClicked(evt);
            }
        });
        jPanel1.add(jSubmit);
        jSubmit.setBounds(190, 210, 125, 50);

        jChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/changePhoto.png"))); // NOI18N
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
        jPanel1.add(jChange);
        jChange.setBounds(200, 60, 140, 60);

        jPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/previousPhoto.png"))); // NOI18N
        jPrevious.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPreviousMouseMoved(evt);
            }
        });
        jPrevious.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPreviousMouseClicked(evt);
            }
        });
        jPanel1.add(jPrevious);
        jPrevious.setBounds(20, 205, 140, 60);

        jImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jImage);
        jImage.setBounds(30, 30, 160, 160);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 190, 340, 280));

        jLabel8.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Address");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, -1));

        jLabel6.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Gender");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        jDate.setEditable(false);
        getContentPane().add(jDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, 140, 30));

        jBlood.setEditable(false);
        getContentPane().add(jBlood, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, 140, 30));

        jLabel3.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Last Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, -1, -1));

        jLabel10.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Phone No.");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, -1, -1));

        jPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPhoneKeyReleased(evt);
            }
        });
        getContentPane().add(jPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 410, 140, 30));
        getContentPane().add(jCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 140, 30));
        getContentPane().add(jAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 280, 30));

        jLabel4.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Age");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));

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
        getContentPane().add(jBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 630, -1, -1));

        jAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jAgeKeyReleased(evt);
            }
        });
        getContentPane().add(jAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 140, 30));

        jLabel11.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("NIC");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, -1, -1));

        jEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jEmailFocusLost(evt);
            }
        });
        getContentPane().add(jEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 140, 30));
        getContentPane().add(jFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 140, 30));

        jSpecial.setEditable(false);
        getContentPane().add(jSpecial, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, 140, 30));

        jNIC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jNICFocusLost(evt);
            }
        });
        getContentPane().add(jNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 140, 30));

        jLabel9.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("City");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

        jSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/saveButton.png"))); // NOI18N
        jSave.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jSaveMouseMoved(evt);
            }
        });
        jSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSaveMouseClicked(evt);
            }
        });
        getContentPane().add(jSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 500, -1, -1));

        jLabel5.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Specialization");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, -1, -1));

        jLabel14.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("Email");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, -1, -1));

        jLabel2.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("First Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Blood Groop");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, -1, -1));

        jGender.setEditable(false);
        getContentPane().add(jGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 140, 30));

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

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/doctoricon.png"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 150, 140));

        jLabel18.setFont(new java.awt.Font("Raleway Medium", 0, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Update Profile");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 250, 50));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bar.png"))); // NOI18N
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search doctor.png"))); // NOI18N
        jSearch.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jSearchMouseMoved(evt);
            }
        });
        jSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSearchMouseClicked(evt);
            }
        });
        getContentPane().add(jSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        jViewProfile.setText("View Profile");
        jViewProfile.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jViewProfileMouseMoved(evt);
            }
        });
        jViewProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jViewProfileMouseClicked(evt);
            }
        });
        jMenuBar2.add(jViewProfile);

        jInsertProfile.setText("Insert Profile");
        jInsertProfile.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jInsertProfileMouseMoved(evt);
            }
        });
        jInsertProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jInsertProfileMouseClicked(evt);
            }
        });
        jMenuBar2.add(jInsertProfile);

        jUpdateProfile.setText("Update Profile");
        jUpdateProfile.setToolTipText("");
        jUpdateProfile.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jUpdateProfileMouseMoved(evt);
            }
        });
        jUpdateProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUpdateProfileMouseClicked(evt);
            }
        });
        jMenuBar2.add(jUpdateProfile);

        jTimeTable.setText("TimeTable");
        jTimeTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTimeTableMouseMoved(evt);
            }
        });
        jTimeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTimeTableMouseClicked(evt);
            }
        });
        jMenuBar2.add(jTimeTable);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSubmitMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSubmitMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jSubmit.setCursor(cur1);
    }//GEN-LAST:event_jSubmitMouseMoved

    private void jSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSubmitMouseClicked
        // TODO add your handling code here:
        Connection con=null;
        PreparedStatement st=null;
        con=Link.getConnection();
        String sql="update doctor set photo=? where id='"+value+"'";
        try{
            st=con.prepareStatement(sql);
            st.setBytes(1,person_image);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successfully");
            jPrevious.setVisible(false);
            jSubmit.setVisible(false);
            submit_check=0;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jSubmitMouseClicked

    private void jChangeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChangeMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jChange.setCursor(cur1);
    }//GEN-LAST:event_jChangeMouseMoved

    private void jChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChangeMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser=new JFileChooser();
        FileNameExtensionFilter filter;
        filter = new FileNameExtensionFilter("jpeg, jpg, gif and png files", "jpeg", "jpg", "gif", "png");
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(filter);
        chooser.showOpenDialog(null);

        File f = chooser.getSelectedFile();
        if (f == null) {
            filename= "";
        }
        else {
            filename = f.getAbsolutePath();
            ImageIcon imageIcon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(jImage.getWidth(),jImage.getHeight(),Image.SCALE_SMOOTH));
            jImage.setIcon(imageIcon);
            try{
                File image=new File(filename);
                FileInputStream fis=new FileInputStream(image);
                ByteArrayOutputStream bos=new ByteArrayOutputStream();
                byte[] buf=new byte[1024];
                for(int readNum;(readNum=fis.read(buf))!=-1;){
                    bos.write(buf, 0, readNum);
                }
                person_image=bos.toByteArray();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
        submit_check=1;
        jPrevious.setVisible(true);
        jSubmit.setVisible(true);
    }//GEN-LAST:event_jChangeMouseClicked

    private void jPreviousMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPreviousMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jPrevious.setCursor(cur1);
    }//GEN-LAST:event_jPreviousMouseMoved

    private void jPreviousMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPreviousMouseClicked
        // TODO add your handling code here:
        byte[] imageBytes;
        Image image;
        Connection con = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        con = Link.getConnection();
        String sql="select photo from doctor where id='"+value+"'";
        try{
            st=con.prepareStatement(sql);
            rs=st.executeQuery();

            while(rs.next()){
                try{
                    imageBytes=rs.getBytes("photo");
                    image=getToolkit().createImage(imageBytes);
                    ImageIcon icon=new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(jImage.getWidth(),jImage.getHeight(),Image.SCALE_SMOOTH));
                    jImage.setIcon(icon);
                    jPrevious.setVisible(false);
                    jSubmit.setVisible(false);
                }catch(Exception e){
                    jImage.setIcon(null);
                    jPrevious.setVisible(false);
                    jSubmit.setVisible(false);
                }               
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jPreviousMouseClicked

    private void jViewProfileMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewProfileMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jViewProfile.setCursor(cur1);
    }//GEN-LAST:event_jViewProfileMouseMoved

    private void jViewProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jViewProfileMouseClicked
        // TODO add your handling code here:
        ViewDoctor view=new ViewDoctor(id);
        view.setVisible(true);
        dispose();
    }//GEN-LAST:event_jViewProfileMouseClicked

    private void jBackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jBack.setCursor(cur1);
    }//GEN-LAST:event_jBackMouseMoved

    private void jBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMouseClicked
        // TODO add your handling code here:
        check=1;
        AdminPanel panel=new AdminPanel(id);
        panel.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBackMouseClicked

    private void jSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSaveMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jSave.setCursor(cur1);
    }//GEN-LAST:event_jSaveMouseMoved

    private void jSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSaveMouseClicked
        // TODO add your handling code here:
        Connection con=null;
        PreparedStatement st=null;
        con=Link.getConnection();
        String sql="update doctor set name=?,surname=?,age=?,specialization=?,gender=?,blood=?,address=?,city=?,phone=?,NIC=?,email=?,joining=?,full_name=? where id='"+value+"'";
        try{
            st=con.prepareStatement(sql);
            st.setString(1,jFirst.getText());
            st.setString(2,jLast.getText());
            st.setString(3,jAge.getText());
            st.setString(4,jSpecial.getText());
            st.setString(5,jGender.getText());
            st.setString(6,jBlood.getText());
            st.setString(7,jAddress.getText());
            st.setString(8,jCity.getText());
            st.setString(9,jPhone.getText());
            st.setString(10,jNIC.getText());
            st.setString(11,jEmail.getText());
            st.setString(12,jDate.getText());
            st.setString(13,jFirst.getText()+" "+jLast.getText());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successfully");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jSaveMouseClicked

    private void jSearchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jSearch.setCursor(cur1);
    }//GEN-LAST:event_jSearchMouseMoved

    private void jSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSearchMouseClicked
        // TODO add your handling code here:
        jBack.setVisible(false);
        jSearch.setVisible(false);
        jChange.setVisible(false);
        jSave.setVisible(false);
        jPrevious.setVisible(false);
        jSubmit.setVisible(false);
        jMenuBar2.setVisible(false);
        JFrame frame=this.getClosed();
        JLabel label=this.getReturn();
        JLabel label2=this.getBack();
        JLabel label3=this.getChange();
        JLabel label4=this.getSave();
        JLabel label5=this.getPrevious();
        JLabel label6=this.getSubmit();
        JMenuBar menubar=this.getMenu();
        String check="update";
        DoctorList list = new DoctorList(id,check,submit_check,frame,label,label2,label3,label4,label5,label6,menubar);
        list.setVisible(true);
    }//GEN-LAST:event_jSearchMouseClicked

    private void jInsertProfileMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jInsertProfileMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jInsertProfile.setCursor(cur1);
    }//GEN-LAST:event_jInsertProfileMouseMoved

    private void jInsertProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jInsertProfileMouseClicked
        // TODO add your handling code here:
        InsertDoctor insert=new InsertDoctor(id);
        insert.setVisible(true);
        dispose();
    }//GEN-LAST:event_jInsertProfileMouseClicked

    private void jUpdateProfileMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateProfileMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jUpdateProfile.setCursor(cur1);
    }//GEN-LAST:event_jUpdateProfileMouseMoved

    private void jUpdateProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUpdateProfileMouseClicked
        // TODO add your handling code here:
        UpdateDoctor update = new UpdateDoctor(id);
        update.setVisible(true);
        dispose();
    }//GEN-LAST:event_jUpdateProfileMouseClicked

    private void jTimeTableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTimeTableMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jTimeTable.setCursor(cur1);
    }//GEN-LAST:event_jTimeTableMouseMoved

    private void jTimeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTimeTableMouseClicked
        // TODO add your handling code here:
        ViewDoctorTimeTable timetable=new ViewDoctorTimeTable(id);
        timetable.setVisible(true);
        dispose();
    }//GEN-LAST:event_jTimeTableMouseClicked

    private void jCloseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCloseMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jClose.setCursor(cur1);
    }//GEN-LAST:event_jCloseMouseMoved

    private void jCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCloseMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jCloseMouseClicked

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

    private void jHomeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMouseMoved
        // TODO add your handling code here:
        Cursor cur1=new Cursor(Cursor.HAND_CURSOR);
        jHome.setCursor(cur1);
    }//GEN-LAST:event_jHomeMouseMoved

    private void jHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMouseClicked
        // TODO add your handling code here:
        AdminPanel panel = new AdminPanel(id);
        panel.setVisible(true);
        dispose();
    }//GEN-LAST:event_jHomeMouseClicked

    private void jAgeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jAgeKeyReleased
        // TODO add your handling code here:
        String age = jAge.getText();
        if(!(evt.getKeyCode()==KeyEvent.VK_ENTER) && !age.isEmpty()){
            if (!age.matches("[0-9]+")) {
           JOptionPane.showMessageDialog(null,"Please Enter Numbers Only","Error",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jAgeKeyReleased

    private void jNICFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jNICFocusLost
        // TODO add your handling code here:
        String NIC = jNIC.getText();
        if(!((Pattern.matches("[0-9]{9}[vVxX]$", NIC)) || (Pattern.matches("[0-9]{12}$", NIC))) && check==0){
            JOptionPane.showMessageDialog(null,"Please Enter Valid NIC Number");
            jNIC.setText("");
        } 
    }//GEN-LAST:event_jNICFocusLost

    private void jEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jEmailFocusLost
        // TODO add your handling code here:
        String email = jEmail.getText();
        if(!(Pattern.matches("^[A-Za-z0-9]+[@]{1}+[A-Za-z0-9]+[.]{1}+[A-Za-z]+$", email)) && check==0){
            JOptionPane.showMessageDialog(null,"Please Enter Valid Email Address");
            jEmail.setText("");
        }
    }//GEN-LAST:event_jEmailFocusLost

    private void jPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPhoneKeyReleased
        // TODO add your handling code here:
        String phone = jPhone.getText();
        if(!(evt.getKeyCode()==KeyEvent.VK_ENTER) && !phone.isEmpty()){
            if(phone.length()<=10){
                if (!phone.matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null,"Please Enter Numbers Only (XXXXXXXXXX)");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Phone Number Lenght(<=10) Reached (XXXXXXXXXX)");
            }      
        }
    }//GEN-LAST:event_jPhoneKeyReleased

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
            java.util.logging.Logger.getLogger(UpdateDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAddress;
    private javax.swing.JTextField jAge;
    private javax.swing.JLabel jBack;
    private javax.swing.JTextField jBlood;
    private javax.swing.JLabel jChange;
    private javax.swing.JTextField jCity;
    private javax.swing.JLabel jClose;
    private javax.swing.JTextField jDate;
    private javax.swing.JTextField jEmail;
    private javax.swing.JTextField jFirst;
    private javax.swing.JTextField jGender;
    private javax.swing.JLabel jHome;
    private javax.swing.JLabel jImage;
    private javax.swing.JMenu jInsertProfile;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLast;
    private javax.swing.JLabel jLogout;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JTextField jNIC;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPhone;
    private javax.swing.JLabel jPrevious;
    private javax.swing.JLabel jSave;
    private javax.swing.JLabel jSearch;
    private javax.swing.JTextField jSpecial;
    private javax.swing.JLabel jSubmit;
    private javax.swing.JMenu jTimeTable;
    private javax.swing.JMenu jUpdateProfile;
    private javax.swing.JMenu jViewProfile;
    // End of variables declaration//GEN-END:variables
}