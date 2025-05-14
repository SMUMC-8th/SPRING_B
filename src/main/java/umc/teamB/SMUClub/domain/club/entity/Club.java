package umc.teamB.SMUClub.domain.club.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.teamB.SMUClub.domain.club.enums.ActivityStyle;
import umc.teamB.SMUClub.domain.club.enums.Category;
import umc.teamB.SMUClub.domain.club.enums.ClubPurpose;
import umc.teamB.SMUClub.domain.club.enums.RecruitmentType;
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
    private String imageUrl;
    private String target;

    // 모집 시작, 마감일
    private LocalDate start;
    private LocalDate end;

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
    private List<ClubHashtag> clubHashtagList = new ArrayList<>();
}
