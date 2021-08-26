package exceptions;
/**
 * @author amalyahayrapetova
 */

public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException(String message){
        super(message);
    }
}
