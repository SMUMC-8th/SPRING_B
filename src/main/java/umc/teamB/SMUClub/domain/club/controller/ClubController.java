package umc.teamB.SMUClub.domain.club.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.teamB.SMUClub.domain.club.dto.request.MatchReqDTO;
import umc.teamB.SMUClub.domain.club.dto.response.MatchResDTO;
import umc.teamB.SMUClub.domain.club.service.query.ClubQueryService;
import umc.teamB.SMUClub.global.apiPayload.CustomResponse;

@RestController
@RequiredArgsConstructor
public class ClubController {

    private final ClubQueryService clubQueryService;

    @PostMapping("/clubs/matching")
    public CustomResponse<MatchResDTO.MatchResponseListDTO> recommendClubs(
            @RequestBody MatchReqDTO.MatchRequestDTO request) {
        MatchResDTO.MatchResponseListDTO result = clubQueryService.getMatchClubs(request);

        return CustomResponse.onSuccess(result);
    }
}
