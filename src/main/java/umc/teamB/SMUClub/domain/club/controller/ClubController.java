package umc.teamB.SMUClub.domain.club.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.teamB.SMUClub.domain.club.dto.ClubResDTO;
import umc.teamB.SMUClub.domain.club.service.query.ClubQueryService;
import umc.teamB.SMUClub.global.apiPayload.CustomResponse;

@RestController
@RequestMapping("/clubs")
@RequiredArgsConstructor
@Tag(name = "Club", description = "Club 관련 API")
public class ClubController {

    private final ClubQueryService clubQueryService;

    @GetMapping("/calendar/{clubId}")
    @Operation(summary="동아리 일정 출력 API -by 양효인")
    public CustomResponse<ClubResDTO.ClubDateDTO> getDates(@PathVariable Long clubId){
        ClubResDTO.ClubDateDTO result = clubQueryService.getDates(clubId);
        return CustomResponse.onSuccess(result);
    }

}
