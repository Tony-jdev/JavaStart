package homework5.exceptions.user;

public class ATMWrongAmountException extends ATMUserErrorException {

    public ATMWrongAmountException(String message) {
        super(message);
    }
}
