package CEOS.TherapEase.project.emotions.service;

import CEOS.TherapEase.project.emotions.domain.Emotion;
import CEOS.TherapEase.project.emotions.dto.EmotionCreateRequestDto;
import CEOS.TherapEase.project.emotions.repository.EmotionRepostiory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmotionService {
    private final EmotionRepostiory emotionRepostiory;

    @Transactional
    public Emotion createEmotion(EmotionCreateRequestDto requestDto) {
        //Account  = accountRepository.findById(requestDto.getAccountId())
        //        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 계정입니다."));

        return emotionRepostiory.save(
                Emotion.builder()
                        .mainEmotion(requestDto.getMainEmotion())
                        .detailEmotion(requestDto.getDetailEmotion())
                        .feeling(requestDto.getFeeling())
                        .detail1(requestDto.getDetail1())
                        .detail2(requestDto.getDetail2())
                        .detail3(requestDto.getDetail3())

                        .build()
        );
    }

    //조회 어케 구현하지..


}