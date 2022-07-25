package io.github.camillesan.hedera.exceptions;

import io.github.camillesan.hedera.errors.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HederaException extends RuntimeException {

    private ErrorCode errorCode;

}
