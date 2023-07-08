package CEOS.TherapEase.project.emotions.dto;

import CEOS.TherapEase.project.emotions.domain.Emotion;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class EmotionResponseDto {
    private Long emotionId;
    private Integer mainEmotion;
    private Integer detailEmotion;
    private Integer feeling;
    private String detail1;
    private String detail2;
    private String detail3;
    private LocalDateTime createdTime;


    public EmotionResponseDto(Emotion emotion){
        this.emotionId = emotion.getEmotionId();
        this.mainEmotion = emotion.getMainEmotion();
        this.detailEmotion = emotion.getDetailEmotion();
        this.feeling = emotion.getFeeling();
        this.detail1 = emotion.getDetail1();
        this.detail2 = emotion.getDetail2();
        this.detail3 = emotion.getDetail3();
        this.createdTime = emotion.getCreatedDate();
    }
}
