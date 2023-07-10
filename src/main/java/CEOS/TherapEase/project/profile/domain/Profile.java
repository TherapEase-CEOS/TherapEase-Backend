package CEOS.TherapEase.project.profile.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counselorId", updatable = false)
    private Long counselorId;

    @Column(nullable = false, length = 60)
    private String email;

    private String introduction;

    private String engagement;

    @Builder
    public Profile(String email, String engagement, String introduction) {
        this.email = email;
        this.engagement = engagement;
        this.introduction = introduction;
    }

    //닉네임 수정하기
    public void updateAccount(String introduction, String email) {
        this.introduction = introduction;
        this.email = email;
        this.engagement = engagement;
    }


}
