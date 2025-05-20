package umc.teamB.SMUClub.domain.club.service.command;

import umc.teamB.SMUClub.domain.club.dto.request.ClubReqDTO;

public interface ClubCommandService {
    void createClub(ClubReqDTO.ClubRequestDTO dto);
}