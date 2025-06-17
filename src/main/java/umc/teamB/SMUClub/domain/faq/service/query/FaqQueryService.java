package umc.teamB.SMUClub.domain.faq.service.query;

import umc.teamB.SMUClub.domain.faq.dto.response.FaqResponseDTO;

public interface FaqQueryService {
    FaqResponseDTO.FaqPreviewListDTO  getFaqs();
}
