package umc.teamB.SMUClub.domain.faq.converter;

import umc.teamB.SMUClub.domain.faq.dto.response.FaqResponseDTO;
import umc.teamB.SMUClub.domain.faq.entity.Faq;

public class FaqConverter {
    public static FaqResponseDTO.FaqPreviewDTO from(Faq faq) {
        return new FaqResponseDTO.FaqPreviewDTO(
                faq.getId(),
                faq.getQuestion(),
                faq.getAnswer()
        );
    }
}
