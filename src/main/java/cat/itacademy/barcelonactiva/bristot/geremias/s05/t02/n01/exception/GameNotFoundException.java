package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException() {
        super("No game was found");
    }
}