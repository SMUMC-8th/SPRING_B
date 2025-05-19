package umc.teamB.SMUClub.domain.club.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.teamB.SMUClub.domain.club.enums.ActivityStyle;
import umc.teamB.SMUClub.domain.club.enums.Category;
import umc.teamB.SMUClub.domain.club.enums.ClubPurpose;
import umc.teamB.SMUClub.domain.club.enums.RecruitmentType;
import umc.teamB.SMUClub.domain.clubimage.entity.ClubImage;
import umc.teamB.SMUClub.domain.mapping.ClubHashtag;
import umc.teamB.SMUClub.global.entity.BaseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "club")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Club extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String instagram;
    // private String imageUrl;

    private String activity; // 주요 활동
    private String recruitmentDate; // 모집 기간 - 개별 조회시 사용
    private String target; // 모집 대상
    private String recruitmentMethod; // 모집 방법 - 구글 폼 들어갈 듯

    // 모집 시작, 마감일
    private LocalDate firstStart;
    private LocalDate firstEnd;

    private LocalDate secondStart;
    private LocalDate secondEnd;

    // EnumType은 무조건 STRING 사용할 것
    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private ClubPurpose purpose;

    @Enumerated(EnumType.STRING)
    private ActivityStyle activityStyle;

    @Enumerated(EnumType.STRING)
    private RecruitmentType recruitmentType;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClubImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClubHashtag> clubHashtagList = new ArrayList<>();
}
