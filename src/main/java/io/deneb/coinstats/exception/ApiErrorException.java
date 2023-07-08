package io.deneb.coinstats.exception;

/**
 * API 처리 실패 시 실패에 대한 예외를 처리한다.
 */
public class ApiErrorException extends RuntimeException {

    private static final String FORMAT = "오류사유: %s ";

    public ApiErrorException(String message) {
        super(String.format(FORMAT, message));
    }
}
