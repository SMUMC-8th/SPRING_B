package umc.teamB.SMUClub.domain.notice.service.query;

import umc.teamB.SMUClub.domain.notice.dto.NoticeResponseDTO;
import umc.teamB.SMUClub.domain.notice.entity.Notice;

import java.util.List;

public interface NoticeQueryService {
    List<NoticeResponseDTO.NoticePreviewListDTO> getNotices();
    Notice getNotice(Long id);
}
