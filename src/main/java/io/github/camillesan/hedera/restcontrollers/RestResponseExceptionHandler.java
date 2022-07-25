package io.github.camillesan.hedera.restcontrollers;

import io.github.camillesan.hedera.errors.ErrorCode;
import io.github.camillesan.hedera.exceptions.HederaException;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestResponseExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {HederaException.class})
    protected ResponseEntity<Object> handleError(
            HederaException ex, WebRequest request) {
        return new ResponseEntity<>(new Error(ex.getErrorCode()), ex.getErrorCode().getHttpStatus());
    }
}

@Data
class Error {

    private String errorCode;
    private String errorMessageEN;
    private String errorMessageFR;

    public Error(ErrorCode errorCode) {
        this.errorCode = errorCode.getErrorCode();
        this.errorMessageEN = getErrorMessageEN();
        this.errorMessageFR = getErrorMessageFR();
    }
}