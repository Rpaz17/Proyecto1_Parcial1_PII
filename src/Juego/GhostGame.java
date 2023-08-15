package Juego;

import Login_Registro.Jugador;
import Login_Registro.Login;
import P_Menu.ConfiguracionSwing;
import Swings_Menus.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;

public class GhostGame extends javax.swing.JFrame {

    private Botones[][] botons;
    private Ghosts[] gBuenos = new Ghosts[4];
    private Ghosts[] gMalos = new Ghosts[4];
    private Ghosts salida;
    private Botones botonInicio;
    private Botones botonFinal;
    private Botones character;
    private String turno;
    ConfiguracionSwing config;
    boolean ganador;
    int cantBuenos;
    int cantMalos;
    int contadorbJ1;
    int contadormJ1;
    int contadorbJ2;
    int contadormJ2;
    public String perdiste;
    Ghosts fan;
    Menu_PrincipalSwing menu;
    Menu_InicioSwing menu2;

    public GhostGame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.botons = new Botones[6][6];
        initBotones();
        initFantasmas();
        setFantasmasRandom();

    }

    public GhostGame(Menu_PrincipalSwing menu) {
        initComponents();
        this.menu = menu;
        menu2 = new Menu_InicioSwing(menu);
        cantBuenos = config.cantidadG;
        cantMalos = config.cantidadG;
        contadorbJ1 = cantBuenos;
        contadormJ1 = cantMalos;
        contadorbJ2 = cantBuenos;
        contadormJ2 = cantMalos;
        this.setLocationRelativeTo(null);
        this.botons = new Botones[6][6];
        initBotones();
        setJugador2();
        initFantasmas();
        setFantasmasRandom();
        turno = menu.jugador1.getPlayersName();
        FBJ1.setText(String.valueOf(contadorbJ1));
        FMJ1.setText(String.valueOf(contadormJ1));
        FBJ2.setText(String.valueOf(contadorbJ2));
        FMJ2.setText(String.valueOf(contadormJ2));
    }

    public void setJugador2() {
        if (menu.LogUsers.jugadorArreglo.size() > 1) {
            String[] listaUsuarios = new String[menu.LogUsers.jugadorArreglo.size()];
            int i = 0;
            for (Jugador j : menu.LogUsers.jugadorArreglo) {
                if (!j.playersName.equals(menu.jugador1.playersName)) {
                    listaUsuarios[i] = j.playersName;
                    i++;
                }
            }
            String nombrejugador2 = JOptionPane.showInputDialog(this, "Seleccione un oponente", "Seleccion de Jugador2", JOptionPane.QUESTION_MESSAGE, null, listaUsuarios, listaUsuarios[0]).toString();
            menu.jugador2 = menu.LogUsers.buscarJugador(nombrejugador2);
            if (nombrejugador2 == null) {
                menu2.setVisible(true);
                this.setVisible(false);
            }
        } else {
            int okay = JOptionPane.showConfirmDialog(this, "No hay mas jugadores registrados", "Jugadores insuficientes", OK_CANCEL_OPTION);
            if (okay == JOptionPane.OK_CANCEL_OPTION) {
                menu2.setVisible(true);
                this.setVisible(false);
            }
        }
    }

    private ImageIcon createImageIconFromURL(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            Image image = javax.imageio.ImageIO.read(url);
            return new ImageIcon(image);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void initBotones() {
        TABLERO.setLayout(new GridLayout(6, 6));
        int botonsCount = 0;
        for (int f = 0; f < 6; f++) {
            for (int c = 0; c < 6; c++) {
                botons[f][c] = new Botones(f, c, botonsCount, "_", "");
                botons[f][c].setName("boton_" + String.valueOf(botonsCount));
                botons[f][c].setBorder(null);
                botonsCount++;
                if ((c % 2 == 0 && f % 2 == 0) || (f % 2 != 0 && c % 2 != 0)) {
                    botons[f][c].setBackground(Color.BLACK);
                    botons[f][c].setForeground(Color.BLACK);
                } else {
                    botons[f][c].setBackground(Color.WHITE);
                    botons[f][c].setForeground(Color.BLACK);
                }
                botons[f][c].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt) {
                        botonesMouseClicked(evt);
                    }
                });
                TABLERO.add(botons[f][c]);
            }
        }

        botons[0][0].setBackground(Color.DARK_GRAY);
        botons[0][0].fantasma.Tipo = "SALIDA";
        botons[0][0].setText("SALIDA");
        botons[0][5].setBackground(Color.DARK_GRAY);
        botons[0][5].fantasma.Tipo = "SALIDA";
        botons[0][5].setText("SALIDA");
        botons[5][0].setBackground(Color.DARK_GRAY);
        botons[5][0].fantasma.Tipo = "SALIDA";
        botons[5][0].setText(" SALIDA");
        botons[5][5].setBackground(Color.DARK_GRAY);
        botons[5][5].fantasma.Tipo = "SALIDA";
        botons[5][5].setText(" SALIDA");
    }

    private void botonesMouseClicked(MouseEvent evt) {
        Object source = evt.getSource();
        Botones botonPresionado = ((Botones) source);
        int f = botonPresionado.fila;
        int c = botonPresionado.columna;
        boolean mover = false;
        String text = botonPresionado.getText();
        botonPresionado.setBorderPainted(true);
        botons[0][0].jugador = menu.jugador2.getPlayersName();
        botons[0][5].jugador = menu.jugador2.getPlayersName();
        botons[5][0].jugador = menu.jugador1.getPlayersName();
        botons[5][5].jugador = menu.jugador1.getPlayersName();
        if (botonPresionado.habilitado == false) {
            if (botonInicio == null && botonPresionado.fantasma.Tipo=="SALIDA" ) {
                JOptionPane.showMessageDialog(this, "NO PUEDES MOVER ESTA CASILLA", "SALIDA", JOptionPane.INFORMATION_MESSAGE);
            }
            if (botonInicio == null) {
                botonPresionado.setBorder(BorderFactory.createLineBorder(Color.RED, 5, true));
                botonInicio = botonPresionado;
                botonInicio.setText(botonPresionado.getText());
                botonInicio.jugador = botonPresionado.jugador;
            } else if (botonInicio == botonPresionado) {
                botonInicio.setBorder(BorderFactory.createEmptyBorder());
                botonPresionado.setBorder(BorderFactory.createEmptyBorder());
                botonInicio = null;
            } else {
                botonFinal = botonPresionado;
                botonFinal.setText(botonPresionado.getText());
                botonFinal.jugador = botonPresionado.jugador;
                if (botonInicio.fila == botonPresionado.fila) {
                    if ((botonInicio.columna > 0 && botonPresionado.columna == botonInicio.columna - 1) || (botonInicio.columna < 5 && botonPresionado.columna == botonInicio.columna + 1)) {
                        mover = true;
                    }
                } else if (botonInicio.columna == botonPresionado.columna) {
                    if ((botonInicio.fila > 0 && botonPresionado.fila == botonInicio.fila - 1) || (botonInicio.fila < 9 && botonPresionado.fila == botonInicio.fila + 1)) {
                        mover = true;
                    }

                } // cierre de verificacion si el movimiento es en misma fila y columna
            }
            //VERIFICAR LA SALIDA CORRECTA DE CADA EQUIPO
            if (botonPresionado.fantasma.Tipo=="SALIDA"  && botonInicio.jugador != botonPresionado.jugador && botonInicio != null) {
                if (botonInicio.fantasma.Tipo == "BUENO") {
                    JOptionPane.showMessageDialog(this, botonInicio.jugador + "ganó porque sacó del castillo un fantasma bueno!", "GANASTE!", JOptionPane.INFORMATION_MESSAGE);
                    menu.jugador1.addPoints();
                    this.setVisible(false);
                    menu2.setVisible(true);
                } else if (botonInicio.fantasma.Tipo == "MALO") {
                    JOptionPane.showMessageDialog(this, "Felicidades" + botonInicio.jugador + "!! Sacaste un fantasma malo del castillo", "un fantasma menos", JOptionPane.INFORMATION_MESSAGE);
                    contadormJ1--;
                }
            } else if(botonInicio.jugador == botonPresionado.jugador && botonPresionado.getText() == "SALIDA" ) {
                JOptionPane.showMessageDialog(this, "NO PUEDES SACAR TU FANTASMA POR AQUI", "SALIDA INCORRECTA", JOptionPane.WARNING_MESSAGE);
            }
            //VERIFICACION DE MOVIMIENTOS
            if (botonInicio.jugador == turno) {
                if (botonPresionado.fantasma.Tipo == null && mover) { // EN CASO DE QUE LA SEGUNDA CASILLA NO TENGA NADA
                    botonPresionado.setGhost(botonInicio.fantasma);// el boton presionado toma la informacion del personaje del primero boton seleccionado
                    botonPresionado.setText(botonInicio.getText());// el boton presionado toma la informacion del primer boton seleccionado
                    botonPresionado.setIcon(botonInicio.getIcon());
                    botonPresionado.jugador = botonInicio.jugador;
                    botonInicio.setBorder(BorderFactory.createEmptyBorder());
                    botonInicio.setText(null);
                    botonInicio.fantasma = new Ghosts();
                    botonInicio = null;
                    Turno();
                } else if (botonInicio.fantasma.equals(botonPresionado.fantasma) && mover) {// EN CASO DE QUE SEAN DEL MISMO
                    botonInicio.setBorder(BorderFactory.createEmptyBorder());
                    botonPresionado.setBorder(BorderFactory.createLineBorder(Color.RED, 5, true));// se le pone el borde al boton para que se sepa que es lo que se esta seleccionando, el segundo boton se selecciona
                    botonInicio = botonPresionado;
                    botonInicio.setText(text);
                } else if (botonPresionado.fantasma.Tipo != null && mover) {
                    botonInicio.setBorder(BorderFactory.createEmptyBorder());
                    if ((botonInicio.jugador != botonPresionado.jugador)) {
                        JOptionPane.showMessageDialog(null, "Te comiste un " + botonPresionado.fantasma.Tipo + " de " + botonPresionado.jugador, "UN FANTASMA MENOS", JOptionPane.INFORMATION_MESSAGE);
                        if (botonPresionado.fantasma.Tipo == "BUENO" && botonPresionado.jugador == menu.jugador1.getPlayersName()) {
                            contadorbJ1--;
                            FBJ1.setText(String.valueOf(contadorbJ1));
                        } else if (botonPresionado.fantasma.Tipo == "MALO" && botonPresionado.jugador == menu.jugador1.getPlayersName()) {
                            contadormJ1--;
                            FMJ1.setText(String.valueOf(contadormJ1));
                        } else if (botonPresionado.fantasma.Tipo == "BUENO" && botonPresionado.jugador == menu.jugador2.getPlayersName()) {
                            contadorbJ2--;
                            FBJ2.setText(String.valueOf(contadorbJ2));
                        } else if (botonPresionado.fantasma.Tipo == "MALO" && botonPresionado.jugador == menu.jugador2.getPlayersName()) {
                            contadormJ2--;
                            FMJ2.setText(String.valueOf(contadormJ2));
                        }
                        if (contadormJ2 == 0) {
                            perdiste = JOptionPane.showInputDialog(this, menu.jugador2.getPlayersName() + " ganó porque " + menu.jugador1.getPlayersName() + "comió todos sus fantasmas malos!", "GANASTE!", JOptionPane.INFORMATION_MESSAGE);
                            menu.jugador2.addPoints();
                        } else if (contadorbJ2 == 0) {
                            perdiste = JOptionPane.showInputDialog(this, menu.jugador1.getPlayersName() + " ganó porque capturo todos los fantasmas buenos de " + menu.jugador2.getPlayersName(), "GANASTE!", JOptionPane.INFORMATION_MESSAGE);
                            menu.jugador1.addPoints();
                        } else if (contadormJ1 == 0) {
                            perdiste = JOptionPane.showInputDialog(this, menu.jugador1.getPlayersName() + " ganó porque " + menu.jugador2.getPlayersName() + "comió todos sus fantasmas malos!", "GANASTE!", JOptionPane.INFORMATION_MESSAGE);
                            menu.jugador1.addPoints();
                        } else if (contadorbJ1 == 0) {
                            perdiste = JOptionPane.showInputDialog(this, menu.jugador2.getPlayersName() + " ganó porque capturó todos los fantasmas buenos de" + menu.jugador1.getPlayersName(), "GANASTE!", JOptionPane.INFORMATION_MESSAGE);
                            menu.jugador2.addPoints();
                        }
                        botonPresionado.fantasma = botonInicio.fantasma;
                        botonPresionado.jugador = botonInicio.jugador;
                        botonPresionado.setText(botonInicio.getText());
                        botonPresionado.setIcon(botonInicio.getIcon());
                        botonInicio.setText(null);
                        botonInicio.fantasma = new Ghosts();
                        Turno();
                    }
                    botonInicio = null;
                }
            } else {
                //VERIFICAR QUE SEA SU TURNO
                JOptionPane.showMessageDialog(this, "HEY NO ES TU TURNO!", "Intento de Trampa", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    //CAMBIAR DE TURNOS
    public void Turno() {
        if (botonFinal.jugador == menu.jugador1.getPlayersName()) {
            turno = menu.jugador2.getPlayersName();
        } else if (botonFinal.jugador == menu.jugador2.getPlayersName()) {
            turno = menu.jugador1.getPlayersName();
        }
        JOptionPane.showMessageDialog(this, "Es turno de " + turno, "TURNO", JOptionPane.INFORMATION_MESSAGE);
        NOMBRE.setText(turno);
    }

    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private void initFantasmas() {
        gBuenos[0] = new Ghosts("BUENO", "/Images/goodGhost.png");
        gBuenos[1] = new Ghosts("BUENO", "/Images/goodGhost.png");
        gBuenos[2] = new Ghosts("BUENO", "/Images/goodGhost.png");
        gBuenos[3] = new Ghosts("BUENO", "/Images/goodGhost.png");
        gMalos[0] = new Ghosts("MALO", "/Images/badGhost.png");
        gMalos[1] = new Ghosts("MALO", "/Images/badGhost.png");
        gMalos[2] = new Ghosts("MALO", "/Images/badGhost.png");
        gMalos[3] = new Ghosts("MALO", "/Images/badGhost.png");
    }

    private void setFantasmasRandom() {

        ImageIcon image = new ImageIcon("NetBeansProjects/Ghosts/src/Images/Images/goodG.png");
        //UBICAR DE MANER RANDOM LOS FANTASMAS BUENOS DEL JUGADOR 1
        for (int pos_fanJB1 = cantBuenos - 1; pos_fanJB1 >= 0; pos_fanJB1--) {
            int fantasmaActual = pos_fanJB1;
            while (pos_fanJB1 == fantasmaActual) {
                int f, c;
                if (gBuenos[pos_fanJB1].Tipo == "BUENO") {
                    f = getRandom(4, 5);
                    c = getRandom(1, 4);
                    if (botons[f][c].fantasma.Tipo == null) {
                        botons[f][c].setText("___");
                        botons[f][c].setIcon(image);
                        botons[f][c].setGhost(gBuenos[pos_fanJB1]);
                        botons[f][c].jugador = menu.jugador1.getPlayersName();
                        fantasmaActual--;
                    }
                }
            }
        }
        //UBICAR DE MANERA RANDOM LOS FANTASMAS MALOS DEL JUGADOR 1
        for (int pos_fanJM1 = cantMalos - 1; pos_fanJM1 >= 0; pos_fanJM1--) {
            int fanActual = pos_fanJM1;
            while (pos_fanJM1 == fanActual) {
                int fil, col;
                if (gBuenos[pos_fanJM1].Tipo == "BUENO") {
                    fil = getRandom(4, 5);
                    col = getRandom(1, 4);
                    if (botons[fil][col].fantasma.Tipo == null) {
                        botons[fil][col].setText("___");
                        botons[fil][col].setGhost(gMalos[pos_fanJM1]);
                        botons[fil][col].jugador = menu.jugador1.getPlayersName();
                        fanActual--;
                    }
                }
            }
        }

        //UBICAR DE MANER RANDOM LOS FANTASMAS BUENOS DEL JUGADOR 2
        for (int pos_fanJB2 = cantBuenos-1; pos_fanJB2 >= 0; pos_fanJB2--) {
            int fantasmaActual2 = pos_fanJB2;
            while (pos_fanJB2 == fantasmaActual2) {
                int f, c;
                if (gBuenos[pos_fanJB2].Tipo == "BUENO") {
                    f = getRandom(0, 1);
                    c = getRandom(1, 4);
                    if (botons[f][c].fantasma.Tipo == null) {
                        botons[f][c].setText("___");
                        botons[f][c].setGhost(gBuenos[pos_fanJB2]);
                        botons[f][c].jugador = menu.jugador2.getPlayersName();
                        fantasmaActual2--;
                    }
                }
            }
        }
        //UBICAR DE MANERA RANDOM LOS FANTASMAS MALOS DEL JUGADOR 2
        for (int pos_fanJM2 = cantMalos - 1; pos_fanJM2 >= 0; pos_fanJM2--) {
            int fanActualJ2 = pos_fanJM2;
            while (pos_fanJM2 == fanActualJ2) {
                int fil, col;
                if (gBuenos[pos_fanJM2].Tipo == "BUENO") {
                    fil = getRandom(0, 1);
                    col = getRandom(1, 4);
                    if (botons[fil][col].fantasma.Tipo == null) {
                        botons[fil][col].setText("___");
                        botons[fil][col].setGhost(gMalos[pos_fanJM2]);
                        botons[fil][col].jugador = menu.jugador2.getPlayersName();
                        fanActualJ2--;
                    }
                }
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        TABLERO = new javax.swing.JPanel();
        NOMBRE = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        FMJ2 = new javax.swing.JLabel();
        FBJ1 = new javax.swing.JLabel();
        FMJ1 = new javax.swing.JLabel();
        FBJ2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(51, 0, 0));
        fondo.setEnabled(false);
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TABLERO.setBackground(new java.awt.Color(0, 0, 0));
        TABLERO.setDoubleBuffered(false);

        javax.swing.GroupLayout TABLEROLayout = new javax.swing.GroupLayout(TABLERO);
        TABLERO.setLayout(TABLEROLayout);
        TABLEROLayout.setHorizontalGroup(
            TABLEROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        TABLEROLayout.setVerticalGroup(
            TABLEROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        fondo.add(TABLERO, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 1090, 690));

        NOMBRE.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        NOMBRE.setForeground(new java.awt.Color(255, 255, 255));
        fondo.add(NOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 80, 130, 40));

        jLabel8.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TURNO DE");
        fondo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 80, 150, -1));

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("FANTASMAS JUGADOR 1");
        fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 180, 314, 36));

        jLabel3.setBackground(new java.awt.Color(102, 0, 0));
        jLabel3.setFont(new java.awt.Font("Chiller", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("FANTASMAS BUENOS");
        fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 220, 270, 36));

        jLabel4.setFont(new java.awt.Font("Chiller", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("FANTASMAS MALOS");
        fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 270, 260, 36));

        jLabel5.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("FANTASMAS JUGADOR 2");
        fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 360, 314, 36));

        jLabel6.setBackground(new java.awt.Color(102, 0, 0));
        jLabel6.setFont(new java.awt.Font("Chiller", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("FANTASMAS BUENOS");
        fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 400, 270, 36));

        jLabel7.setFont(new java.awt.Font("Chiller", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("FANTASMAS MALOS");
        fondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 450, 260, 36));

        jButton1.setBackground(new java.awt.Color(102, 0, 0));
        jButton1.setFont(new java.awt.Font("Chiller", 0, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("RENDIRSE");
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        fondo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 590, 229, -1));
        fondo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 220, -1, 40));

        jLabel9.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel9AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        fondo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 20, 190, 40));

        jLabel10.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel10AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        fondo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 700, 190, 40));

        FMJ2.setFont(new java.awt.Font("Chiller", 1, 24)); // NOI18N
        FMJ2.setForeground(new java.awt.Color(255, 255, 255));
        fondo.add(FMJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 440, 40, 40));

        FBJ1.setFont(new java.awt.Font("Chiller", 1, 24)); // NOI18N
        FBJ1.setForeground(new java.awt.Color(255, 255, 255));
        fondo.add(FBJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 210, 40, 40));

        FMJ1.setFont(new java.awt.Font("Chiller", 1, 24)); // NOI18N
        FMJ1.setForeground(new java.awt.Color(255, 255, 255));
        fondo.add(FMJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 260, 40, 40));

        FBJ2.setFont(new java.awt.Font("Chiller", 1, 24)); // NOI18N
        FBJ2.setForeground(new java.awt.Color(255, 255, 255));
        fondo.add(FBJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 400, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//BOTON PARA RENDIRSE

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (turno == menu.jugador1.getPlayersName()) {
            JOptionPane.showMessageDialog(this, "Estas seguro que deseas rendirte", "RENDIRSE", JOptionPane.OK_CANCEL_OPTION);
            int rendirse = JOptionPane.OK_CANCEL_OPTION;
            if (rendirse == JOptionPane.OK_CANCEL_OPTION) {
                menu.jugador2.addPoints();
                this.setVisible(false);
                menu2.setVisible(true);
            }
        } else if (turno == menu.jugador2.getPlayersName()) {
            JOptionPane.showMessageDialog(this, "Estas seguro que deseas rendirte", "RENDIRSE", JOptionPane.OK_CANCEL_OPTION);
            int rendirse = JOptionPane.OK_CANCEL_OPTION;
            if (rendirse == JOptionPane.OK_CANCEL_OPTION) {
                menu.jugador1.addPoints();
                this.setVisible(false);
                menu2.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton1MouseClicked

// NOMBRE DEL JUGADOR POR LADO
    private void jLabel9AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel9AncestorAdded
        jLabel9.setText(menu.jugador2.getPlayersName().toUpperCase());
    }//GEN-LAST:event_jLabel9AncestorAdded
//NOMBRE DEL JUGADOR POR LADO
    private void jLabel10AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel10AncestorAdded
        jLabel10.setText(menu.jugador1.getPlayersName().toUpperCase());
    }//GEN-LAST:event_jLabel10AncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FBJ1;
    private javax.swing.JLabel FBJ2;
    private javax.swing.JLabel FMJ1;
    private javax.swing.JLabel FMJ2;
    private javax.swing.JLabel NOMBRE;
    private javax.swing.JPanel TABLERO;
    private javax.swing.JPanel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

    private int getRandom(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
