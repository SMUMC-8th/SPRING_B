package umc.teamB.SMUClub.domain.notice.exception;

import umc.teamB.SMUClub.global.apiPayload.exception.CustomException;

public class NoticeException extends CustomException {
    public NoticeException(NoticeErrorCode code) {
        super(code);
    }
}
