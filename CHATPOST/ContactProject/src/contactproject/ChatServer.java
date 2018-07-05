
package contactproject;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ChatServer extends javax.swing.JFrame {
int chatno; 
String chatname;
    public ChatServer(int chatno,String chatname) {
        this.chatno=chatno;
        this.chatname=chatname;
        this.setTitle("You are chatting with "+chatname);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        
        getContentPane().setBackground(new Color(212,208,200));
        initComponents();
    }

    
   
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        btnStartServer = new javax.swing.JButton();
        lblServerStatus = new javax.swing.JLabel();
        scpClientStatus = new javax.swing.JScrollPane();
        txaClientStatus = new javax.swing.JTextArea();
        scpClient = new javax.swing.JScrollPane();
        lstClient = new javax.swing.JList();
        pnlBroadCastMessage = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        btnBroadCastMessage = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.FlowLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Server");
        setResizable(false);
        btnStartServer.setText("Start Server");
        btnStartServer.setPreferredSize(new java.awt.Dimension(150, 23));
        btnStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServerActionPerformed(evt);
            }
        });

        getContentPane().add(btnStartServer);

        lblServerStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblServerStatus.setText("Logged In");
        lblServerStatus.setPreferredSize(new java.awt.Dimension(180, 20));
        getContentPane().add(lblServerStatus);

        scpClientStatus.setPreferredSize(new java.awt.Dimension(300, 150));
        txaClientStatus.setColumns(20);
        txaClientStatus.setEditable(false);
        txaClientStatus.setRows(5);
        scpClientStatus.setViewportView(txaClientStatus);

        getContentPane().add(scpClientStatus);

        scpClient.setPreferredSize(new java.awt.Dimension(130, 150));
        lstClient.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstClient.setEnabled(false);
        scpClient.setViewportView(lstClient);

        getContentPane().add(scpClient);

        pnlBroadCastMessage.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        pnlBroadCastMessage.setPreferredSize(new java.awt.Dimension(430, 50));
        lblMessage.setText("Message:");
        lblMessage.setPreferredSize(new java.awt.Dimension(70, 20));
        pnlBroadCastMessage.add(lblMessage);

        txtMessage.setPreferredSize(new java.awt.Dimension(200, 20));
        pnlBroadCastMessage.add(txtMessage);

        btnBroadCastMessage.setText("BroadCast Message");
        btnBroadCastMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBroadCastMessageActionPerformed(evt);
            }
        });

        pnlBroadCastMessage.add(btnBroadCastMessage);

        getContentPane().add(pnlBroadCastMessage);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-457)/2, (screenSize.height-275)/2, 457, 275);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnBroadCastMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroadCastMessageActionPerformed
// TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String strMessage;
                strMessage = txtMessage.getText();
                ps.println(strMessage);
                txtMessage.setText("");
            }
        });
    }//GEN-LAST:event_btnBroadCastMessageActionPerformed
    
    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartServerActionPerformed
// TODO add your handling code here:
        blnServerStarted = true;
        btnStartServer.setEnabled(false);
        new ServerThread().start();
    }//GEN-LAST:event_btnStartServerActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatServer(0,"soham@97").setVisible(true);
            }
        });
    }
    
    class ServerThread extends Thread {
        String strMsg = "";
        boolean blnSignIn;
        boolean blnConnect;
        int index = 0;
        public ServerThread() {
            try {
                server = new ServerSocket(8080+chatno);
            } catch (IOException ex) {
                ex.printStackTrace();
                
            }
        }
        
        public void run() {
            while (true) {
                if (!blnConnect) {
                    try {
                        client = server.accept();
                        ps = new PrintStream(client.getOutputStream());
                        br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        blnConnect = true;
                        blnSignIn  = false;
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,"Error occured. Contact Vendor","Warning !",JOptionPane.WARNING_MESSAGE);
                    }
                }
                try {
                    if ((strMsg = br.readLine()) != null) {
                        if (!blnSignIn) {
                            vecUsers.addElement(strMsg);
                            lstClient.setListData(vecUsers);
                            blnSignIn = true;
                        } else
                            txaClientStatus.append(strMsg+"\n");
                    }
                } catch (Exception ex) {
                    blnConnect = false;
                }
                
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBroadCastMessage;
    private javax.swing.JButton btnStartServer;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblServerStatus;
    private javax.swing.JList lstClient;
    private javax.swing.JPanel pnlBroadCastMessage;
    private javax.swing.JScrollPane scpClient;
    private javax.swing.JScrollPane scpClientStatus;
    private javax.swing.JTextArea txaClientStatus;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables
    static ServerSocket server;
    Socket client;
    DataInputStream dis;
    BufferedReader br;
    PrintStream ps;
    String strMessage = "";
    static boolean blnServerStarted = false;
    String s = "";
    Vector vecUsers = new Vector();
}
