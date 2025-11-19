package tugasweek11.marchel.id.ac.umn.Assignment.exceptions;

public class InvalidPropertyException extends Exception {
    public InvalidPropertyException() {
        super("Input data tidak valid");
    }

    public InvalidPropertyException(String msg) {
        super(msg);
    }
}

