package uz.elmurodov.exception;

import lombok.Getter;
import uz.elmurodov.enums.HttpStatus;

@Getter
public class InvalidInputException extends BaseException {
    private final HttpStatus status;

    public InvalidInputException(String message, HttpStatus status) {
        super(message, status);
        this.status = HttpStatus.HTTP_400;
    }
}
