package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception;

public class PlayerAlreadyExists extends RuntimeException {
    public PlayerAlreadyExists() {
        super("Player already exists");
    }
}
