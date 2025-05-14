package umc.teamB.SMUClub.domain.club.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.teamB.SMUClub.domain.club.dto.ClubResDTO;
import umc.teamB.SMUClub.domain.club.service.query.ClubQueryService;
import umc.teamB.SMUClub.global.apiPayload.CustomResponse;

import java.util.List;

import static umc.teamB.SMUClub.domain.club.code.ClubSuccessCode.CLUB200;

@RestController
@RequestMapping("/clubs")
@RequiredArgsConstructor
public class ClubController {

    private final ClubQueryService clubQueryService;

    @GetMapping
    public CustomResponse<List<ClubResDTO.ClubResponseDTO>> searchClubs(@RequestParam String keyword) {
        List<ClubResDTO.ClubResponseDTO> results = clubQueryService.searchClubs(keyword);
        return CustomResponse.onSuccess(CLUB200, results);
    }
}
