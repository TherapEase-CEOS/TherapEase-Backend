package CEOS.TherapEase.project.counselees.repository;

import CEOS.TherapEase.project.accounts.domain.Account;
import CEOS.TherapEase.project.counselees.domain.Counselee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface CounseleeRepository extends JpaRepository<Counselee,Long>{

    Optional<Counselee> findByCounseleeId(Long counseleeId); // counseleeId를 기준으로 내담자 조회
    List<Counselee> findAllByCounselor(Account account);
}
