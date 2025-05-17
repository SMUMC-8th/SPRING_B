package umc.teamB.SMUClub.domain.club.exception;

import umc.teamB.SMUClub.global.apiPayload.exception.CustomException;

public class ClubException extends CustomException {
    public ClubException(ClubErrorCode code) {
        super(code);
    }
}
