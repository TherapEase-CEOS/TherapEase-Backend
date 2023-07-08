package CEOS.TherapEase.project.accounts.repository;
import CEOS.TherapEase.project.accounts.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    //Boolean existsByEmail(String email);
    //Optional<Account> findByEmail(String email); // 이메일로 계정 조회
    Account findByCode(String code); // 코드로 조회
}
