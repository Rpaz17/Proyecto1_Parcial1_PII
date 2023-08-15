package Login_Registro;

import java.util.ArrayList;

public class Jugador { 
    
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

    public void addPoints() {
        this.points +=3 ;
    }
    
    public int getPoints() {
        return points;
    }
}
