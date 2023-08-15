package Login_Registro;

import Login_Registro.Login;
import Swings_Menus.Menu_InicioSwing;
import Swings_Menus.Menu_PrincipalSwing;
import javax.swing.JOptionPane;

public class LoginSwing extends javax.swing.JFrame {

    Jugador jugador;
    Configuracion config;
    Menu_PrincipalSwing menu;

    public LoginSwing(Menu_PrincipalSwing menu) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.menu = menu;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_login = new javax.swing.JButton();
        btn_menu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_pswrd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(24, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_login.setBackground(new java.awt.Color(255, 255, 255));
        btn_login.setFont(new java.awt.Font("Chiller", 1, 24)); // NOI18N
        btn_login.setForeground(new java.awt.Color(51, 0, 0));
        btn_login.setText("LOG IN");
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
        });
        jPanel1.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 161, -1));

        btn_menu.setBackground(new java.awt.Color(255, 255, 255));
        btn_menu.setFont(new java.awt.Font("Chiller", 1, 24)); // NOI18N
        btn_menu.setForeground(new java.awt.Color(51, 0, 0));
        btn_menu.setText("MENU INICIO");
        btn_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_menuMouseClicked(evt);
            }
        });
        jPanel1.add(btn_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 174, -1));

        jLabel1.setFont(new java.awt.Font("Chiller", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 120, 74));

        jLabel2.setFont(new java.awt.Font("Chiller", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USERNAME");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 167, 40));

        txt_username.setBackground(new java.awt.Color(20, 0, 0));
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 242, 45));

        jLabel3.setFont(new java.awt.Font("Chiller", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PASSWORD");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 167, 40));

        txt_pswrd.setBackground(new java.awt.Color(20, 0, 0));
        txt_pswrd.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt_pswrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 242, 45));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/esquina_login.gif"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 525, 1, 11));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/littleghostlogin.gif"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseClicked
        // este boton nos manda de regreso al menu de inicio.
        menu.setVisible(true);
        this.setVisible(false);
        txt_username.setText(null);
        txt_pswrd.setText(null);
    }//GEN-LAST:event_btn_menuMouseClicked

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
        /* Aqui estamos poniendo los datos que se ingresaron
        en el text field en una variable
         */
        String usuario = txt_username.getText();
        String password = txt_pswrd.getText();
        Jugador ext = menu.LogUsers.buscarJugador(usuario);

        if (ext != null) {
            if (ext.getPassword().equals(password)) {
                menu.jugador1=ext;
                Menu_InicioSwing menu1 = new Menu_InicioSwing(menu);
                menu1.setVisible(true);
                this.setVisible(false);
                txt_username.setText(null);
                txt_pswrd.setText(null);
            } else {
                JOptionPane.showMessageDialog(this, "Error. La contraseña que ingresaste es incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error. Usuario no encontrado");
        }
    }//GEN-LAST:event_btn_loginMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_pswrd;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

}
