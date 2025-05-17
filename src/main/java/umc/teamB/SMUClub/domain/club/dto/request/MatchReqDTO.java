package umc.teamB.SMUClub.domain.club.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import umc.teamB.SMUClub.domain.club.enums.ActivityStyle;
import umc.teamB.SMUClub.domain.club.enums.ClubPurpose;
import umc.teamB.SMUClub.domain.club.enums.RecruitmentType;

public class MatchReqDTO {

    @Builder
    public record MatchRequestDTO(
            @JsonProperty("어떤 방향의 경험을 기대")
            ClubPurpose purpose,

            @JsonProperty("원하는 활동 방식을 선택")
            ActivityStyle activityStyle,

            @JsonProperty("모집 방식")
            RecruitmentType recruitmentType
    ) {}
}
