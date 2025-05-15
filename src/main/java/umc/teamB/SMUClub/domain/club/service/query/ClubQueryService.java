package umc.teamB.SMUClub.domain.club.service.query;

import umc.teamB.SMUClub.domain.club.dto.ClubResDTO;

public interface ClubQueryService {
    ClubResDTO.ClubDateDTO getDates(Long id);
}
