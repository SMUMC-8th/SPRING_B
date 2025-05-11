package umc.teamB.SMUClub.domain.club.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.teamB.SMUClub.domain.club.dto.ClubResponseDTO;
import umc.teamB.SMUClub.domain.club.service.query.ClubQueryService;
import umc.teamB.SMUClub.global.apiPayload.CustomResponse;

import java.util.List;

@RestController
@RequestMapping("/clubs")
@RequiredArgsConstructor
public class ClubController {

    private final ClubQueryService clubQueryService;

    @GetMapping
    public ResponseEntity<CustomResponse<List<ClubResponseDTO>>> searchClubs(@RequestParam String keyword) {
        List<ClubResponseDTO> results = clubQueryService.searchClubs(keyword);
        return ResponseEntity.ok(CustomResponse.onSuccess(results));
    }
}
