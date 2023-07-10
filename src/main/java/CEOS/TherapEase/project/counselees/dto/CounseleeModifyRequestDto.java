package CEOS.TherapEase.project.counselees.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
public class CounseleeModifyRequestDto {
    private String counseleeeName;
    private String start;
    private Integer progress;
    private String goal;
    private String counselingDate;

    @Builder
    public CounseleeModifyRequestDto (String counseleeeName, String start, Integer progress, String goal, String counselingDate){
        this.counseleeeName = counseleeeName;
        this.start = start;
        this.progress = progress;
        this.goal = goal;
        this.counselingDate =counselingDate;
    }

}