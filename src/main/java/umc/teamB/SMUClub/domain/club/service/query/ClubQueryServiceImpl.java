package umc.teamB.SMUClub.domain.club.service.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.teamB.SMUClub.domain.club.converter.ClubConverter;
import umc.teamB.SMUClub.domain.club.dto.ClubResDTO;
import umc.teamB.SMUClub.domain.club.entity.Club;
import umc.teamB.SMUClub.domain.club.exception.ClubErrorCode;
import umc.teamB.SMUClub.domain.club.exception.ClubException;
import umc.teamB.SMUClub.domain.club.repository.ClubRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClubQueryServiceImpl implements ClubQueryService {

    private final ClubRepository clubRepository;

    @Override
    public List<ClubResDTO.ClubResponseDTO> searchClubs(String keyword) {
        List<Club> clubs = clubRepository.searchAllFields(keyword);
        if (clubs.isEmpty()) {
            throw new ClubException(ClubErrorCode.NOT_FOUND_404);
        }

        return ClubConverter.toDtoList(clubs);
    }
}