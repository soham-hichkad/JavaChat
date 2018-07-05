

package contactproject;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ChatClient extends javax.swing.JFrame {
int chatno;    
    /**
     * Creates new form ChatClient
     */
    public ChatClient(int chatno) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
             //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.Nimbus");
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
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlConnect = new javax.swing.JPanel();
        lblHeader1 = new javax.swing.JLabel();
        txtClientName = new javax.swing.JTextField();
        btnSignIn = new javax.swing.JButton();
        btnSignOut = new javax.swing.JButton();
        scpChattingpad = new javax.swing.JScrollPane();
        txaChattingpad = new javax.swing.JTextArea();
        pnlSendMessage1 = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        scpMessage = new javax.swing.JScrollPane();
        txaMessage = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Client");
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout());

        pnlConnect.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnlConnect.setPreferredSize(new java.awt.Dimension(350, 80));
        pnlConnect.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 12));

        lblHeader1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader1.setText("Give your name and then click Sign In button.");
        lblHeader1.setPreferredSize(new java.awt.Dimension(310, 20));
        pnlConnect.add(lblHeader1);

        txtClientName.setPreferredSize(new java.awt.Dimension(180, 20));
        pnlConnect.add(txtClientName);

        btnSignIn.setText("Sign In");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        pnlConnect.add(btnSignIn);

        btnSignOut.setText("Log Out");
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });
        pnlConnect.add(btnSignOut);

        getContentPane().add(pnlConnect);

        scpChattingpad.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        scpChattingpad.setPreferredSize(new java.awt.Dimension(350, 150));

        txaChattingpad.setEditable(false);
        txaChattingpad.setColumns(20);
        txaChattingpad.setRows(5);
        txaChattingpad.setPreferredSize(new java.awt.Dimension(160, 100));
        scpChattingpad.setViewportView(txaChattingpad);

        getContentPane().add(scpChattingpad);

        pnlSendMessage1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnlSendMessage1.setPreferredSize(new java.awt.Dimension(350, 70));
        pnlSendMessage1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessage.setText("Message:");
        lblMessage.setPreferredSize(new java.awt.Dimension(60, 20));
        pnlSendMessage1.add(lblMessage);

        scpMessage.setPreferredSize(new java.awt.Dimension(200, 40));

        txaMessage.setColumns(20);
        txaMessage.setEditable(false);
        txaMessage.setRows(5);
        scpMessage.setViewportView(txaMessage);

        pnlSendMessage1.add(scpMessage);

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        pnlSendMessage1.add(btnSend);

        getContentPane().add(pnlSendMessage1);

        setSize(new java.awt.Dimension(369, 347));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
// TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String strMessage;
                strMessage = txaMessage.getText();
                ps.println(strMessage);
                txaChattingpad.append(strMessage + "\n");
                txaMessage.setText("");
            }
        });
    }//GEN-LAST:event_btnSendActionPerformed
    
    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
// TODO add your handling code here:
        if (!txtClientName.getText().trim().equals("")) {
            clientThread = new ClientThread();
            clientThread.start();
        }else{
            JOptionPane.showMessageDialog(null,"User Name is not Given.");
        }
        txaMessage.setEditable(true);
    }//GEN-LAST:event_btnSignInActionPerformed
    
    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
// TODO add your handling code here:
        ps.println("Client has Signed out");
        ps.println("---------Waiting for a new client---------");
        System.exit(0);
    }//GEN-LAST:event_btnSignOutActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatClient(0).setVisible(true);
            }
        });
    }
    class ClientThread extends Thread {
        String strMsg = "";
        String strName = "";
        boolean blnConnect;
        int index = 0;
        public ClientThread() {
            try {
                server = new Socket(InetAddress.getLocalHost().getHostAddress(),8080+chatno);
                br = new BufferedReader(new InputStreamReader(server.getInputStream()));
                ps = new PrintStream(server.getOutputStream());
                strName = txtClientName.getText();
                ps.println(strName + " has logged in");
                txtClientName.setEditable(false);
                btnSignIn.setEnabled(false);
                blnConnect = true;
            } catch (UnknownHostException ex) {
                ex.printStackTrace();
                blnConnect = false;
            } catch (IOException ex) {
                ex.printStackTrace();
                blnConnect = false;
            }
        }
        
        public void run() {
            while (true) {
                if (blnConnect) {
                    try {
                        if ((strMsg = br.readLine()) != null) {
                            txaChattingpad.append(strMsg+"\n");
                        }
                    } catch (Exception ex) {
                        blnConnect = false;
                    }
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JLabel lblHeader1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JPanel pnlConnect;
    private javax.swing.JPanel pnlSendMessage1;
    private javax.swing.JScrollPane scpChattingpad;
    private javax.swing.JScrollPane scpMessage;
    private javax.swing.JTextArea txaChattingpad;
    private javax.swing.JTextArea txaMessage;
    private javax.swing.JTextField txtClientName;
    // End of variables declaration//GEN-END:variables
    Socket server;
    BufferedReader br;
    PrintStream ps;
    ClientThread clientThread;
}
