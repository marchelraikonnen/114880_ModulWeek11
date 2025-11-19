package tugasweek11.marchel.id.ac.umn.CustomExceptions;

public class InvalidPropertyException extends Exception {
    public InvalidPropertyException() {
        super("Input data tidak valid");
    }

    public InvalidPropertyException(String msg) {
        super(msg);
    }
}

