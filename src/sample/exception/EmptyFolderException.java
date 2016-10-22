package sample.exception;

/**
 * Created by User on 14.03.2016.
 */
public class EmptyFolderException extends Exception {
    public EmptyFolderException() {}

    //Constructor that accepts a message
    public EmptyFolderException(String message)
    {
        super(message);
    }
}
