package umc.teamB.SMUClub.domain.notice.service.query;

import umc.teamB.SMUClub.domain.notice.dto.response.NoticeResponseDTO;
import umc.teamB.SMUClub.domain.notice.entity.Notice;

import java.util.List;

public interface NoticeQueryService {
    NoticeResponseDTO.NoticePreviewListDTO getNotices();
    NoticeResponseDTO.NoticePreviewDTO getNotice(Long id);
}
