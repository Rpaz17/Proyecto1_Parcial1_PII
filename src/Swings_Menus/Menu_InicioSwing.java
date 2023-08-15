package Swings_Menus;

import P_Menu.ConfiguracionSwing;
import P_Menu.ReportesSwing;
import P_Menu.MiPerfilSwing;
import Juego.GhostGame;
import Login_Registro.*;

public class Menu_InicioSwing extends javax.swing.JFrame {

    Menu_PrincipalSwing menu;
    ConfiguracionSwing config;
    ReportesSwing reportes;
    MiPerfilSwing perfil;

    public Menu_InicioSwing(Menu_PrincipalSwing menu) {
        initComponents();
        this.menu = menu;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_jugar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_configuracion = new javax.swing.JButton();
        btn_reportes = new javax.swing.JButton();
        btn_miperfil = new javax.swing.JButton();
        btn_cerrarsesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("MENU INICIO");
        setBackground(new java.awt.Color(0, 0, 0));
        setLocation(new java.awt.Point(0, 0));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        btn_jugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menuprincipal2.gif"))); // NOI18N
        btn_jugar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        btn_jugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_jugarMouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 225, 225));
        jLabel1.setFont(new java.awt.Font("Chiller", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 226, 226));
        jLabel1.setText("PRESIONA AQUI PARA JUGAR GHOSTS");

        btn_configuracion.setBackground(new java.awt.Color(255, 235, 235));
        btn_configuracion.setFont(new java.awt.Font("Chiller", 1, 36)); // NOI18N
        btn_configuracion.setForeground(new java.awt.Color(0, 0, 0));
        btn_configuracion.setText("CONFIGURACION");
        btn_configuracion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 153)));
        btn_configuracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_configuracionMouseClicked(evt);
            }
        });

        btn_reportes.setBackground(new java.awt.Color(255, 235, 235));
        btn_reportes.setFont(new java.awt.Font("Chiller", 1, 36)); // NOI18N
        btn_reportes.setForeground(new java.awt.Color(0, 0, 0));
        btn_reportes.setText("REPORTES");
        btn_reportes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 153)));
        btn_reportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_reportesMouseClicked(evt);
            }
        });

        btn_miperfil.setBackground(new java.awt.Color(255, 235, 235));
        btn_miperfil.setFont(new java.awt.Font("Chiller", 1, 36)); // NOI18N
        btn_miperfil.setForeground(new java.awt.Color(0, 0, 0));
        btn_miperfil.setText("MI PERFIL");
        btn_miperfil.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 153)));
        btn_miperfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_miperfilMouseClicked(evt);
            }
        });

        btn_cerrarsesion.setBackground(new java.awt.Color(255, 235, 235));
        btn_cerrarsesion.setFont(new java.awt.Font("Chiller", 1, 36)); // NOI18N
        btn_cerrarsesion.setForeground(new java.awt.Color(0, 0, 0));
        btn_cerrarsesion.setText("CERRAR SESION");
        btn_cerrarsesion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 153)));
        btn_cerrarsesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cerrarsesionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_configuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reportes, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(btn_jugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_miperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cerrarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1379, 1379, 1379))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(445, 445, 445)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(btn_jugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_configuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191)
                .addComponent(btn_reportes, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(btn_miperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203)
                .addComponent(btn_cerrarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_jugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_jugarMouseClicked
        GhostGame tablero = new GhostGame(this);
        if (menu.jugador2 == null) {
            tablero.setVisible(false);
            this.setVisible(true);
        } else {
            tablero.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btn_jugarMouseClicked

    private void btn_cerrarsesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cerrarsesionMouseClicked
        menu.jugador1 = null;
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_cerrarsesionMouseClicked

    private void btn_configuracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_configuracionMouseClicked
        config = new ConfiguracionSwing(this);
        config.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_configuracionMouseClicked

    private void btn_reportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reportesMouseClicked
        reportes = new ReportesSwing(menu);
        reportes.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_reportesMouseClicked

    private void btn_miperfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_miperfilMouseClicked
        perfil = new MiPerfilSwing(menu);
        perfil.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_miperfilMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrarsesion;
    private javax.swing.JButton btn_configuracion;
    private javax.swing.JLabel btn_jugar;
    private javax.swing.JButton btn_miperfil;
    private javax.swing.JButton btn_reportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
