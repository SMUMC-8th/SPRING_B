package umc.teamB.SMUClub.domain.club.converter;

import umc.teamB.SMUClub.domain.club.dto.response.ClubResDTO;
import umc.teamB.SMUClub.domain.club.entity.Club;
import umc.teamB.SMUClub.domain.clubimage.entity.ClubImage;

import java.util.List;
import java.util.stream.Collectors;

public class ClubConverter {

    public static ClubResDTO.ClubResponseDTO toClubResponseDto(Club club) {
        return ClubResDTO.ClubResponseDTO.builder()
                .clubId(club.getId())
                .name(club.getName())
                // 대표 이미지 한 개만 가져옴
                .imageUrl(club.getImages().stream()
                        .filter(ClubImage::isThumbnail)
                        .map(ClubImage::getImageUrl)
                        .findFirst()
                        .orElse(null)
                )
                .category(club.getCategory())
                .description(club.getDescription())
                .hashtags(club.getClubHashtagList().stream()
                    .map(ch -> "# " + ch.getHashtag().getName())
                    .collect(Collectors.toList()))
                .build();

    }

    public static List<ClubResDTO.ClubResponseDTO> toClubResponseDtoList(List<Club> clubs) {
        return clubs.stream()
                .map(ClubConverter::toClubResponseDto)
                .collect(Collectors.toList());
    }

    public static ClubResDTO.ClubDetailResponseDTO toClubDetailResponseDto(Club club) {
        return ClubResDTO.ClubDetailResponseDTO.builder()
                .clubId(club.getId())
                .name(club.getName())
                .category(club.getCategory())  // Category enum이므로 그대로 사용
                .imageUrl(club.getImages().stream()
                        .map(ClubImage::getImageUrl)
                        .collect(Collectors.toList()))
                .description(club.getDescription())
                .target(club.getTarget())  // 모집 대상
                .recruitmentDate(club.getRecruitmentDate())
                .recruitmentMethod(club.getRecruitmentMethod())
                .activity(club.getActivity())
                .instagram(club.getInstagram())
                .build();
    }

    public static ClubResDTO.ClubDateDTO toClubDateDto(Club club) {
        return ClubResDTO.ClubDateDTO.builder()
                .firstStart(club.getFirstStart())
                .firstEnd(club.getFirstEnd())
                .secondStart(club.getSecondStart())
                .secondEnd(club.getSecondEnd())
                .build();
    }

}
