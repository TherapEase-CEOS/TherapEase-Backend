package CEOS.TherapEase.project.profile.dto;

import CEOS.TherapEase.project.profile.domain.Profile;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileResponseDto{
    private Long counselorId;
    private String email;
    private String introduction;
    private String engagement;

    public ProfileResponseDto(Long counselorId, String email, String introduction, String engagement) {
        this.counselorId = counselorId;
        this.email = email;
        this.introduction = introduction;
        this.engagement = engagement;
    }
    public static ProfileResponseDto from(Profile profile) {
        return new ProfileResponseDto(profile.getCounselorId(),
                profile.getEmail(),
                profile.getIntroduction(),
                profile.getEngagement());
    }
}