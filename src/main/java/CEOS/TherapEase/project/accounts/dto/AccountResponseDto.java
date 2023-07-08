package CEOS.TherapEase.project.accounts.dto;

import CEOS.TherapEase.project.accounts.domain.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountResponseDto {
    private Long accountId;
    private String email;
    private String code;
    private String bio;

    public AccountResponseDto(Long accountId, String email, String code, String bio) {
        this.accountId = accountId;
        this.email = email;
        this.code = code;
        this.bio = bio;
    }
    public static AccountResponseDto from(Account account) {
        return new AccountResponseDto(account.getAccountId(),
                account.getCode(),
                account.getEmail(),
                account.getBio());
    }
}
