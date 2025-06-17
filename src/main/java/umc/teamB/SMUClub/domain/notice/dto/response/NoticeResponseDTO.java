package umc.teamB.SMUClub.domain.notice.dto.response;

import lombok.Builder;
import lombok.Getter;
import umc.teamB.SMUClub.domain.notice.entity.Notice;

import java.util.List;

public class NoticeResponseDTO {

    @Builder
    public record NoticePreviewListDTO(
            List<NoticePreviewDTO> notices){}


    @Builder
    public record NoticePreviewDTO(
        Long id,
        String title,
        String content){}

}
