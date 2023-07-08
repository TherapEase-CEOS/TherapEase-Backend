package CEOS.TherapEase.project.counselees.service;

import CEOS.TherapEase.project.accounts.domain.Account;
import CEOS.TherapEase.project.accounts.repository.AccountRepository;
import CEOS.TherapEase.project.counselees.domain.Counselee;
import CEOS.TherapEase.project.counselees.dto.CounseleeCreateRequestDto;
import CEOS.TherapEase.project.counselees.dto.CounseleeModifyRequestDto;
import CEOS.TherapEase.project.counselees.repository.CounseleeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CounseleeService {
    private final CounseleeRepository counseleeRepository;
    private final AccountRepository accountRepository; // counselor 지칭

    // 내담자 생성
    public Counselee createCounselee(CounseleeCreateRequestDto requestDto) {
        // if(existsByTitle(requestDto.getTitle())) {
        //     throw new IllegalArgumentException("이미 존재하는 게시판명입니다. " + requestDto.getTitle());
        // }
        Account counselor = accountRepository.findById(requestDto.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상담사입니다."));

        return counseleeRepository.save(
                Counselee.builder()
                        //.counseleeId(requestDto.getCounseleeId())
                        .start(requestDto.getStart())
                        .progress(String.valueOf(requestDto.getProgress()))
                        .goal(requestDto.getGoal())
                        .counselingDate(requestDto.getCounselingDate())
                        .build()
        );
    }


    // 내담자 목록 조회
    public List<Counselee> findCounseleeList() {
        return counseleeRepository.findAll();
    }

    // 단일 엔티티의 존재 여부 확인하는 메서드
    // @Transactional(readOnly = true)
    // private boolean existsByCounseleeId(String title) {
    //     return counseleeRepository.existsByCounseleeId(title);
    // }

    // 내담자 상세 조회
    //@Transactional(readOnly = true)
    //public Counselee findCounseleeById(Long id) {
    //    return counseleeRepository.findById(id)
    //            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 내담자입니다."));
    //}

    // 내담자 수정
    public Long modify(Long counseleeId, CounseleeModifyRequestDto requestDto) {
        Counselee counselee = findCounseleeById(counseleeId);
        counselee.modifyCounselee(accountRepository.findById(requestDto.getOwnerId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다.")));
        return counseleeId;
    }

    //내담자 삭제
    @Transactional
    public void deleteBoard(Long counseleeId) {
        Counselee counselee = counseleeRepository.findByCounseleeId(counseleeId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 접근입니다."));
        counseleeRepository.delete(counselee);
    }
}
