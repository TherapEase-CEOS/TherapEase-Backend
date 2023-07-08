package CEOS.TherapEase.project.emotions.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;
@Getter
@NoArgsConstructor
public class EmotionDto {
    private String mainEmotion;
    private String detailEmotion;
    private String feeling;
}
