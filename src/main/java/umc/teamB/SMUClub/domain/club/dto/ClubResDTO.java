package umc.teamB.SMUClub.domain.club.dto;

import lombok.Builder;
import umc.teamB.SMUClub.domain.club.enums.Category;

import java.time.LocalDate;
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

    @Builder
    public record ClubDetailResponseDTO(
            Long clubId,
            String name,
            Category category,
            String imageUrl,
            String description,
            String target,
            LocalDate start,
            LocalDate end,
            String instagram
    ) {}

    @Builder
    public record ClubDateDTO(
            LocalDate firstStart,
            LocalDate firstEnd,
            LocalDate secondStart,
            LocalDate secondEnd
    ) {}
}

//"result":
//        {
//        "club_id": 1,
//        "name": "가온누리",
//        “category”: “STUDY”,
//        "description": "한줄소개",
//        “target”: ”모집대상”,
//        “start”: 모집시작일,
//        “end”: 모집 마감일,
//        “instagram”: “인스타그램 아이디”
//        }
