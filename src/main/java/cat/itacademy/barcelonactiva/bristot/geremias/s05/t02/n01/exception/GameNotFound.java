package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception;

public class GameNotFound extends RuntimeException {
    public GameNotFound() {
        super("No game was found");
    }
}