package CEOS.TherapEase.project.counselees.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
public class CounseleeModifyRequestDto {
    private Long counselorId; // 맞나
    private String start;
    private Integer progress;
    private String goal;
    private String counselingDate;

}
