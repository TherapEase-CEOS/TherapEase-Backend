package CEOS.TherapEase.project.accounts.repository;

import CEOS.TherapEase.project.accounts.model.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
    Consultant findByUsername(String username);
}
