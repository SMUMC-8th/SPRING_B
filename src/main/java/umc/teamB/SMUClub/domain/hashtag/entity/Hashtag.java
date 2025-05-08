package umc.teamB.SMUClub.domain.hashtag.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.teamB.SMUClub.domain.mapping.ClubHashtag;
import umc.teamB.SMUClub.global.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hashtag")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Hashtag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 동일한 해시 태그가 중복 생성 되는 것 방지
    @Column(unique = true, nullable = false)
    private String name;

    // 해시태그는 공유 자원이기에 cascade, orphanRemoval 사용 X
    @OneToMany(mappedBy = "hashtag")
    private List<ClubHashtag> clubHashtagList = new ArrayList<>();
}
