package cat.itacademy.barcelonactiva.bristot.geremias.s05.t02.n01.exception;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(){
        super("This email already exists");
    }
}
