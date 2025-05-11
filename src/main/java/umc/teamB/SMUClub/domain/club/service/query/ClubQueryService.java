package umc.teamB.SMUClub.domain.club.service.query;

import umc.teamB.SMUClub.domain.club.dto.request.MatchReqDTO;
import umc.teamB.SMUClub.domain.club.dto.response.MatchResDTO;
import umc.teamB.SMUClub.domain.club.entity.Club;

public interface ClubQueryService {
    MatchResDTO.MatchResponseListDTO getMatchClubs(MatchReqDTO.MatchRequestDTO request);
}
