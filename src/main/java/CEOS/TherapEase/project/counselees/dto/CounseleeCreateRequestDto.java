package CEOS.TherapEase.project.counselees.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CounseleeCreateRequestDto {

    // 내담자 이름 추가해야하나?

    @NotBlank(message="상담 시작 날짜는 필수로 입력해야 합니다.")
    private String start;

    @NotBlank(message = "진행 상태는 필수로 입력해야 합니다. ")
    private Integer progress;


}
