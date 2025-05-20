package umc.teamB.SMUClub.domain.club.dto.response;

import lombok.Builder;
import umc.teamB.SMUClub.domain.club.enums.Category;

import java.time.LocalDate;
import java.util.List;

public class ClubResDTO {

    @Builder
    public record ClubResponseDTO(
            Long clubId,
            String name,
            String imageUrl,
            String description,
            Category category,
            List<String> hashtags
    ) {}

    @Builder
    public record ClubDetailResponseDTO(
            Long clubId,
            String name,
            Category category,
            List<String> imageUrl,
            String description,
            String target,
            String recruitmentDate,
            String recruitmentMethod,
            String activity,
            String instagram
    ) {}

    @Builder
    public record ClubDateDTO(
            LocalDate firstStart,
            LocalDate firstEnd,
            LocalDate secondStart,
            LocalDate secondEnd
    ) {}
}
