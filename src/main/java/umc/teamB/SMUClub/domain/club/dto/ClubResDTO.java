package umc.teamB.SMUClub.domain.club.dto;

import lombok.Builder;
import umc.teamB.SMUClub.domain.club.enums.Category;

import java.time.LocalDate;
import java.util.List;

public class ClubResDTO {
    @Builder
    public record ClubDateDTO(
            LocalDate firstStart,
            LocalDate firstEnd,
            LocalDate secondStart,
            LocalDate secondEnd
    ) {}
}
