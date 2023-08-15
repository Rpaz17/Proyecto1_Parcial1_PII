package Login_Registro;

public class Configuracion {
    private int cuentaConfiguracion = 0;
    private LoginSwing login;
    private Configuracion config;
    private Jugador jugador;
    private int contador = 0;
    
    public void setLoginSwing (LoginSwing log){
        this.login=log;
    }
    
    public void setJugador(Jugador jugador){
        this.jugador=jugador;
    }
    
    public void click(){
        contador++;
    }
    
    public int getContador(){
        return contador;
    }
}
