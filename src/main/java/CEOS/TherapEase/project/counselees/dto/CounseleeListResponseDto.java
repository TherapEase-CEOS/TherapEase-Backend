package CEOS.TherapEase.project.counselees.dto;

import CEOS.TherapEase.project.counselees.domain.Counselee;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CounseleeListResponseDto {
    private List<CounseleeResponseDto> Counselees;
    private Integer count;

    public static CounseleeListResponseDto of(List<Counselee> counseleeList) {
        return CounseleeListResponseDto.builder()
                .Counselees(counseleeList.stream().map(CounseleeResponseDto::from).collect(Collectors.toList())) //counselees-> Counselees 로 했는데 문제있나
                .count(counseleeList.size())
                .build();
    }
}
