package umc.teamB.SMUClub.domain.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.teamB.SMUClub.domain.club.entity.Club;

public interface ClubRepository extends JpaRepository<Club, Integer> {
}
