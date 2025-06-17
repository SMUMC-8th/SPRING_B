package umc.teamB.SMUClub.domain.notice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import umc.teamB.SMUClub.domain.notice.converter.NoticeConverter;
import umc.teamB.SMUClub.domain.notice.dto.response.NoticeResponseDTO;
import umc.teamB.SMUClub.domain.notice.entity.Notice;
import umc.teamB.SMUClub.domain.notice.service.query.NoticeQueryService;
import umc.teamB.SMUClub.global.apiPayload.CustomResponse;

import java.util.List;

import static umc.teamB.SMUClub.global.apiPayload.code.GeneralSuccessCode.OK;

@RestController
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeQueryService noticeQueryService;


    @Operation(
            summary = "notice 리스트 조회 API -by 양효인"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "성공적으로 처리")
    })
    @GetMapping("/notices")
    public CustomResponse<NoticeResponseDTO.NoticePreviewListDTO> getNotices() {
        NoticeResponseDTO.NoticePreviewListDTO notices = noticeQueryService.getNotices();
        return CustomResponse.onSuccess(OK, notices);
    }


    @Operation(
            summary = "notice 개별 조회 API -by 양효인"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "성공적으로 처리")
    })
    @GetMapping("/notices/{noticeId}")
    public CustomResponse<NoticeResponseDTO.NoticePreviewDTO> getNotice(@PathVariable Long noticeId) {
        NoticeResponseDTO.NoticePreviewDTO notice = noticeQueryService.getNotice(noticeId);
       return CustomResponse.onSuccess(OK, notice);
    }

}
