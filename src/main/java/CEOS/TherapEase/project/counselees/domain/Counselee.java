package CEOS.TherapEase.project.counselees.domain;

import CEOS.TherapEase.project.accounts.domain.Account;
import CEOS.TherapEase.project.global.entity.BaseTimeEntity;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Counselee extends BaseTimeEntity {
    //키값
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counseleeId", updatable = false)
    private Long counseleeId;

    // 내담자 이름 따로 입력해야하나? 회원가입-로그인 로직대로 되면?

    // 상담 시작 날짜
    @Column
    private String start; // yyyy-mm-dd 형식으로 적으시오.

    // 진행 상황
    @Column
    private Integer progress; // 진행 = 1, 그 외에는 0

    //상담 목표
    @Column
    private String goal;

    //상담 일정 ex. 매주 화요일 7시
    @Column
    private String counselingDate;


    // 내담자를 맡은 상담사
    @OneToMany
    @JoinColumn(name="counselorId")
    private Account counselor;

    @Builder
    public Counselee (String start,String progress,String goal, String counselingDate){
        this.start = start;
        this.progress = Integer.valueOf(progress);
        this.goal = goal;
        this.counselingDate = counselingDate;
        //this.counselor = counselor;
    }

}
