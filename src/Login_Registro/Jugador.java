package Login_Registro;

import java.awt.List;
import java.util.ArrayList;
import java.util.Calendar;

public class Jugador  implements Comparable<Jugador> { 
    
    /* En esta sección se inicializan los atributos de cada jugador*/
   public String playersName;
    public String password;
    public ArrayList<String> gamesLogged;
    public int points;

    
    /* Se crea el constructor de la clase Jugador*/
    public Jugador(String playersName, String password) {
        this.playersName = playersName;
        this.password = password;
        this.gamesLogged = new ArrayList();
        points = 0 ;
    }
    
    // Set y get de cada atributo
    public String getPlayersName() {
        return playersName;
    }

    public String getPassword() {
        return password;
    }

    public void setPlayersName(String playersName) {
        this.playersName = playersName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getGamesLogged(){
        return gamesLogged;
    }

//    public String[] getPartidas() {
//    String[] reversedPartidas = new String[partidas.length];
//    for (int i = 0; i < partidas.length; i++) {
//        reversedPartidas[i] = partidas[partidas.length - i - 1];
//    }
//    return reversedPartidas;
//}
    public void addPoints() {
        this.points +=3 ;
    }
    
    public int getPoints() {
        return points;
    }
    
    public void listar(){
        
    }

    @Override
    public int compareTo(Jugador otroJugador) {
        return Integer.compare(getPoints(), otroJugador.getPoints());
    }
}
