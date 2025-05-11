package umc.teamB.SMUClub.domain.club.dto;

import lombok.Builder;
import umc.teamB.SMUClub.domain.club.enums.Category;

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

}
