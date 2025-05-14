package umc.teamB.SMUClub.domain.club.service.query;

import umc.teamB.SMUClub.domain.club.dto.ClubResDTO;
import umc.teamB.SMUClub.domain.club.enums.Category;

import java.util.List;

public interface ClubQueryService {
    List<ClubResDTO.ClubResponseDTO> searchClubs(String keyword);
    List<ClubResDTO.ClubResponseDTO> getClubsByCategory(Category category);
    ClubResDTO.ClubDetailResponseDTO getClubById(Long id);
}
