package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception;

public class PlayerListIsEmptyException extends RuntimeException{
    public PlayerListIsEmptyException(){
        super("Player list is empty");
    }
}
