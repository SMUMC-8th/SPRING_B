package umc.teamB.SMUClub.domain.faq.service.query;

import umc.teamB.SMUClub.domain.faq.dto.FaqResponseDTO;
import umc.teamB.SMUClub.domain.faq.entity.Faq;

import java.util.List;

public interface FaqQueryService {
    List<FaqResponseDTO.GetFaqDTO>  getFaqs();
}
