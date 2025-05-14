package umc.teamB.SMUClub.domain.club.converter;

import umc.teamB.SMUClub.domain.club.dto.ClubResDTO;
import umc.teamB.SMUClub.domain.club.entity.Club;

import java.util.List;
import java.util.stream.Collectors;

public class ClubConverter {

    public static ClubResDTO.ClubResponseDTO toClubResponseDto(Club club) {
        return ClubResDTO.ClubResponseDTO.builder()
                .clubId(club.getId())
                .name(club.getName())
                .imageUrl(club.getImageUrl())
                .description(club.getDescription())
                .category(club.getCategory())
                .hashtags(club.getClubHashtagList().stream()
                    .map(ch -> ch.getHashtag().getName())
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
                .imageUrl(club.getImageUrl())
                .description(club.getDescription())
                .target(club.getTarget())  // 예시로, 'target' 필드가 있다고 가정
                .start(club.getStart())  // LocalDate 타입 필드라고 가정
                .end(club.getEnd())  // LocalDate 타입 필드라고 가정
                .instagram(club.getInstagram())  // Instagram URL 혹은 아이디
                .build();
    }

}
