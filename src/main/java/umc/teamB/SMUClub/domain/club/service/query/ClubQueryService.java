package umc.teamB.SMUClub.domain.club.service.query;

import umc.teamB.SMUClub.domain.club.dto.ClubResponseDTO;

import java.util.List;

public interface ClubQueryService {
    List<ClubResponseDTO> searchClubs(String keyword);
}
