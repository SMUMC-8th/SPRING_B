package umc.teamB.SMUClub.global.apiPayload.code;

import org.springframework.http.HttpStatus;
import umc.teamB.SMUClub.global.apiPayload.CustomResponse;

public interface BaseErrorCode {

    HttpStatus getHttpStatus();
    String getCode();
    String getMessage();

    default CustomResponse<Void> getErrorResponse() {
        return CustomResponse.onFailure(getCode(), getMessage());
    }
}
