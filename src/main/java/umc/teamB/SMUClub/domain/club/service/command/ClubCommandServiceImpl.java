package umc.teamB.SMUClub.domain.club.service.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.teamB.SMUClub.domain.club.dto.request.ClubReqDTO;
import umc.teamB.SMUClub.domain.club.entity.Club;
import umc.teamB.SMUClub.domain.club.repository.ClubRepository;
import umc.teamB.SMUClub.domain.clubimage.entity.ClubImage;
import umc.teamB.SMUClub.domain.hashtag.entity.Hashtag;
import umc.teamB.SMUClub.domain.hashtag.repository.HashtagRepository;
import umc.teamB.SMUClub.domain.mapping.ClubHashtag;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClubCommandServiceImpl implements ClubCommandService {

    private final ClubRepository clubRepository;
    private final HashtagRepository hashtagRepository;

    @Override
    public void createClub(ClubReqDTO.ClubRequestDTO dto) {
        Club club = Club.builder()
                .name(dto.name())
                .description(dto.description())
                .instagram(dto.instagram())
                .activity(dto.activity())
                .recruitmentDate(dto.recruitmentDate())
                .target(dto.target())
                .recruitmentMethod(dto.recruitmentMethod())
                .firstStart(dto.firstStart())
                .firstEnd(dto.firstEnd())
                .secondStart(dto.secondStart())
                .secondEnd(dto.secondEnd())
                .category(dto.category())
                .purpose(dto.purpose())
                .activityStyle(dto.activityStyle())
                .recruitmentType(dto.recruitmentType())
                .build();

        // image 링크들 처리 - converter 처리하면 더 깔끔할 듯
        List<ClubImage> images = dto.imageUrl().stream()
                .map(imageDTO -> ClubImage.builder()
                        .imageUrl(imageDTO.imageUrl())
                        .isThumbnail(imageDTO.isThumbnail())
                        .club(club)
                        .build())
                .toList();

        club.getImages().addAll(images);

        // 해시 태그 처리
        List<ClubHashtag> clubHashtagList = dto.hashtags().stream()
                .map(stringTAG -> {
                    Hashtag hashtag = hashtagRepository.findByName(stringTAG)
                            .orElseGet(() -> hashtagRepository.save(Hashtag.builder().name(stringTAG).build()));

                    return ClubHashtag.builder()
                            .club(club)
                            .hashtag(hashtag)
                            .build();
                }).toList();

        club.getClubHashtagList().addAll(clubHashtagList);

        clubRepository.save(club);
    }
}
