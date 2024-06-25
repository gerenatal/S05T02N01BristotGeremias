package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception;

public class PlayerNotFound extends RuntimeException{
    public PlayerNotFound(){
        super("Player not found");
    }
}
