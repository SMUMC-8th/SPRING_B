package umc.teamB.SMUClub.domain.club.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.teamB.SMUClub.global.apiPayload.code.BaseErrorCode;

@AllArgsConstructor
@Getter
public enum ClubErrorCode implements BaseErrorCode {
    NOT_FOUND_404(HttpStatus.NOT_FOUND, "CLUB404", "해당하는 동아리가 없습니다. 다시 입력해주세요.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

}
