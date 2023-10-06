package bibliotecagrupo5.Control;

import bibliotecagrupo5.AccesoADatos.Conexion;
import bibliotecagrupo5.Vistas.MenuPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author BETO
 */
public class Login extends javax.swing.JFrame {

    private Connection con = null;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        con = Conexion.getConexion2("login");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpEscritorioLogin = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jpfContrasenia = new javax.swing.JPasswordField();
        jbIniciarSesion = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbNuevoUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jdpEscritorioLogin.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Biblioteca ANTONIO ESTEBAN AGÜERO");

        jLabel5.setText("Usuario:");

        jLabel6.setText("Contraseña:");

        jbIniciarSesion.setText("Iniciar Sesion");
        jbIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIniciarSesionActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbNuevoUsuario.setText("Nuevo Usuario");
        jbNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoUsuarioActionPerformed(evt);
            }
        });

        jdpEscritorioLogin.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpEscritorioLogin.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpEscritorioLogin.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpEscritorioLogin.setLayer(jtfUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpEscritorioLogin.setLayer(jpfContrasenia, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpEscritorioLogin.setLayer(jbIniciarSesion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpEscritorioLogin.setLayer(jbCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdpEscritorioLogin.setLayer(jbNuevoUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpEscritorioLoginLayout = new javax.swing.GroupLayout(jdpEscritorioLogin);
        jdpEscritorioLogin.setLayout(jdpEscritorioLoginLayout);
        jdpEscritorioLoginLayout.setHorizontalGroup(
            jdpEscritorioLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpEscritorioLoginLayout.createSequentialGroup()
                .addGroup(jdpEscritorioLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdpEscritorioLoginLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1))
                    .addGroup(jdpEscritorioLoginLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jdpEscritorioLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jbIniciarSesion))
                        .addGroup(jdpEscritorioLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdpEscritorioLoginLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jdpEscritorioLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jpfContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jdpEscritorioLoginLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jbNuevoUsuario)
                                .addGap(62, 62, 62)
                                .addComponent(jbCancelar)))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jdpEscritorioLoginLayout.setVerticalGroup(
            jdpEscritorioLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpEscritorioLoginLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(jdpEscritorioLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jdpEscritorioLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpfContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(77, 77, 77)
                .addGroup(jdpEscritorioLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbIniciarSesion)
                    .addComponent(jbNuevoUsuario)
                    .addComponent(jbCancelar))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jdpEscritorioLogin)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpEscritorioLogin, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIniciarSesionActionPerformed
        // TODO add your handling code here:
        try {
            String usuario = jtfUsuario.getText();
            String contraseña = jpfContrasenia.getText();

            if (!usuario.isEmpty() && !contraseña.isEmpty()) {

                String sql = "SELECT * FROM usuario WHERE user='" + usuario + "' AND password='" + contraseña + "'";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Bienvenido al Sistema de Gestion Biblioteca ANTONIO ESTEBAN AGÜERO");
                    JFrame menuPrincipal = new MenuPrincipal();
                    dispose();
                    menuPrincipal.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario y/o contraseñas incorrectos");
                    jtfUsuario.setText("");
                    jpfContrasenia.setText("");
                }
            } else {

                JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacios");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al acceder a la tabla Login: "+ex.getMessage());
        }
    }//GEN-LAST:event_jbIniciarSesionActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoUsuarioActionPerformed
        // TODO add your handling code here:
        jdpEscritorioLogin.removeAll();
        jdpEscritorioLogin.repaint();
        JInternalFrame formularioUsuario = new FormularioUsuario();
        formularioUsuario.setVisible(true);
        jdpEscritorioLogin.add(formularioUsuario);
        jdpEscritorioLogin.moveToFront(formularioUsuario);
        
    }//GEN-LAST:event_jbNuevoUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbIniciarSesion;
    private javax.swing.JButton jbNuevoUsuario;
    private javax.swing.JDesktopPane jdpEscritorioLogin;
    private javax.swing.JPasswordField jpfContrasenia;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}

