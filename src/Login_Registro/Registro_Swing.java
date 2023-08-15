package Login_Registro;

import Swings_Menus.*;
import Swings_Menus.Menu_PrincipalSwing;
import static java.awt.PageAttributes.MediaType.C;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class Registro_Swing extends javax.swing.JFrame {

    Menu_PrincipalSwing menu;
    Menu_InicioSwing menu2;
    Jugador jug;
    Configuracion configuracion;

    public Registro_Swing(Menu_PrincipalSwing menu) {
        initComponents();
        setLocationRelativeTo(null);
        this.menu = menu;
        this.menu2 = new Menu_InicioSwing(menu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_Registrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pswd_password = new javax.swing.JPasswordField();
        btn_Menu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 15));
        jPanel1.setForeground(new java.awt.Color(0, 0, 51));

        btn_Registrar.setBackground(new java.awt.Color(255, 255, 255));
        btn_Registrar.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        btn_Registrar.setForeground(new java.awt.Color(1, 1, 71));
        btn_Registrar.setText("REGISTRAR");
        btn_Registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_RegistrarMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Chiller", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USERNAME");

        jLabel2.setFont(new java.awt.Font("Chiller", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PASSWORD");

        txt_username.setBackground(new java.awt.Color(0, 0, 15));
        txt_username.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Chiller", 3, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CREAR PLAYER");

        pswd_password.setBackground(new java.awt.Color(0, 0, 15));
        pswd_password.setForeground(new java.awt.Color(255, 255, 255));

        btn_Menu.setBackground(new java.awt.Color(255, 255, 255));
        btn_Menu.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        btn_Menu.setForeground(new java.awt.Color(1, 1, 71));
        btn_Menu.setText("MENU INICIO");
        btn_Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MenuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btn_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(btn_Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_username, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(pswd_password, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pswd_password, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Registrar)
                    .addComponent(btn_Menu))
                .addGap(40, 40, 40))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MenuMouseClicked
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_MenuMouseClicked

    private void btn_RegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RegistrarMouseClicked
        int space = 0;
        if (txt_username.getText().isEmpty() || pswd_password.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Algunas de las casillas se encuentran vacias");
        } else {
            String username = txt_username.getText();
            String password = pswd_password.getText();

            for (int i = 0; i < username.length(); i++) {
                if (username.charAt(i) == ' ') {
                    space = 1;
                    break;
                }
            }

            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) == ' ') {
                    space = 1;
                    break;
                }
            }
            if (space == 0) {
                Jugador jugador = new Jugador(username, password);
                boolean add = menu.LogUsers.addPlayer(jugador);
                if (add) {
                    JOptionPane.showMessageDialog(this, "FUE REGISTRADO CORRECTAMENTE", "Registro", INFORMATION_MESSAGE);
                    this.setVisible(false);
                    menu.jugador1=jugador;
                    menu2.setVisible(true);
                    txt_username.setText(null);
                    pswd_password.setText(null);
                } else if (menu.LogUsers.buscarJugador(username)!=null) {
                    JOptionPane.showMessageDialog(null, "EL USERNAME QUE INGRESO YA SE ENCUENTRA EN EL JUEGO", "ERROR", INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "NO PUEDE INGRESAR ESTE TIPO DE PARAMETRO.", "ERROR", INFORMATION_MESSAGE);
                this.setVisible(false);
                menu.setVisible(true);
            }

        }
    }//GEN-LAST:event_btn_RegistrarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Menu;
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pswd_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
