package umc.teamB.SMUClub.domain.club.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.teamB.SMUClub.global.apiPayload.code.BaseSuccessCode;
import umc.teamB.SMUClub.global.apiPayload.code.GeneralSuccessCode;

@Getter
@AllArgsConstructor
public enum ClubSuccessCode implements BaseSuccessCode {
    CLUB200(HttpStatus.OK, "CLUB200", "성공적으로 처리했습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
