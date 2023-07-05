package io.deneb.coinstats.presenter;

public record ApiResponse<T>(String message, T data) {

    /**
     * API 처리 성공에 대한 응답값을 설정한다.
     */
    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>("success", data);
    }
}
