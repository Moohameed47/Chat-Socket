package chats;

import operation.Operations;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.rmi.*;

public class Client extends javax.swing.JFrame {

    static ServerSocket ss;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;

    public Client() {
        initComponents();
        setSize(483, 664);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msg_text = new javax.swing.JTextField();
        msg_area = new javax.swing.JTextArea();
        msg_send = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        msg_text.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        msg_text.setText("Enter Text");
        getContentPane().add(msg_text);
        msg_text.setBounds(20, 570, 310, 44);

        msg_area.setBackground(new java.awt.Color(255, 255, 255,0));
        msg_area.setColumns(20);
        msg_area.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        msg_area.setForeground(new java.awt.Color(255, 255, 255));
        msg_area.setRows(5);
        getContentPane().add(msg_area);
        msg_area.setBounds(20, 80, 400, 490);

        msg_send.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        msg_send.setText("Send");
        msg_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_sendActionPerformed(evt);
            }
        });
        getContentPane().add(msg_send);
        msg_send.setBounds(330, 570, 80, 40);

        jLabel2.setFont(new java.awt.Font("Castellar", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Client");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 30, 300, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chats/wallpaperflare.com_wallpaper (4).jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-800, -40, 1320, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msg_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_sendActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });

        try {
            s = new Socket("127.0.0.1", 1245);
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            String msgin = "";
            while (!msgin.equals("Exit")) {
                msgin = din.readUTF();
                msg_area.setText(msg_area.getText().trim() + "\n server : " + msgin);

            }
        } catch (Exception e) {

        }
        try {
            Operations p = (Operations) Naming.lookup("rmi://127.0.0.1:1245/calc");
            System.out.println("result :" + p.SUM(5, 6));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JButton msg_send;
    private javax.swing.JTextField msg_text;
    // End of variables declaration//GEN-END:variables
}
