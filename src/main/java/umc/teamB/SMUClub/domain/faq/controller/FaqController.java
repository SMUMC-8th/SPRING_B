package umc.teamB.SMUClub.domain.faq.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.teamB.SMUClub.domain.faq.dto.FaqResponseDTO;
import umc.teamB.SMUClub.domain.faq.entity.Faq;
import umc.teamB.SMUClub.domain.faq.service.query.FaqQueryService;
import umc.teamB.SMUClub.global.apiPayload.CustomResponse;

import java.util.List;

import static umc.teamB.SMUClub.global.apiPayload.code.GeneralSuccessCode.OK;

@RestController
@RequiredArgsConstructor
public class FaqController {
    private final FaqQueryService faqQueryService;

    @GetMapping("/faqs")
    public CustomResponse<List<FaqResponseDTO.GetFaqDTO>> getFaqs() {
        List<FaqResponseDTO.GetFaqDTO> faqDTOs = faqQueryService.getFaqs();
        return CustomResponse.onSuccess(OK, faqDTOs);
    }

}
