package CEOS.TherapEase.project.counselees.dto;

import CEOS.TherapEase.project.accounts.domain.Account;
import lombok.Getter;

@Getter
public class CounseleeRequestDto {
    private Long counseleeId;
    private String counseleeName;
    private String start;
    private String goal;
    private String counselingDate;
    private Account counselor;
}
