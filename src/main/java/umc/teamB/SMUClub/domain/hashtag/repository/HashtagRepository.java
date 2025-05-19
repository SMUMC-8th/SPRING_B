package umc.teamB.SMUClub.domain.hashtag.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import umc.teamB.SMUClub.domain.hashtag.entity.Hashtag;

import java.util.Optional;

public interface HashtagRepository extends PagingAndSortingRepository<Hashtag, Long> {
    Optional<Hashtag> findByName(String name);
    Hashtag save(Hashtag entity);
}
