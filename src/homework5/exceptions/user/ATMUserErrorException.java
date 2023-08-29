package homework5.exceptions.user;

import homework5.exceptions.atm.ATMException;

public class ATMUserErrorException extends ATMException {

    public ATMUserErrorException(String message) {
        super(message);
    }
}
