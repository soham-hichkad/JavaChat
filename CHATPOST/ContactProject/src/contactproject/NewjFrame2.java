/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactproject;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author SOHAM
 */
public class NewjFrame2 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame2
     */
   Connection con;
    String userid;
    String password;
    String path="src\\contactproject\\contactimages.png";
    public NewjFrame2() {
        initComponents();
        jLayeredPane1.setEnabled(false);
    
         photo.setEnabled(true);
             fullname.setEditable(false);
             changepassword.setVisible(false);
             addphoto.setEnabled(false);
             jLabel1.setEnabled(true);
              jLabel2.setEnabled(true);
               jLabel3.setEnabled(true);
                jLabel4.setEnabled(true);
                setforgetpassword.setEnabled(false);
                 jLabel5.setEnabled(true);
                  jLabel6.setEnabled(true);
                  jDateChooser1.setEnabled(false);
                  email.setEditable(false);
                  phone.setEditable(false);
                  address.setEditable(false);
                  notes.setEditable(false);
                  profileuserid.setEditable(true);
                  Profileforgetpassword.setEditable(false);
              JOptionPane.showMessageDialog(null,"Please follow the steps\n1.\tFill new userid and click EDIT\n2.\tFill out the details and forget password\n3.\tClick SAVE and SET FORGET PASSWORD.\n4.\tPlease change your Password your default password is ***** \n5.\tIt is mandatory to change forget password when ever you login");
                  userid="00000";
                  password="*****";
                     try{
       
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       con=DriverManager.getConnection("jdbc:sqlserver://LAPTOP-OSE1P7NI:1433","sa","1234");
       Statement s = con.createStatement();
        s.execute("use PROFILECONTACT");
        
    } catch (SQLException |ClassNotFoundException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
              
        
    }

    NewjFrame2(String userid, String password) {
        initComponents();
        this.userid=userid;
        this.password=password;
         jLayeredPane1.setEnabled(false);
         photo.setEnabled(true);
             fullname.setEditable(false);
             
             addphoto.setEnabled(false);
             jLabel1.setEnabled(true);
              jLabel2.setEnabled(true);
               jLabel3.setEnabled(true);
                jLabel4.setEnabled(true);
                 jLabel5.setEnabled(true);
                  jLabel6.setEnabled(true);
                  jDateChooser1.setEnabled(false);
                  email.setEditable(false);
                  phone.setEditable(false);
                  address.setEditable(false);
                  notes.setEditable(false);
                  profileuserid.setEditable(false);
                  Profileforgetpassword.setEnabled(true);
                  setforgetpassword.setEnabled(false);
                   Profileforgetpassword.setEditable(false);
                     try{
      
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       con=DriverManager.getConnection("jdbc:sqlserver://LAPTOP-OSE1P7NI:1433","sa","1234");
    } catch (SQLException |ClassNotFoundException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
         
        ResultSet rs,rscount;
        Statement s;
        try {
            s = con.createStatement();
            s.execute("use PROFILECONTACT");
            
            rscount=s.executeQuery("select count(*) as count from "+userid+";");
            if(rscount.next())
            {
            friends.setText(String.valueOf(rscount.getInt("count")));
            }
            rs=s.executeQuery("select * from ALLCONTACTS  where userid='"+userid+"' and password='"+password+"';");
            if(rs.next())
            {
             profileuserid.setText(rs.getString("userid"));
             fullname.setText(rs.getString("fullname"));
             phone.setText(rs.getString("phone"));
             address.setText(rs.getString("address"));
             //jDateChooser1.setDateFormatString(rs.getString("dob"));
             String dt=rs.getString("dob");
            Date d=Date.valueOf(dt);
            System.out.println(dt);
            jDateChooser1.setDate(d);
             email.setText(rs.getString("email"));
             notes.setText(rs.getString("notes"));
       
                byte[] img = rs.getBytes("photojpg");
                ImageIcon image = new ImageIcon(img);
                Image im =image.getImage();
                Image  myimg = im.getScaledInstance(photo.getWidth(), photo.getHeight(), Image.SCALE_SMOOTH);
                if(myimg!=null)
                {    
                ImageIcon newImage= new ImageIcon(myimg);
                photo.setIcon(newImage);
                }
                else
                {
                ImageIcon  newImage = new ImageIcon("C:\\Users\\SOHAM\\Documents\\NetBeansProjects\\ContactProject\\src\\contactproject\\contactimages.png");
                photo.setIcon(newImage);
                }
            }
            viewallcontact.setVisible(true);
            viewallcontact.setEnabled(true);
            viewcontact.setVisible(true);
            viewcontact.setEnabled(true);
            rs.close();
            rscount.close();
        } catch (SQLException ex) {
            Logger.getLogger(NewjFrame2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ImageIcon ResizeImage(String Imagepath)
{
ImageIcon MyImage = new ImageIcon(Imagepath);
Image img=MyImage.getImage();
Image newImg =img.getScaledInstance(photo.getWidth(), photo.getHeight(), Image.SCALE_SMOOTH);
ImageIcon image = new ImageIcon(newImg);
return image;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        photo = new javax.swing.JLabel();
        addphoto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fullname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        notes = new javax.swing.JTextArea();
        viewcontact = new javax.swing.JButton();
        viewallcontact = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        profileuserid = new javax.swing.JTextField();
        changepassword = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        friends = new javax.swing.JTextField();
        setforgetpassword = new javax.swing.JButton();
        Profileforgetpassword = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToggleButton1.setText("EDIT");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLayeredPane1.setForeground(new java.awt.Color(0, 0, 255));

        photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contactproject/contactimages.png"))); // NOI18N
        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLayeredPane1.add(photo);
        photo.setBounds(33, 12, 227, 213);

        addphoto.setText("Add Photo");
        addphoto.setEnabled(false);
        addphoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addphotoActionPerformed(evt);
            }
        });
        jLayeredPane1.add(addphoto);
        addphoto.setBounds(33, 243, 227, 33);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("      NAME     :");
        jLayeredPane1.add(jLabel1);
        jLabel1.setBounds(278, 30, 87, 32);

        fullname.setEditable(false);
        fullname.setText("Type your NAME here.......");
        jLayeredPane1.add(fullname);
        fullname.setBounds(398, 32, 499, 32);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("     PHONE   :");
        jLayeredPane1.add(jLabel2);
        jLabel2.setBounds(278, 105, 87, 32);

        phone.setEditable(false);
        phone.setText("Type your PHONE here.......");
        jLayeredPane1.add(phone);
        phone.setBounds(398, 107, 244, 32);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("   EMAIL ID  :");
        jLayeredPane1.add(jLabel3);
        jLabel3.setBounds(278, 175, 87, 32);

        email.setEditable(false);
        email.setText("Type your EMAIL ID here.......");
        jLayeredPane1.add(email);
        email.setBounds(398, 177, 406, 32);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("   ADDRESS  :");
        jLayeredPane1.add(jLabel4);
        jLabel4.setBounds(80, 310, 87, 32);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("DATE OF BIRTH  :");
        jLayeredPane1.add(jLabel5);
        jLabel5.setBounds(278, 252, 120, 32);

        address.setEditable(false);
        address.setColumns(20);
        address.setRows(5);
        address.setText("Type yout ADDRESS here.....");
        jScrollPane1.setViewportView(address);

        jLayeredPane1.add(jScrollPane1);
        jScrollPane1.setBounds(270, 320, 504, 110);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("   NOTES  :");
        jLayeredPane1.add(jLabel6);
        jLabel6.setBounds(90, 460, 87, 32);

        notes.setEditable(false);
        notes.setColumns(20);
        notes.setRows(5);
        notes.setText("Type yout NOTES here.....");
        jScrollPane3.setViewportView(notes);

        jLayeredPane1.add(jScrollPane3);
        jScrollPane3.setBounds(270, 460, 504, 110);

        viewcontact.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewcontact.setText("VIEW MY CONTACT");
        viewcontact.setEnabled(false);
        viewcontact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewcontactActionPerformed(evt);
            }
        });
        jLayeredPane1.add(viewcontact);
        viewcontact.setBounds(160, 590, 230, 31);

        viewallcontact.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewallcontact.setText("VIEW ALL CONTACT");
        viewallcontact.setEnabled(false);
        viewallcontact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewallcontactActionPerformed(evt);
            }
        });
        jLayeredPane1.add(viewallcontact);
        viewallcontact.setBounds(430, 590, 270, 31);

        jDateChooser1.setDateFormatString("yyyy,d,MM");
        jLayeredPane1.add(jDateChooser1);
        jDateChooser1.setBounds(400, 260, 130, 30);

        jLabel8.setText("     USER ID   :");

        profileuserid.setEditable(false);

        changepassword.setText("CHANGE PASSWORD");
        changepassword.setEnabled(false);
        changepassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changepasswordActionPerformed(evt);
            }
        });

        jLabel7.setText("FRIENDS    :");

        friends.setEditable(false);
        friends.setText("0");

        setforgetpassword.setText("SET FORGET PASSWORD");
        setforgetpassword.setEnabled(false);
        setforgetpassword.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                setforgetpasswordMouseMoved(evt);
            }
        });
        setforgetpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setforgetpasswordActionPerformed(evt);
            }
        });

        Profileforgetpassword.setEditable(false);
        Profileforgetpassword.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profileuserid, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(changepassword)
                        .addGap(30, 30, 30)
                        .addComponent(Profileforgetpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setforgetpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(friends, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLayeredPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(friends, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(profileuserid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(changepassword)
                        .addComponent(Profileforgetpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(setforgetpassword)))
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        boolean flag=false;
        if(jToggleButton1.isSelected())
        {

            jToggleButton1.setText("SAVE");
            jLayeredPane1.setEnabled(true);
            photo.setEnabled(true);
            fullname.setEditable(true);

            addphoto.setEnabled(true);
            jLabel1.setEnabled(true);
            jLabel2.setEnabled(true);
            jLabel3.setEnabled(true);
            jLabel4.setEnabled(true);
            jLabel5.setEnabled(true);
            jLabel6.setEnabled(true);
            jDateChooser1.setEnabled(true);
            email.setEditable(true);
            phone.setEditable(true);
            address.setEditable(true);
            notes.setEditable(true);
            profileuserid.setEditable(false);
            Profileforgetpassword.setEditable(true);
            Profileforgetpassword.setEnabled(true);

            if(flag==true)
            {
                changepassword.setEnabled(true);
            }
            if(userid.equals("00000")&&password.equals("*****"))
            {
                profileuserid.setEditable(true);
            }
        }
        else
        {
            try {
                jToggleButton1.setText("EDIT");
                jLayeredPane1.setEnabled(false);
                photo.setEnabled(true);
                fullname.setEditable(false);
                Profileforgetpassword.setEditable(true);
                setforgetpassword.setEnabled(false);
                addphoto.setEnabled(false);
                jLabel1.setEnabled(true);
                jLabel2.setEnabled(true);
                jLabel3.setEnabled(true);
                jLabel4.setEnabled(true);
                jLabel5.setEnabled(true);
                jLabel6.setEnabled(true);
                setforgetpassword.setEnabled(true);

                jDateChooser1.setEnabled(false);
                email.setEditable(false);
                phone.setEditable(false);
                address.setEditable(false);
                notes.setEditable(false);
                profileuserid.setEditable(false);
                flag = true;

                if(userid.equals("00000")&&password.equals("*****"))
                {
                    changepassword.setVisible(false);
                    Profileforgetpassword.setEnabled(true);
                    java.sql.Date d=new java.sql.Date(jDateChooser1.getDate().getTime());
                    Statement s=con.createStatement();
                    s.executeUpdate("use PROFILECONTACT");
                    s.executeUpdate("insert into ALLCONTACTS ( userid , fullname , phone, email , address , notes , dob ) values ('"+profileuserid.getText()+"', '"+fullname.getText()+"', '"+phone.getText()+"', '"+email.getText()+"', '"+address.getText()+"', '"+notes.getText()+"', '"+d.toString()+"');");

                    s.executeUpdate("create table "+profileuserid.getText()+" ( userid varchar(max) )");
                    s.executeUpdate("Update ALLCONTACTS  set password='"+password+"' where userid='"+profileuserid.getText()+"';");
                    PreparedStatement pstmt = con.prepareStatement("Update  ALLCONTACTS set photojpg =? where userid='"+profileuserid.getText()+"';");
                    JOptionPane.showMessageDialog(null," Again LOGIN and change your password \n(Default password : *****");
                    FileInputStream inStream = null;
                    try {
                        inStream = new FileInputStream(new File(path));
                        pstmt.setBinaryStream(1, inStream);
                        pstmt.executeUpdate();
                        inStream.close();
                    } catch (IOException  ex) {
                        Logger.getLogger(NewjFrame2.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                else
                {
                    Statement s=con.createStatement();
                    java.sql.Date d=new java.sql.Date(jDateChooser1.getDate().getTime());
                     Profileforgetpassword.setEnabled(true);
                    s.executeUpdate("use PROFILECONTACT");
                    s.executeUpdate("Update ALLCONTACTS  set fullname='"+fullname.getText()+"' where userid='"+profileuserid.getText()+"';");
                    s.executeUpdate("Update ALLCONTACTS  set phone='"+phone.getText()+"' where userid='"+profileuserid.getText()+"';");
                    s.executeUpdate("Update ALLCONTACTS  set email='"+email.getText()+"' where userid='"+profileuserid.getText()+"';");
                    s.executeUpdate("Update ALLCONTACTS  set address='"+address.getText()+"' where userid='"+profileuserid.getText()+"';");
                    s.executeUpdate("Update ALLCONTACTS  set notes='"+notes.getText()+"' where userid='"+profileuserid.getText()+"';");
                    s.executeUpdate("Update ALLCONTACTS  set dob='"+d.toString()+"' where userid='"+profileuserid.getText()+"';");
                    PreparedStatement pstmt = con.prepareStatement("Update  ALLCONTACTS set photojpg =? where userid='"+profileuserid.getText()+"';");

                    FileInputStream inStream = null;
                    try {
                        inStream = new FileInputStream(new File(path));
                        pstmt.setBinaryStream(1, inStream);
                        pstmt.executeUpdate();
                        inStream.close();
                    } catch (IOException  ex) {
                        Logger.getLogger(NewjFrame2.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    s.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NewjFrame2.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void addphotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addphotoActionPerformed
        JFileChooser chooseimg = new JFileChooser();
        chooseimg.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images","ipg","gif","png");
        chooseimg.addChoosableFileFilter(filter);
        int result = chooseimg.showSaveDialog(null);

        if(result==JFileChooser.APPROVE_OPTION)
        {
            File selectedfile =chooseimg.getSelectedFile();
            path = selectedfile.getAbsolutePath();
            photo.setIcon(ResizeImage(path));
        }
        else if(result==JFileChooser.CANCEL_OPTION)
        {
            JOptionPane.showConfirmDialog(null, "NO FILE SELECTED");
        }
    }//GEN-LAST:event_addphotoActionPerformed

    private void viewcontactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewcontactActionPerformed

        Contact frame2 = new Contact(profileuserid.getText());
        frame2.setVisible(true);

    }//GEN-LAST:event_viewcontactActionPerformed

    private void viewallcontactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewallcontactActionPerformed
        NewJFrame1 frame4 = new NewJFrame1(profileuserid.getText());
        frame4.setVisible(true);
    }//GEN-LAST:event_viewallcontactActionPerformed

    private void changepasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changepasswordActionPerformed
        changepassword frame4 = new changepassword(profileuserid.getText());
        frame4.setVisible(true);

        viewcontact.setEnabled(true);
        viewallcontact.setEnabled(true);
    }//GEN-LAST:event_changepasswordActionPerformed

    private void setforgetpasswordMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setforgetpasswordMouseMoved

    }//GEN-LAST:event_setforgetpasswordMouseMoved

    private void setforgetpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setforgetpasswordActionPerformed
        try {
            Statement s=con.createStatement();
            s.executeUpdate("use PROFILECONTACT");
            s.executeUpdate("Update ALLCONTACTS set forgetpassword='"+Profileforgetpassword.getText()+"' where userid='"+profileuserid.getText()+"';");
            changepassword.setEnabled(true);
            Profileforgetpassword.setEditable(true);
            viewallcontact.setEnabled(true);
            viewcontact.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(NewjFrame2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_setforgetpasswordActionPerformed

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
            java.util.logging.Logger.getLogger(NewjFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewjFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewjFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewjFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewjFrame2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Profileforgetpassword;
    private javax.swing.JButton addphoto;
    private javax.swing.JTextArea address;
    private javax.swing.JButton changepassword;
    private javax.swing.JTextField email;
    private javax.swing.JTextField friends;
    private javax.swing.JTextField fullname;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextArea notes;
    private javax.swing.JTextField phone;
    private javax.swing.JLabel photo;
    private javax.swing.JTextField profileuserid;
    private javax.swing.JButton setforgetpassword;
    private javax.swing.JButton viewallcontact;
    private javax.swing.JButton viewcontact;
    // End of variables declaration//GEN-END:variables
}
