package sample;

/**
 * Created by User on 14.03.2016.
 */
public class IndefinedTypeException extends Exception{
    public IndefinedTypeException() {}

    //Constructor that accepts a message
    public IndefinedTypeException(String message)
    {
        super(message);
    }

}
