package umc.teamB.SMUClub.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.teamB.SMUClub.domain.club.entity.Club;
import umc.teamB.SMUClub.domain.hashtag.entity.Hashtag;
import umc.teamB.SMUClub.global.entity.BaseEntity;

@Entity
@Table(name = "club_hashtag")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class ClubHashtag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hashtag_id", nullable = false)
    private Hashtag hashtag;
}
