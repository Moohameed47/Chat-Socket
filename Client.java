package chat;

import java.io.*;
import java.net.*;
import java.util.logging.*;

public class Client extends javax.swing.JFrame {

    static Socket s;
    static DataInput DIn;
    static DataOutput DOut;

    public Client() {
        initComponents();
        setSize(420, 320);
        setTitle("Client");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Msg_area = new javax.swing.JTextArea();
        Msg_Text = new javax.swing.JTextField();
        Msg_Send = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Msg_area.setColumns(20);
        Msg_area.setRows(5);
        jScrollPane1.setViewportView(Msg_area);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(12, 13, 380, 210);

        Msg_Text.setText("jTextField1");
        Msg_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Msg_TextActionPerformed(evt);
            }
        });
        getContentPane().add(Msg_Text);
        Msg_Text.setBounds(13, 232, 260, 40);

        Msg_Send.setText("jButton1");
        Msg_Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Msg_SendActionPerformed(evt);
            }
        });
        getContentPane().add(Msg_Send);
        Msg_Send.setBounds(290, 230, 100, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Msg_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Msg_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Msg_TextActionPerformed

    private void Msg_SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Msg_SendActionPerformed
        try {
            String MsgOut = "";
            MsgOut = Msg_Text.getText().trim();
            DOut.writeUTF(MsgOut);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_Msg_SendActionPerformed

    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });

        try {
            s = new Socket("127.0.0.1", 6666);
            DIn = new DataInputStream(s.getInputStream());
            DOut = new DataOutputStream(s.getOutputStream());
            String Magin = "";
            while (!Magin.equals("EXIT")) {
                Magin = DIn.readUTF();
                Msg_area.setText(Msg_area.getText().trim() + "\n" + Magin);
            }
        } catch (Exception e) {
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Msg_Send;
    private javax.swing.JTextField Msg_Text;
    private static javax.swing.JTextArea Msg_area;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
