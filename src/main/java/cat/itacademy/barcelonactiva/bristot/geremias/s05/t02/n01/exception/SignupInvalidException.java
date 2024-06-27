package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception;

public class SignupInvalidException extends RuntimeException{
    public SignupInvalidException(){
        super("Invalid username or password");
    }
}
