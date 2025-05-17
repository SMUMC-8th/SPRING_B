package umc.teamB.SMUClub.domain.faq.dto;

import lombok.*;
import umc.teamB.SMUClub.domain.faq.entity.Faq;

import java.util.List;
import java.util.stream.Collectors;

public class FaqResponseDTO {

    @Getter
    @Builder
    public static class GetFaqDTO{
        private Long faq_id;
        private String question;
        private String content;

        public static FaqResponseDTO.GetFaqDTO from(Faq faq) {
            return FaqResponseDTO.GetFaqDTO.builder()
                    .faq_id(faq.getId())
                    .question(faq.getQuestion())
                    .content(faq.getAnswer())
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class FaqListDTO{
        private List<FaqResponseDTO.GetFaqDTO> faqList;

        public static FaqListDTO from(List<Faq> faqs) {
            List<FaqResponseDTO.GetFaqDTO> faqDTOs = faqs.stream()
                    .map(FaqResponseDTO.GetFaqDTO::from)
                    .collect(Collectors.toList());
            return FaqListDTO.builder()
                    .faqList(faqDTOs)
                    .build();
        }
    }



}
