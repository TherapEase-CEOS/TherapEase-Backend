package CEOS.TherapEase.project.profile.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileModifyRequestDto {
    private String introduction;

    @NotBlank(message = "email은 필수로 입력해야 합니다.")
    private String email;

    private String engagement;

    @Builder
    public ProfileModifyRequestDto(String introduction, String email, String engagement) {
        this.email = email;
        this.introduction = introduction;
        this.engagement = engagement;
    }
}
