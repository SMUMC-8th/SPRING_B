package umc.teamB.SMUClub.domain.notice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import umc.teamB.SMUClub.domain.notice.dto.NoticeResponseDTO;
import umc.teamB.SMUClub.domain.notice.entity.Notice;
import umc.teamB.SMUClub.domain.notice.service.query.NoticeQueryService;
import umc.teamB.SMUClub.global.apiPayload.CustomResponse;

import java.util.List;

import static umc.teamB.SMUClub.global.apiPayload.code.GeneralSuccessCode.OK;

@RestController
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeQueryService noticeQueryService;

    @GetMapping("/notices")
    public CustomResponse<List<NoticeResponseDTO.NoticePreviewListDTO>> getNotices() {
        List<NoticeResponseDTO.NoticePreviewListDTO> notices = noticeQueryService.getNotices();
        return CustomResponse.onSuccess(OK, notices);
    }

    @GetMapping("/notices/{noticeId}")
    public CustomResponse<NoticeResponseDTO.NoticePreviewDTO> getNotice(@PathVariable Long noticeId) {
        Notice notice = noticeQueryService.getNotice(noticeId);
        return CustomResponse.onSuccess(OK, NoticeResponseDTO.NoticePreviewDTO.from(notice));
    }

}
