package exception;

public class ErroInternoException extends Exception {

    public ErroInternoException(String errorMessage) {
        super("Ocorreu um erro!" + errorMessage);
    }
}
