package tugasweek11.marchel.id.ac.umn.CustomExceptions;

public class AuthenticationException extends Exception {
    public AuthenticationException() {
        super("Anda telah mencapai jumlah batas login");
    }

    public AuthenticationException(String msg) {
        super(msg);
    }
}

