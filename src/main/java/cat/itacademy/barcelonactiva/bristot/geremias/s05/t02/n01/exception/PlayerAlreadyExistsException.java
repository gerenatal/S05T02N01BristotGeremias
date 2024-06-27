package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception;

public class PlayerAlreadyExistsException extends RuntimeException {
    public PlayerAlreadyExistsException() {
        super("Player already exists");
    }
}
