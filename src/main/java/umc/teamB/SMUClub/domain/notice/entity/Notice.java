package umc.teamB.SMUClub.domain.notice.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.teamB.SMUClub.global.entity.BaseEntity;

@Entity
@Table(name = "notice")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Notice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // String → JPA에서 특별한 설정 없으면 DB에서 VARCHAR(255)로 매핑
    // DB에서는 TEXT 타입으로 매핑되어 약 65,535자까지 저장
    @Column(columnDefinition = "TEXT")
    private String content;

}
