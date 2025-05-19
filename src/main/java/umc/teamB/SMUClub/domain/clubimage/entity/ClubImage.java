package umc.teamB.SMUClub.domain.clubimage.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.teamB.SMUClub.domain.club.entity.Club;

@Entity
@Table(name = "club_image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class ClubImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private boolean isThumbnail; // 대표 이미지 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;
}

