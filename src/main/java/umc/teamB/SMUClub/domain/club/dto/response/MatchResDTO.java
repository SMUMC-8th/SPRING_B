package umc.teamB.SMUClub.domain.club.dto.response;

import lombok.Builder;
import umc.teamB.SMUClub.domain.club.entity.Club;

import java.util.List;
import java.util.stream.Collectors;

public class MatchResDTO {

    @Builder
    public record MatchResponseDTO(
            Long clubId,
            String name,
            String matchLevel, // "완벽 일치", "일부 조건 일치"
            List<String> hashtags,
            String detailUrl // 클릭시 각 동아리 개인 검색으로 이동
    ) {}

    @Builder
    public record MatchResponseListDTO(
            List<MatchResponseDTO> matches
    ) {}
}