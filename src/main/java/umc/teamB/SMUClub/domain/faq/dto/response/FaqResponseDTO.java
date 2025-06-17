package umc.teamB.SMUClub.domain.faq.dto.response;

import lombok.*;

import java.util.List;

public class FaqResponseDTO {

    @Builder
    public record FaqPreviewDTO(
        Long faq_id,
        String question,
        String content
    ){}

    public record FaqPreviewListDTO(
        List<FaqResponseDTO.FaqPreviewDTO> faqList){}

}
