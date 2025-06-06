package umc.teamB.SMUClub.domain.club.service.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.teamB.SMUClub.domain.club.converter.ClubConverter;
import umc.teamB.SMUClub.domain.club.converter.MatchConverter;
import umc.teamB.SMUClub.domain.club.dto.response.ClubResDTO;
import umc.teamB.SMUClub.domain.club.dto.request.MatchReqDTO;
import umc.teamB.SMUClub.domain.club.dto.response.MatchResDTO;
import umc.teamB.SMUClub.domain.club.entity.Club;
import umc.teamB.SMUClub.domain.club.enums.ActivityStyle;
import umc.teamB.SMUClub.domain.club.enums.Category;
import umc.teamB.SMUClub.domain.club.enums.RecruitmentType;
import umc.teamB.SMUClub.domain.club.exception.ClubErrorCode;
import umc.teamB.SMUClub.domain.club.exception.ClubException;
import umc.teamB.SMUClub.domain.club.repository.ClubRepository;

import java.util.*;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClubQueryServiceImpl implements ClubQueryService {

    private final ClubRepository clubRepository;

    @Override
    public MatchResDTO.MatchResponseListDTO getMatchClubs(MatchReqDTO.MatchRequestDTO request) {
        List<MatchResDTO.MatchResponseDTO> result = clubRepository.findAll().stream()
                .map(club -> new AbstractMap.SimpleEntry<>(club, calculateMatchScore(request, club)))
                .filter(entry -> entry.getValue() >= 3)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(entry -> MatchConverter.from(entry.getKey(), entry.getValue()))
                .toList();

        return new MatchResDTO.MatchResponseListDTO(result);
    }

    @Override
    public List<ClubResDTO.ClubResponseDTO> searchClubs(String keyword) {
        List<Club> clubs = clubRepository.searchAllFields(keyword);
        if (clubs.isEmpty()) {
            throw new ClubException(ClubErrorCode.NOT_FOUND_404);
        }

        return ClubConverter.toClubResponseDtoList(clubs);
    }

    @Override
    public List<ClubResDTO.ClubResponseDTO> getClubsByCategory(Category category) {
        List<Club> clubs = clubRepository.findByCategory(category);
        if (clubs.isEmpty()) {
            throw new ClubException(ClubErrorCode.NOT_FOUND_404);
        }
        
        return ClubConverter.toClubResponseDtoList(clubs);
    }

    @Override
    public ClubResDTO.ClubDetailResponseDTO getClubById(Long id) {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new ClubException(ClubErrorCode.NOT_FOUND_404));
        return ClubConverter.toClubDetailResponseDto(club);
    }

    private int calculateMatchScore(MatchReqDTO.MatchRequestDTO request, Club club) {
        int score = 0;

        // 1. 선호 방향 (가장 중요하므로 2점)
        if (club.getPurpose() == request.purpose()) {
            score += 2;
        }
        // 2. 활동 유형 (상관없음 or 정확히 일치 시 1점)
        if (request.activityStyle() == ActivityStyle.ANY ||
                club.getActivityStyle() == request.activityStyle()) {
            score += 1;
        }
        // 3. 모집 방식 (상관없음 or 정확히 일치 시 1점)
        if (request.recruitmentType() == RecruitmentType.ANY ||
                club.getRecruitmentType() == request.recruitmentType()) {
            score += 1;
        }
        // (성장 & 진로)의 경우 최소 점수가 2점이 가능하므로 보정
        if (score == 2) {
            score += 1;
        }

        return score;
    }

    @Override
    public ClubResDTO.ClubDateDTO getDates(Long id) {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new ClubException(ClubErrorCode.NOT_FOUND_404));

        return ClubConverter.toClubDateDto(club);

    }

    @Override
    public List<ClubResDTO.ClubResponseDTO> getRandomClubs() {
        List<Club> clubs = new ArrayList<>();

        for (Category category : Category.values()) {
            Club club = clubRepository.findRandomClubs(category.name());
            if (club != null) {
                clubs.add(club);
            }
        }

        if (clubs.isEmpty()) {
            throw new ClubException(ClubErrorCode.NOT_FOUND_404);
        }

        return ClubConverter.toClubResponseDtoList(clubs);
    }
}
