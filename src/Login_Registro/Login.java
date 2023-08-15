package Login_Registro;

import java.util.ArrayList;

public class Login {

    public ArrayList<Jugador> jugadorArreglo;
    Jugador jugador;

    public Login() {
        jugadorArreglo = new ArrayList<Jugador>();
    }

    /*
    A continuacion tenemos el uso de recursividad 
    Se utiliza para poder recorrer el arreglo de los jugador,
    si se encuentra el nombre del jugador entonces lo deja ingresar,
    pero si no enviara un mensaje diciendo que ese jugador no existe.
     */
    public Jugador buscarJugador(String playerName) {
        return buscarJugador(playerName, 0);
    }

    public Jugador buscarJugador(String playerName, int pos) {
        if (pos >= jugadorArreglo.size()) {
            return null;
        }
        Jugador player = jugadorArreglo.get(pos);
        if (player != null && player.getPlayersName().equals(playerName)) {
            return player;
        } else {
            return buscarJugador(playerName, pos + 1);
        }
    }

    public boolean addPlayer(Jugador jugador) {
        Jugador searchPlayer = buscarJugador(jugador.getPlayersName());
        if (searchPlayer == null) {
            Jugador newPlayer = new Jugador(jugador.getPlayersName(), jugador.getPassword());
            jugadorArreglo.add(newPlayer);
            return true;
        }
        return false;
    }

    public boolean cambiarContraseña(String password, String name) {
        Jugador cambiar = buscarJugador(name);
        if (cambiar != null) {
            jugador.setPassword(jugador.getPassword());
            return true;
        } else {
            return false;
        }
    }

}
