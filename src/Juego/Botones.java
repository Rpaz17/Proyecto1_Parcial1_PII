package Juego;

import Login_Registro.Jugador;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Botones extends javax.swing.JButton {
    public Ghosts fantasma;

    boolean habilitado=false;
    int numero=0;
    int fila=0;
    int columna=0;
    public String jugador;
    
    public Botones(int fil, int col, int num, String Tipo, String jugador){
        super();
        fila=fil;
        columna=col;
        numero=num;
        fantasma = new Ghosts();
        this.jugador = jugador;
    }
   
    public void setGhost(Ghosts fan){
        fantasma = new Ghosts(fan.Tipo, fan.ImagePath);
    }
    
    public void setImage(){
         if (this.fantasma !=null){
             int bWidth = this.getWidth();
             int bHeight = this.getHeight();
             int offset = this.getInsets().left;
             ImageIcon icon = new ImageIcon(getClass().getResource(fantasma.ImagePath));
             Icon icr = resize(icon,bWidth-offset,bHeight-offset);
             this.setIcon(icr);
         }
    }
   
     private static Icon resize(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();  
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
        return new ImageIcon(resizedImage);
    }

    void setIcon(String images_goodGpng) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
