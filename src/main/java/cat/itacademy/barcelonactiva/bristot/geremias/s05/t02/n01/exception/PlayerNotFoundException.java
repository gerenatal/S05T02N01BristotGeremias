package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(){
        super("Player not found");
    }
}
