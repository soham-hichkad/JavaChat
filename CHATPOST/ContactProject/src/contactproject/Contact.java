/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author SOHAM
 */
public class Contact extends javax.swing.JFrame {
String userid;
Connection con;
int count;
int chatno=0;
    /**
     * Creates new form Contact
     */
 

    Contact(String uid) {
        initComponents();
         try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con=DriverManager.getConnection("jdbc:sqlserver://LAPTOP-OSE1P7NI:1433","sa","1234");
    } catch (SQLException |ClassNotFoundException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    try {
        this.userid=uid;
        ResultSet rscount;
        Statement s=con.createStatement();
        Statement ss=con.createStatement();
        this.setLayout(new FlowLayout());
        Box box =Box.createVerticalBox();
        s.execute("use PROFILECONTACT");
           this.setLayout(new FlowLayout());
           JScrollPane scroll = new JScrollPane(box,  
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         
        rscount=s.executeQuery("select count(*) as count from "+userid+";");
        if(rscount.next())
        {
           JLabel label= new JLabel();
            count=rscount.getInt("count");
           label.setText("MY CONTACTS : "+count);
           label.setVisible(true);
           this.add(label);
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane,"CONNECTION FAILED !!!");
            this.setVisible(false);
        }
     
       ResultSet rss;
        if(count>0)
        {
        rss=ss.executeQuery("Select * from "+userid);
          
        while(rss.next())
        {
             ResultSet rs=s.executeQuery("select * from ALLCONTACTS where userid='"+rss.getString("userid")+"'");
            if(rs.next())
            {   
              JLabel l= new JLabel();
            JButton t= new JButton();
            JButton chat = new JButton();
           JPanel panel= new JPanel();
           
          
           
            t.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton b=(JButton) e.getSource();
                ALLCONNTACTEDIT frame2 = new ALLCONNTACTEDIT(b.getText(),uid);
                 
                frame2.setLocation(t.getLocation());
                  
                }
                
         
            });
            chat.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton b=(JButton) e.getSource();
                  
                  ChatServer newchat = new ChatServer(chatno,b.getText());
                  newchat.setVisible(true);
                }
                
         
            });
        l.addMouseListener(new MouseAdapter()  {
            JFrame frame2;
        public void mouseEntered(MouseEvent e){
             JLabel label = new JLabel();
            
             frame2 = new JFrame();
             frame2.setLayout(new FlowLayout());
             frame2.setSize(3*l.getIcon().getIconWidth()/2,3*l.getIcon().getIconHeight()/2);
             frame2.setVisible(true);
             frame2.setLocation(e.getX(),e.getY());
             frame2.add(label);
              
              label.setVisible(true);
             
              label.setIcon(l.getIcon());
               label.setSize(frame2.getSize());
                
              frame2.add(label);
              
            
        }
        
        public void mouseExited(MouseEvent e) {
        
        frame2.setVisible(false);
        }
    }); 
            panel.setBackground(Color.BLACK);
            panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white)));
        panel.addMouseListener(new MouseAdapter()  {
            JFrame frame2;
        public void mouseEntered(MouseEvent e){
           panel.setBackground(Color.GREEN); 
        }
        
        public void mouseExited(MouseEvent e) {
        
        panel.setBackground(Color.BLACK);
        }
    }); 
           
          
         
            byte[] img = rs.getBytes("photojpg");
            ImageIcon image = new ImageIcon(img);
            Image im =image.getImage();
            Image  myimg = im.getScaledInstance(100,100, Image.SCALE_SMOOTH);
            ImageIcon newImage= new ImageIcon(myimg);
         
            
            
            l.setVisible(true);
            t.setVisible(true);
            l.setIcon(newImage);
            t.setText(rs.getString("userid"));
         
             panel.add(l);
             chat.setSize(50, 50);
             chat.setText("CHAT");
             panel.add(t);
             panel.add(chat);
             panel.validate();
             
             box.add(panel);
             
           ResultSet birthday;
           Statement as=con.createStatement();
           //birthday=as.executeQuery("select userid from ");
           // JOptionPane.showMessageDialog(rootPane, birthday.getString("userid"));
           as.close();
           
            }
             rs.close();
       }
        scroll.setViewportView(box);
        this.add(scroll);
        
        this.setSize(300,400);
        rss.close();
        scroll.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
        }
        else
        {
          JOptionPane.showMessageDialog(null, "NO FRIENDS");
        }
        
        rscount.close();
        
     }catch (SQLException ex ) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Contact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contact.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Contact("soham@97").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
