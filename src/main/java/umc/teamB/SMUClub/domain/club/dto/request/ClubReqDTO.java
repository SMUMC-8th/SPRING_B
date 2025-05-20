package umc.teamB.SMUClub.domain.club.dto.request;

import lombok.Builder;
import umc.teamB.SMUClub.domain.club.enums.ActivityStyle;
import umc.teamB.SMUClub.domain.club.enums.Category;
import umc.teamB.SMUClub.domain.club.enums.ClubPurpose;
import umc.teamB.SMUClub.domain.club.enums.RecruitmentType;
import umc.teamB.SMUClub.domain.clubimage.dto.ClubImageDTO;

import java.time.LocalDate;
import java.util.List;

public class ClubReqDTO {

    @Builder
    public record ClubRequestDTO(
            String name,
            String description,
            String instagram,
            String activity,
            String recruitmentDate,
            String target,
            String recruitmentMethod,
            LocalDate firstStart,
            LocalDate firstEnd,
            LocalDate secondStart,
            LocalDate secondEnd,
            // Category는 ENUM이기에 JSON 값과 정확히 일치하면 Front에서 String 으로 보낸 것을 Jackson이 ENUM 자동 매핑해줌
            Category category,
            ClubPurpose purpose,
            ActivityStyle activityStyle,
            RecruitmentType recruitmentType,
            List<ClubImageDTO.ClubImageUploadDTO> imageUrl,
            List<String> hashtags
    ) {}
}
