package uz.elmurodov.exception;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.enums.HttpStatus;

@Getter
@Setter
public class BaseException extends RuntimeException {
    private HttpStatus status;

    public BaseException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public BaseException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
