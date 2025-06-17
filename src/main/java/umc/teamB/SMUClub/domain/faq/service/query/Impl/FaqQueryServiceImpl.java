package umc.teamB.SMUClub.domain.faq.service.query.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.teamB.SMUClub.domain.faq.converter.FaqConverter;
import umc.teamB.SMUClub.domain.faq.dto.response.FaqResponseDTO;
import umc.teamB.SMUClub.domain.faq.entity.Faq;
import umc.teamB.SMUClub.domain.faq.repository.FaqRepository;
import umc.teamB.SMUClub.domain.faq.service.query.FaqQueryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FaqQueryServiceImpl implements FaqQueryService {
    private final FaqRepository faqRepository;

    @Override
    public FaqResponseDTO.FaqPreviewListDTO getFaqs(){
        List<Faq> faqs =  faqRepository.findAll();
        List<FaqResponseDTO.FaqPreviewDTO> faqPreviewDTOList  = faqs.stream()
                .map(FaqConverter::from)
                .collect(Collectors.toList());
        return new FaqResponseDTO.FaqPreviewListDTO(faqPreviewDTOList);
    }
}
