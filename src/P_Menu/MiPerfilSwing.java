package P_Menu;

import Login_Registro.*;
import MiPerfil.CambiarContraseña;
import Swings_Menus.*;
import javax.swing.JOptionPane;

public class MiPerfilSwing extends javax.swing.JFrame {

    Menu_InicioSwing menu2;
    CambiarContraseña cambiarcontra;
    Menu_PrincipalSwing menu;
    Jugador jugador;
    LoginSwing log;
    Configuracion config;

    public MiPerfilSwing(Menu_PrincipalSwing menu) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.menu = menu;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        datos = new javax.swing.JButton();
        cambiar = new javax.swing.JButton();
        EliminarCuenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/esquina_login.gif"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Viner Hand ITC", 1, 48)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("MI PERFIL");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("REGRESAR");
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        datos.setBackground(new java.awt.Color(31, 44, 56));
        datos.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        datos.setForeground(new java.awt.Color(255, 255, 255));
        datos.setText("VER MIS DATOS");
        datos.setBorderPainted(false);
        datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datosMouseClicked(evt);
            }
        });

        cambiar.setBackground(new java.awt.Color(31, 44, 56));
        cambiar.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        cambiar.setForeground(new java.awt.Color(255, 255, 255));
        cambiar.setText("CAMBIAR PASSWORD");
        cambiar.setBorderPainted(false);
        cambiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarMouseClicked(evt);
            }
        });

        EliminarCuenta.setBackground(new java.awt.Color(31, 44, 56));
        EliminarCuenta.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        EliminarCuenta.setForeground(new java.awt.Color(255, 255, 255));
        EliminarCuenta.setText("ELIMINAR CUENTA");
        EliminarCuenta.setBorderPainted(false);
        EliminarCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarCuentaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(datos, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EliminarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(17, 17, 17))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(datos, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(cambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(EliminarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        menu2 = new Menu_InicioSwing(menu);
        menu2.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2MouseClicked

    private void datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datosMouseClicked

    }//GEN-LAST:event_datosMouseClicked

    private void EliminarCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarCuentaMouseClicked
        JOptionPane.showMessageDialog(this, "Tu cuenta fue eliminada exitosamente", "ELIMINASTE TU CUENTA", JOptionPane.INFORMATION_MESSAGE);
        menu.LogUsers.eliminarCuenta(menu.jugador1.playersName);
        this.dispose();
        menu.setVisible(true);
    }//GEN-LAST:event_EliminarCuentaMouseClicked

    private void cambiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarMouseClicked
        cambiarcontra = new CambiarContraseña(menu);
        cambiarcontra.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cambiarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EliminarCuenta;
    private javax.swing.JButton cambiar;
    private javax.swing.JButton datos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
