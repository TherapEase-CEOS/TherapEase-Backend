package CEOS.TherapEase.project.counselees.dto;

import CEOS.TherapEase.project.accounts.domain.Account;
import CEOS.TherapEase.project.counselees.domain.Counselee;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CounseleeResponseDto {
    private Long counseleeId;
    private String counseleeName;
    private String start;
    private Integer progress;
    private String goal;
    private String counselingDate;
    private Account counselor;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public CounseleeResponseDto (Counselee counselee){
        this.counseleeId = counselee.getCounseleeId();
        this.counseleeName= counselee.getCounseleeName();
        this.start = counselee.getStart();
        this.progress = counselee.getProgress();
        this.goal = counselee.getGoal();
        this.counselingDate = counselee.getCounselingDate();
        this.counselor = counselee.getCounselor();
        this.createdDate = counselee.getCreatedDate();
        this.modifiedDate = counselee.getModifiedDate();
    }

    public static CounseleeResponseDto from (Counselee counselee){
        return new CounseleeResponseDto((counselee));
    }
}