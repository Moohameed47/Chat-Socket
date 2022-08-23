package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import opration.Operation;
import server.calc;

public class Server extends javax.swing.JFrame {

    static ServerSocket ss;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;

    public Server() {
        initComponents();
        setSize(480, 691);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msg_area = new javax.swing.JTextArea();
        msg_text = new javax.swing.JTextField();
        msg_send = new javax.swing.JButton();
        Server = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        msg_area.setBackground(new java.awt.Color(0, 0, 0,20));
        msg_area.setColumns(20);
        msg_area.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        msg_area.setForeground(new java.awt.Color(255, 255, 255));
        msg_area.setRows(5);
        getContentPane().add(msg_area);
        msg_area.setBounds(10, 90, 410, 500);

        msg_text.setFont(new java.awt.Font("A Jannat LT", 0, 24)); // NOI18N
        msg_text.setText("Enter text");
        getContentPane().add(msg_text);
        msg_text.setBounds(10, 600, 330, 40);

        msg_send.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        msg_send.setText("send");
        msg_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_sendActionPerformed(evt);
            }
        });
        getContentPane().add(msg_send);
        msg_send.setBounds(350, 600, 70, 40);

        Server.setFont(new java.awt.Font("Castellar", 3, 48)); // NOI18N
        Server.setForeground(new java.awt.Color(255, 255, 255));
        Server.setText("server");
        getContentPane().add(Server);
        Server.setBounds(100, 20, 300, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/wallpaperflare.com_wallpaper (4).jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-160, -70, 670, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msg_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_sendActionPerformed
        try {
            String msgout = "";
            msgout = msg_text.getText().trim();
            dout.writeUTF(msgout);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_msg_sendActionPerformed

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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });

        String msgin = "";
        try {
            ss = new ServerSocket(1245);
            s = ss.accept();
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            while (!msgin.equals("Exit")) {
                msgin = din.readUTF();
                msg_area.setText(msg_area.getText().trim() + "\n clint : " + msgin);
            }
        } catch (Exception e) {

        }
        try {
            System.out.println("waiting : ");
            Registry r = LocateRegistry.createRegistry(1245);
            r.rebind("calc", new calc());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Server;
    private javax.swing.JLabel jLabel1;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JButton msg_send;
    private javax.swing.JTextField msg_text;
    // End of variables declaration//GEN-END:variables
}
