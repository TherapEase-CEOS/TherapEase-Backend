package CEOS.TherapEase.project.emotions.domain;

import CEOS.TherapEase.project.global.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.*;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Emotion extends BaseTimeEntity {
    //키값
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emotionId", updatable = false)
    private Long emotionId;

    //첫 번째 감정
    @Column
    private Integer mainEmotion;

    //두 번째 감정
    @Column
    private Integer detailEmotion;

    //세 번째 감정
    @Column
    private Integer feeling;

    //세 번째 감정의 강도
    @Column
    private Integer intensity;

    //부연 설명1
    @Column(columnDefinition = "TEXT")
    private String detail1;

    //부연 설명2
    @Column(columnDefinition = "TEXT")
    private String detail2;

    //부연 설명3
    @Column(columnDefinition = "TEXT")
    private String detail3;

    @Builder
    public Emotion(Integer mainEmotion,Integer detailEmotion, Integer feeling,
                   String detail1, String detail2, String detail3){
        this.mainEmotion = mainEmotion;
        this.detailEmotion = detailEmotion;
        this.feeling = feeling;
        this.detail1 = detail1;
        this.detail2 = detail2;
        this.detail3 = detail3;
    }


}
