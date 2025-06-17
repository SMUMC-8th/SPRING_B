package umc.teamB.SMUClub.domain.notice.converter;

import org.springframework.stereotype.Component;
import umc.teamB.SMUClub.domain.notice.dto.response.NoticeResponseDTO;
import umc.teamB.SMUClub.domain.notice.entity.Notice;

import java.util.List;

@Component
public class NoticeConverter {
    public static NoticeResponseDTO.NoticePreviewDTO from(Notice notice){
        return new NoticeResponseDTO.NoticePreviewDTO(
                notice.getId(),
                notice.getTitle(),
                notice.getContent()
        );
    }


    public static NoticeResponseDTO.NoticePreviewListDTO from(List<Notice> notices) {
        List<NoticeResponseDTO.NoticePreviewDTO> previewList = notices.stream()
                .map(notice -> new NoticeResponseDTO.NoticePreviewDTO(
                        notice.getId(),
                        notice.getTitle(),
                        notice.getContent()
                ))
                .toList();

        return NoticeResponseDTO.NoticePreviewListDTO.builder()
                .notices(previewList)
                .build();
    }

}
