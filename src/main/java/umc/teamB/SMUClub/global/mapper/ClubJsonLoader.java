package umc.teamB.SMUClub.global.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.teamB.SMUClub.domain.club.dto.request.ClubReqDTO;
import umc.teamB.SMUClub.domain.club.service.command.ClubCommandService;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ClubJsonLoader {

    private final ObjectMapper objectMapper;
    private final ClubCommandService clubCommandService;

    @PostConstruct // 한 번 실행 후 주석처리 할 것
    public void loadClubsFromJson() throws IOException {
        File file = new File("src/main/resources/club_request_dto_list.json");
        List<ClubReqDTO.ClubRequestDTO> clubDTOs = Arrays.asList(
                objectMapper.readValue(file, ClubReqDTO.ClubRequestDTO[].class)
        );

        for (ClubReqDTO.ClubRequestDTO dto : clubDTOs) {
            clubCommandService.createClub(dto);
        }
    }
}
