package umc.teamB.SMUClub.global.apiPayload.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import umc.teamB.SMUClub.global.apiPayload.CustomResponse;
import umc.teamB.SMUClub.global.apiPayload.code.BaseErrorCode;
import umc.teamB.SMUClub.global.apiPayload.code.GeneralErrorCode;
import umc.teamB.SMUClub.global.apiPayload.exception.CustomException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 컨트롤러 메서드에서 @Valid 어노테이션을 사용하여 DTO의 유효성 검사를 수행
    // @NotBlank, @Email 등이 붙어 있는데, 값이 잘못되면 이 예외 발생
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<CustomResponse<Map<String, String>>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        // 검사에 실패한 필드와 그에 대한 메시지를 저장하는 Map

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        BaseErrorCode validationErrorCode = GeneralErrorCode.VALIDATION_FAILED; // BaseErrorCode로 통일

        CustomResponse<Map<String, String>> errorResponse = CustomResponse.onFailure(
                validationErrorCode.getCode(),
                validationErrorCode.getMessage(),
                errors
        );
        // 에러 코드, 메시지와 함께 errors를 반환
        return ResponseEntity.status(validationErrorCode.getHttpStatus()).body(errorResponse);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomResponse<Void>> handleCustomException(CustomException ex) {
        log.warn("[ CustomException ]: {}", ex.getCode().getMessage());

        BaseErrorCode errorCode = ex.getCode();

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(errorCode.getErrorResponse());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<CustomResponse<String>> handleGeneralException(Exception ex) {
        log.error("[WARNING] Internal Server Error : {} ", ex.getMessage());

        BaseErrorCode errorCode = GeneralErrorCode.INTERNAL_SERVER_ERROR_500;

        CustomResponse<String> errorResponse = CustomResponse.onFailure(
                errorCode.getCode(),
                errorCode.getMessage(),
                null
        );

        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(errorResponse);
    }
}
// 프레임워크 내부 호출에만 쓰이고, api 응답을 처리하는 내부 로직이기 때문에 protected 사용
// 명확하게 공개하는 느낌으로 작성하기 때문에 public 사용
