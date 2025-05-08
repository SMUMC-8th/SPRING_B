package umc.teamB.SMUClub.global.apiPayload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonPropertyOrder({"isSuccess", "status", "code", "message", "result"})
public class CustomResponse<T> {

    @JsonProperty("isSuccess") // isSuccess라는 변수라는 것을 명시하는 Annotation
    private boolean isSuccess;

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("result")
    private final T result;

    //기본적으로 200 OK를 사용하는 성공 응답 생성 메서드
    public static <T> CustomResponse<T> onSuccess(T result) {
        return new CustomResponse<>(true, String.valueOf(HttpStatus.OK.value()), HttpStatus.OK.getReasonPhrase(), result);
    }

    //상태 코드를 받아서 사용하는 성공 응답 생성 메서드
    public static <T> CustomResponse<T> onSuccess(HttpStatus status, T result) {
        return new CustomResponse<>(true, String.valueOf(status.value()), status.getReasonPhrase(), result);
    }

    //실패 응답 생성 메서드 (데이터 포함)
    public static <T> CustomResponse<T> onFailure(String code, String message, T result) {
        return new CustomResponse<>(false, code, message, result);
    }

    //실패 응답 생성 메서드 (데이터 없음)
    public static <T> CustomResponse<T> onFailure(String code, String message) {
        return new CustomResponse<>(false, code, message, null);
    }

    // value() -> 해당 상태의 숫자 코드(int)를 반환
    // ex) HttpStatus.NOT_FOUND.value() -> 404

    // String.valueOf() -> 숫자 상태 코드를 문자열(String)로 바꾸기 위해 사용
    // ex) String.valueOf(200) -> "200"

    // status.getReasonPhrase() -> 상태 코드에 대응되는 표준 메시지를 반환
    // ex) HttpStatus.OK.getReasonPhrase() -> "OK"
}

