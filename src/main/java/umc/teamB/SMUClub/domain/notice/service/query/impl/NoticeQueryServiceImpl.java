package umc.teamB.SMUClub.domain.notice.service.query.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.teamB.SMUClub.domain.notice.dto.NoticeResponseDTO;
import umc.teamB.SMUClub.domain.notice.entity.Notice;
import umc.teamB.SMUClub.domain.notice.repository.NoticeRepository;
import umc.teamB.SMUClub.domain.notice.service.query.NoticeQueryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeQueryServiceImpl implements NoticeQueryService {
    private final NoticeRepository noticeRepository;

    @Override
    public List<NoticeResponseDTO.NoticePreviewListDTO> getNotices(){
        List<Notice> notices = noticeRepository.findAll();
        List<NoticeResponseDTO.NoticePreviewListDTO> noticeDTO = notices.stream()
                .map(NoticeResponseDTO.NoticePreviewListDTO::from)
                .collect(Collectors.toList());
        return noticeDTO;
    }

    @Override
    public Notice getNotice(Long id){
        Optional<Notice> notice = noticeRepository.findById(id);
        return notice.orElse(null);
    }
}
