package CEOS.TherapEase.project.counselees.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CounseleeCreateRequestDto {

    private Long counseleeId;
    // 내담자 이름 추가해야하나?
    @NotBlank(message = "내담자 이름은 필수로 입력해야 합니다.")
    private String counseleeName;

    @NotBlank(message="상담 시작 날짜는 필수로 입력해야 합니다.")
    private String start;

    @NotBlank(message = "진행 상태는 필수로 입력해야 합니다. ")
    private Integer progress;

    @NotBlank(message = "상담일정은 필수로 입력해야 합니다. (ex. 매주 화요일 7시)")
    private String counselingDate;

    @NotNull(message = "상담 목표를 입력해주세요!")
    private String goal;

    @Builder
    public CounseleeCreateRequestDto (Long counseleeId,String counseleeName, String start, Integer progress, String counselingDate, String goal)
    {
        this.counseleeId = counseleeId;
        this.counseleeName = counseleeName;
        this.start = start;
        this.progress = progress;
        this.counselingDate = counselingDate;
        this.goal = goal;
    }


}