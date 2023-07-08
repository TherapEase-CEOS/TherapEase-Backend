package CEOS.TherapEase.project.accounts.domain;

import CEOS.TherapEase.project.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static CEOS.TherapEase.project.accounts.domain.AccountStatus.REGISTERED;


@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId", updatable = false)
    private Long accountId;

    @Column(nullable = false, length = 60)
    private String email;

    @Column(nullable = false, length = 11)
    private String phone;

    @Column(nullable = false)
    private String code;

    private String role;

    private String name;

    private String bio;

    private AccountStatus status;

    @Builder
    public Account(String email, String code, String name, String bio, String phone, String role, Long accountId) {
        this.email = email;
        this.code = code;
        this.phone = phone;
        this.status = REGISTERED;
        this.name = name;
        this.role = role;
        this.accountId = accountId;
        this.bio = bio;
    }


}