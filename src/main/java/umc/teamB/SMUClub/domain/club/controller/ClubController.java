package umc.teamB.SMUClub.domain.club.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.teamB.SMUClub.domain.club.dto.ClubResDTO;
import umc.teamB.SMUClub.domain.club.dto.request.MatchReqDTO;
import umc.teamB.SMUClub.domain.club.dto.response.MatchResDTO;
import umc.teamB.SMUClub.domain.club.enums.Category;
import umc.teamB.SMUClub.domain.club.service.query.ClubQueryService;
import umc.teamB.SMUClub.global.apiPayload.CustomResponse;

import java.util.List;

import static umc.teamB.SMUClub.domain.club.code.ClubSuccessCode.CLUB200;

@RestController
@RequestMapping("/clubs")
@RequiredArgsConstructor
@Tag(name = "Club", description = "Club 관련 API")
public class ClubController {

    private final ClubQueryService clubQueryService;

    @PostMapping("/clubs/matching")
    public CustomResponse<MatchResDTO.MatchResponseListDTO> recommendClubs(
            @RequestBody MatchReqDTO.MatchRequestDTO request) {
        MatchResDTO.MatchResponseListDTO result = clubQueryService.getMatchClubs(request);

        return CustomResponse.onSuccess(result);
    }

    @GetMapping("/search")
    @Operation(summary = "동아리 검색 API -by 윤영석")
    public CustomResponse<List<ClubResDTO.ClubResponseDTO>> searchClubs(@RequestParam String keyword) {
        List<ClubResDTO.ClubResponseDTO> results = clubQueryService.searchClubs(keyword);
        return CustomResponse.onSuccess(CLUB200, results);
    }

    @GetMapping("/category/{category}")
    @Operation(summary = "카테고리별 동아리 목록 조회 API -by 윤영석")
    public CustomResponse<List<ClubResDTO.ClubResponseDTO>> getClubsByCategory(@PathVariable Category category) {
        List<ClubResDTO.ClubResponseDTO> results = clubQueryService.getClubsByCategory(category);
        return CustomResponse.onSuccess(CLUB200, results);
    }

    @GetMapping("/{clubId}")
    @Operation(summary = "동아리 상세 페이지 조회 API -by 윤영석")
    public CustomResponse<ClubResDTO.ClubDetailResponseDTO> getClub(@PathVariable Long clubId) {
        ClubResDTO.ClubDetailResponseDTO result = clubQueryService.getClubById(clubId);
        return CustomResponse.onSuccess(CLUB200, result);
    }
    
    @GetMapping("/calendar/{clubId}")
    @Operation(summary="동아리 일정 출력 API -by 양효인")
    public CustomResponse<ClubResDTO.ClubDateDTO> getDates(@PathVariable Long clubId){
        ClubResDTO.ClubDateDTO result = clubQueryService.getDates(clubId);
        return CustomResponse.onSuccess(result);
    }

}
