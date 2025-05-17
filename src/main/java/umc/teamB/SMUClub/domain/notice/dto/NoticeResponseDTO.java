package umc.teamB.SMUClub.domain.notice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import umc.teamB.SMUClub.domain.notice.entity.Notice;

public class NoticeResponseDTO {
    @Getter
    @Builder
    public static class NoticePreviewListDTO{
        private Long id;
        private String title;
        public static NoticePreviewListDTO from(Notice notice) {
            return NoticePreviewListDTO.builder()
                    .id(notice.getId())
                    .title(notice.getTitle())
                    .build();
        }
    }

    @Getter
    @Builder
    public static class NoticePreviewDTO{
        private Long id;
        private String title;
        private String content;
        public static NoticePreviewDTO from(Notice notice) {
            return NoticePreviewDTO.builder()
                    .id(notice.getId())
                    .title(notice.getTitle())
                    .content(notice.getContent())
                    .build();
        }

    }
}
