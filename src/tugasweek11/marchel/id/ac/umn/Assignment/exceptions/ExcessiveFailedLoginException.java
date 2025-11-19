package tugasweek11.marchel.id.ac.umn.Assignment.exceptions;

public class ExcessiveFailedLoginException extends Exception {
    public ExcessiveFailedLoginException() {
        super("Anda telah mencapai jumlah batas login");
    }

    public ExcessiveFailedLoginException(String msg) {
        super(msg);
    }
}

