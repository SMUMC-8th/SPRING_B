package umc.teamB.SMUClub.domain.faq.service.query.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.teamB.SMUClub.domain.faq.dto.FaqResponseDTO;
import umc.teamB.SMUClub.domain.faq.entity.Faq;
import umc.teamB.SMUClub.domain.faq.repository.FaqRepository;
import umc.teamB.SMUClub.domain.faq.service.query.FaqQueryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FaqQueryServiceImpl implements FaqQueryService {
    private final FaqRepository faqRepository;

    @Override
    public List<FaqResponseDTO.GetFaqDTO> getFaqs(){
        List<Faq> faqs =  faqRepository.findAll();
        List<FaqResponseDTO.GetFaqDTO> faqDTOs = faqs.stream()
                .map(FaqResponseDTO.GetFaqDTO::from)
                .collect(Collectors.toList());
        return faqDTOs;

    }
}
