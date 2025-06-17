package umc.teamB.SMUClub.domain.faq.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.teamB.SMUClub.domain.faq.dto.response.FaqResponseDTO;
import umc.teamB.SMUClub.domain.faq.service.query.FaqQueryService;
import umc.teamB.SMUClub.global.apiPayload.CustomResponse;

import static umc.teamB.SMUClub.global.apiPayload.code.GeneralSuccessCode.OK;

@RestController
@RequiredArgsConstructor
public class FaqController {
    private final FaqQueryService faqQueryService;

    @Operation(
            summary = "FAQ 리스트 조회 API -by 양효인"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "성공적으로 처리")
    })
    @GetMapping("/faqs")
    public CustomResponse<FaqResponseDTO.FaqPreviewListDTO> getFaqs() {
        FaqResponseDTO.FaqPreviewListDTO faqDTOs = faqQueryService.getFaqs();
        return CustomResponse.onSuccess(OK, faqDTOs);
    }

}
