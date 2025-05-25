package umc.teamB.SMUClub.domain.club.converter;

import umc.teamB.SMUClub.domain.club.dto.response.MatchResDTO;
import umc.teamB.SMUClub.domain.club.entity.Club;
import umc.teamB.SMUClub.domain.clubimage.entity.ClubImage;

import java.util.stream.Collectors;

public class MatchConverter {

    // Club Entity -> MatchResponseDTO
    public static MatchResDTO.MatchResponseDTO from(Club club, int matchScore) {
        return MatchResDTO.MatchResponseDTO.builder()
                .clubId(club.getId())
                .name(club.getName())
                .matchLevel(scoreToLevel(matchScore))
                .imageUrl(club.getImages().stream()
                        .filter(ClubImage::isThumbnail)
                        .map(ClubImage::getImageUrl)
                        .findFirst()
                        .orElse(null)
                )
                .hashtags(club.getClubHashtagList().stream()
                        .map(ch -> "#" + ch.getHashtag().getName())
                        .collect(Collectors.toList()))
                .detailUrl("/clubs/" + club.getCategory() + "/" + club.getId())
                .build();
    }

    private static String scoreToLevel(int score) {
        return switch (score) {
            case 4 -> "완벽 일치";
            case 3 -> "일부 조건 일치";
            default -> "추천 제외";
        };
    }
}
