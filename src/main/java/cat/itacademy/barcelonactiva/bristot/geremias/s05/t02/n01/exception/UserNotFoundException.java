package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        super("User not found");
    }
}
