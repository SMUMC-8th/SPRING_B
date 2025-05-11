package umc.teamB.SMUClub.domain.club.converter;

import umc.teamB.SMUClub.domain.club.dto.ClubResDTO;
import umc.teamB.SMUClub.domain.club.entity.Club;

import java.util.List;
import java.util.stream.Collectors;

public class ClubConverter {

    public static ClubResDTO.ClubResponseDTO toDto(Club club) {
        return ClubResDTO.ClubResponseDTO.builder()
                .clubId(club.getId())
                .name(club.getName())
                .imageUrl(club.getImageUrl())
                .description(club.getDescription())
                .category(club.getCategory())
                .hashtags(club.getClubHashtagList().stream()
                    .map(ch -> "#" + ch.getHashtag().getName())
                    .collect(Collectors.toList()))
                .build();

    }

    public static List<ClubResDTO.ClubResponseDTO> toDtoList(List<Club> clubs) {
        return clubs.stream()
                .map(ClubConverter::toDto)
                .collect(Collectors.toList());
    }
}
