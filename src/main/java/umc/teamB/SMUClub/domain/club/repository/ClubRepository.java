package umc.teamB.SMUClub.domain.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.teamB.SMUClub.domain.club.entity.Club;
import umc.teamB.SMUClub.domain.club.enums.Category;

import java.util.List;

public interface ClubRepository extends JpaRepository<Club, Long> {
    @Query("""
    SELECT DISTINCT c FROM Club c
    LEFT JOIN c.clubHashtagList ch
    LEFT JOIN ch.hashtag h
    WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
       OR LOWER(c.category) LIKE LOWER(CONCAT('%', :keyword, '%'))
       OR LOWER(h.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
    """)
    List<Club> searchAllFields(@Param("keyword") String keyword);

    // 카테고리별 리스트
    List<Club> findByCategory(Category category);

}
