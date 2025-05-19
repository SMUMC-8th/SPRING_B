package umc.teamB.SMUClub.domain.club.service.query;

import umc.teamB.SMUClub.domain.club.dto.request.MatchReqDTO;
import umc.teamB.SMUClub.domain.club.dto.response.MatchResDTO;

import umc.teamB.SMUClub.domain.club.dto.response.ClubResDTO;
import umc.teamB.SMUClub.domain.club.enums.Category;

import java.util.List;

public interface ClubQueryService {
    MatchResDTO.MatchResponseListDTO getMatchClubs(MatchReqDTO.MatchRequestDTO request);
    List<ClubResDTO.ClubResponseDTO> searchClubs(String keyword);
    List<ClubResDTO.ClubResponseDTO> getClubsByCategory(Category category);
    ClubResDTO.ClubDetailResponseDTO getClubById(Long id);
    ClubResDTO.ClubDateDTO getDates(Long id);
}
