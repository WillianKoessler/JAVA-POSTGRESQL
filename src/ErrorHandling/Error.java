package ErrorHandling;

public class Error extends Exception {

    private String msg, src;
    private Severity sev;
    private Exception prev;

    public enum Severity {
        LOW, MEDIUM, HIGH
    };

    public Error(String message, String source, Severity s, Exception previous) {
        super("*****ERROR*****"
                + "\nSOURCE: " + source
                + "\nMESSAGE: " + message
                + "\nSEVERITY: " + s
                + "\nPrevious Exception: " + previous.getMessage()
        );
        msg = message;
        src = source;
        sev = s;
        prev = previous;

    }

    public String message() {
        return msg;
    }
}
