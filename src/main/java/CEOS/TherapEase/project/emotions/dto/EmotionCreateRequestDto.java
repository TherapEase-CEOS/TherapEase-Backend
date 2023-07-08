package CEOS.TherapEase.project.emotions.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

// 새 감정 생성 요청을 보낼 때 사용되는 DTO
@Getter
@NoArgsConstructor
public class EmotionCreateRequestDto {
    @NotBlank(message = "감정은 필수입니다.")
    private List<EmotionDto> emotion;

    @NotBlank(message = "감정 강도 선택은 필수입니다.")
    private Integer intensity;

    private Optional<String> detail1 = Optional.empty();
    private Optional<String> detail2 = Optional.empty();
    private Optional<String> detail3 = Optional.empty();

}