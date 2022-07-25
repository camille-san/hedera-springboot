package io.github.camillesan.hedera.errors;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ErrorCode {

    BAD_LOGIN("HED#001", HttpStatus.UNAUTHORIZED, "Login failed", "L'authentification a échoué"),
    NEW_USER_EMAIL_TAKEN("HED#002", HttpStatus.UNAUTHORIZED, "User already exists for this email", "Cet email est déjà enregistré"),
    NEW_USER_FIELD_MISSING("HED#003", HttpStatus.BAD_REQUEST, "One mandatory field is missing", "Un des champs obligatoires est manquant");

    @Getter
    private final String errorCode;
    @Getter
    private final HttpStatus httpStatus;
    @Getter
    private final String errorMessageEN;
    @Getter
    private final String errorMessageFR;

    ErrorCode(String errorCode, HttpStatus httpStatus, String errorMessageEN, String errorMessageFR) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessageEN = errorMessageEN;
        this.errorMessageFR = errorMessageFR;
    }

}
