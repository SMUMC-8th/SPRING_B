package umc.teamB.SMUClub.domain.club.dto;

import lombok.Builder;
import lombok.Getter;
import umc.teamB.SMUClub.domain.club.entity.Club;
import umc.teamB.SMUClub.domain.mapping.ClubHashtag;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class ClubResponseDTO {

    private Long clubId;
    private String name;
    private String imageUrl;
    private String description;
    private String category;
    private List<String> hashtags;

    public static ClubResponseDTO fromEntity(Club club) {
        return ClubResponseDTO.builder()
                .clubId(club.getId())
                .name(club.getName())
                .imageUrl(club.getImageUrl())
                .description(club.getDescription())
                .category(club.getCategory().name())
                .hashtags(club.getClubHashtagList().stream()
                        .map(ch -> ch.getHashtag().getName())
                        .collect(Collectors.toList()))
                .build();
    }
}
