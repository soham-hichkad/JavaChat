/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactproject;

import java.awt.BorderLayout;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 *
 * @author SOHAM
 */
public class NewJFrame1 extends javax.swing.JFrame {

    public NewJFrame1(String uid) {
        initComponents();

        int count = 0;
        this.setLayout(new FlowLayout());

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-OSE1P7NI:1433", "sa", "1234");

            ResultSet rscount;
            Statement s = con.createStatement();
            s.execute("use PROFILECONTACT");
            rscount = s.executeQuery("select count(*) as count from ALLCONTACTS");
            if (rscount.next()) {
                JLabel label = new JLabel();
                count = rscount.getInt("count");
                label.setText("ALL CONTACTS : " + count);
                this.add(label);
            }

            ResultSet rss;

            s.execute("use PROFILECONTACT");
            rss = s.executeQuery("Select * from ALLCONTACTS");
            Box box = Box.createVerticalBox();

           JScrollPane scroll = new JScrollPane(box,  
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            box.setSize(this.getSize());
             
            while (rss.next()) {
                JLabel l = new JLabel();
                JButton t = new JButton();
                JPanel panel = new JPanel();

                
                this.setSize(250,box.getHeight());
                t.addActionListener(new ActionListener() {
                  
                    @Override
                    public void actionPerformed(ActionEvent e) {
                         JButton b = (JButton) e.getSource();
                          
                         ALLCONNTACTEDIT frame2 = new ALLCONNTACTEDIT(b.getText(), uid);
                          
                            frame2.setLocation(t.getLocationOnScreen());
                            frame2.setVisible(true);
                           
                          
                        
                    }

                });
                panel.addMouseListener(new MouseAdapter()  {
            JFrame frame2;
        public void mouseEntered(MouseEvent e){
           panel.setBackground(Color.GREEN); 
        }
        
        public void mouseExited(MouseEvent e) {
        
        panel.setBackground(Color.BLACK);
        }
    }); 
                l.addMouseListener(new MouseAdapter() {
                    JFrame frame2;

                    public void mouseEntered(MouseEvent e) {
                        JLabel label = new JLabel();

                        frame2 = new JFrame();
                        frame2.setLayout(new FlowLayout());
                        frame2.setSize(3 * l.getIcon().getIconWidth() / 2, 3 * l.getIcon().getIconHeight() / 2);
                        frame2.setVisible(true);
                        frame2.setLocation(e.getX(), e.getY());
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

              

                //panel.setSize(box.getWidth(), 57);
                // t.setSize(panel.getWidth(), 100);
                l.setSize(box.getWidth() / 4, 50);
                byte[] img = rss.getBytes("photojpg");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myimg = im.getScaledInstance(l.getWidth(), l.getWidth(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myimg);

                l.setVisible(true);
                t.setVisible(true);
                l.setIcon(newImage);
                t.setText(rss.getString("userid"));

                panel.add(l);
                panel.add(t);
                panel.validate();
               box.add(panel); 

            }
             scroll.setViewportView(box);
            this.add(scroll);
         scroll.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
            rss.close();
            rscount.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

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
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewJFrame1 frame = new NewJFrame1("soham@97");
                frame.setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
