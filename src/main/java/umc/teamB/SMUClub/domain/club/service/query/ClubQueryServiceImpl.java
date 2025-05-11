package umc.teamB.SMUClub.domain.club.service.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.teamB.SMUClub.domain.club.dto.ClubResponseDTO;
import umc.teamB.SMUClub.domain.club.entity.Club;
import umc.teamB.SMUClub.domain.club.repository.ClubRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClubQueryServiceImpl implements ClubQueryService {

    private final ClubRepository clubRepository;

    @Override
    public List<ClubResponseDTO> searchClubs(String keyword) {
        List<Club> clubs = clubRepository.searchAllFields(keyword);
        return clubs.stream()
                .map(ClubResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }
}