package umc.teamB.SMUClub.domain.faq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import umc.teamB.SMUClub.domain.faq.entity.Faq;

public interface FaqRepository extends JpaRepository<Faq, Integer> {

}
