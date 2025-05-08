package umc.teamB.SMUClub.global.apiPayload.exception;

import lombok.Getter;
import umc.teamB.SMUClub.global.apiPayload.code.BaseErrorCode;

@Getter
public class CustomException extends RuntimeException{

    private final BaseErrorCode code;

    public CustomException(BaseErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode;
    }
}
