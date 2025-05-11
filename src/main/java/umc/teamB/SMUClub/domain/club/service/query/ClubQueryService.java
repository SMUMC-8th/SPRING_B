package umc.teamB.SMUClub.domain.club.service.query;

import umc.teamB.SMUClub.domain.club.dto.ClubResDTO;

import java.util.List;

public interface ClubQueryService {
    List<ClubResDTO.ClubResponseDTO> searchClubs(String keyword);
}
