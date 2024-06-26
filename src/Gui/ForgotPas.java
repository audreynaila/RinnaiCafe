
package Gui;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author audreynaila
 */
public class ForgotPas extends javax.swing.JFrame {

    /**
     * Creates new form ForgotPas
     */
    public ForgotPas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        background1 = new Model.Background();
        ps = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        username1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        buttonCostum1 = new Gui.ButtonCostum();
        jLabel6 = new javax.swing.JLabel();
        buttonCostum2 = new Gui.ButtonCostum();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(131, 105, 83));

        background1.setBackground(new java.awt.Color(30, 20, 18));
        background1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ps.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        ps.setForeground(new java.awt.Color(255, 255, 255));
        ps.setText("Password");
        background1.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 489, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Verify Password");
        background1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 489, -1));
        background1.add(username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 250, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Username");
        background1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 489, -1));
        background1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 250, -1));
        background1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 250, -1));

        buttonCostum1.setText("Back");
        buttonCostum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCostum1ActionPerformed(evt);
            }
        });
        background1.add(buttonCostum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 90, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/iconrinai (1).png"))); // NOI18N
        background1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 60, 60));

        buttonCostum2.setText("Login");
        buttonCostum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCostum2ActionPerformed(evt);
            }
        });
        background1.add(buttonCostum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 100, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCostum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCostum1ActionPerformed
    Login lg = new Login();
    lg.setVisible(true);
    dispose();
    }//GEN-LAST:event_buttonCostum1ActionPerformed

    private void buttonCostum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCostum2ActionPerformed
        
String username = username1.getText();
String newPassword = ps.getText();

// Melakukan koneksi ke database
Connection conn = null;
PreparedStatement stmt = null;
try {
    // Mengatur koneksi database
    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_caferinai", "root", "");

    // Query untuk mengubah password dalam tabel customers
    String sql = "UPDATE customers SET password = ? WHERE username = ?";
    stmt = (PreparedStatement) conn.prepareStatement(sql);
    stmt.setString(1, newPassword);
    stmt.setString(2, username);
    stmt.executeUpdate();

    // Menghapus teks di JTextField
    username1.setText("");
    ps.setText("");

    // Menampilkan PopPas
    PopPas popPas = new PopPas();
    popPas.setVisible(true);

} catch (SQLException e) {
    e.printStackTrace();
    // Menampilkan pesan error di GUI
    JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengubah password.");
} finally {
    // Menutup prepared statement dan koneksi
    try {
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
   

    }//GEN-LAST:event_buttonCostum2ActionPerformed

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
            java.util.logging.Logger.getLogger(ForgotPas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Model.Background background1;
    private Gui.ButtonCostum buttonCostum1;
    private Gui.ButtonCostum buttonCostum2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel ps;
    private javax.swing.JTextField username1;
    // End of variables declaration//GEN-END:variables
}
