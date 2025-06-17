package umc.teamB.SMUClub.domain.notice.service.query.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.teamB.SMUClub.domain.notice.converter.NoticeConverter;
import umc.teamB.SMUClub.domain.notice.dto.response.NoticeResponseDTO;
import umc.teamB.SMUClub.domain.notice.entity.Notice;
import umc.teamB.SMUClub.domain.notice.exception.NoticeErrorCode;
import umc.teamB.SMUClub.domain.notice.exception.NoticeException;
import umc.teamB.SMUClub.domain.notice.repository.NoticeRepository;
import umc.teamB.SMUClub.domain.notice.service.query.NoticeQueryService;
import umc.teamB.SMUClub.global.apiPayload.code.GeneralErrorCode;
import umc.teamB.SMUClub.global.apiPayload.exception.CustomException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoticeQueryServiceImpl implements NoticeQueryService {
    private final NoticeRepository noticeRepository;


    @Override
    public NoticeResponseDTO.NoticePreviewListDTO getNotices(){
        List<Notice> notices = noticeRepository.findAll();
        return NoticeConverter.from(notices);
    }

    @Override
    public NoticeResponseDTO.NoticePreviewDTO getNotice(Long id){
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(()-> new NoticeException(NoticeErrorCode.NOT_FOUND_404));

        return NoticeConverter.from(notice);
    }
}
