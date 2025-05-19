package umc.teamB.SMUClub.domain.clubimage.dto;

import lombok.Builder;

public class ClubImageDTO {

    @Builder
    public record ClubImageUploadDTO(
            String imageUrl,
            boolean isThumbnail
    ) {}
}
