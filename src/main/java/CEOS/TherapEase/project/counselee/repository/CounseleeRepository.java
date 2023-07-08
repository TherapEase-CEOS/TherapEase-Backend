package CEOS.TherapEase.project.counselees.repository;

import CEOS.TherapEase.project.counselees.domain.Counselee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CounseleeRepository extends JpaRepository<Counselee,Long>{

    Optional<Counselee> findByCounseleeId(Long counseleeId); // counseleeId를 기준으로 내담자 조회
}
