package umc.teamB.SMUClub.domain.club.converter;

import umc.teamB.SMUClub.domain.club.dto.ClubResDTO;
import umc.teamB.SMUClub.domain.club.entity.Club;

public class ClubConverter {
    public static ClubResDTO.ClubDateDTO toClubDateDto(Club club) {
        return ClubResDTO.ClubDateDTO.builder()
                .firstStart(club.getFirstStart())
                .firstEnd(club.getFirstEnd())
                .secondStart(club.getSecondStart())
                .secondEnd(club.getSecondEnd())
                .build();
    }
}
