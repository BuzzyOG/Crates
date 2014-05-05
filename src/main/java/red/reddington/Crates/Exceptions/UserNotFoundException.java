package red.reddington.Crates.Exceptions;

/**
 * Created by Ryan on 5/4/2014.
 */
public class UserNotFoundException  extends RuntimeException {
    public UserNotFoundException(){
        super();
    }
    public UserNotFoundException(String message){
        super(message);

    }
}

