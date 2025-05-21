package umc.teamB.SMUClub;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.teamB.SMUClub.domain.club.dto.response.ClubResDTO;
import umc.teamB.SMUClub.domain.club.service.query.ClubQueryService;
import umc.teamB.SMUClub.global.apiPayload.CustomResponse;

import java.util.List;

import static umc.teamB.SMUClub.domain.club.code.ClubSuccessCode.CLUB200;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "Main", description = "Main 화면 API")
public class MainController {

    private final ClubQueryService clubQueryService;

    @GetMapping("/")
    @Operation(summary = "카테고리별 동아리 랜덤 띄우는 API -by 윤영석")
    public CustomResponse<List<ClubResDTO.ClubResponseDTO>> randomClubs() {
        List<ClubResDTO.ClubResponseDTO> results = clubQueryService.getRandomClubs();
        return CustomResponse.onSuccess(CLUB200, results);
    }
}
