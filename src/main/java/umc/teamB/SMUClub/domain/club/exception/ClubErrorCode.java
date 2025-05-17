package umc.teamB.SMUClub.domain.club.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.teamB.SMUClub.global.apiPayload.code.BaseErrorCode;

@AllArgsConstructor
@Getter
public enum ClubErrorCode implements BaseErrorCode {

    //BAD_REQUEST_400(HttpStatus.BAD_REQUEST, "CLUB400", "잘못된 요청입니다"),

    //UNAUTHORIZED_401(HttpStatus.UNAUTHORIZED, "CLUB401", "인증이 필요합니다"),

    //FORBIDDEN_403(HttpStatus.FORBIDDEN, "CLUB403", "접근이 금지되었습니다"),

    NOT_FOUND_404(HttpStatus.NOT_FOUND, "CLUB404", "해당하는 동아리가 없습니다. 다시 입력해주세요.");

    //INTERNAL_SERVER_ERROR_500(HttpStatus.INTERNAL_SERVER_ERROR, "CLUB500", "서버 내부 오류가 발생했습니다"),


    // 필요한 필드값 선언
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}

