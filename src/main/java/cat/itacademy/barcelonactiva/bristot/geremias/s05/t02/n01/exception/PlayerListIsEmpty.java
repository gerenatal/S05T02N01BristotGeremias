package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception;

public class PlayerListIsEmpty extends RuntimeException{
    public PlayerListIsEmpty(){
        super("Player list is empty");
    }
}
