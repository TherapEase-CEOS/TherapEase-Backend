package CEOS.TherapEase.project.profile.repository;

import CEOS.TherapEase.project.profile.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Boolean existsByEmail(String email);
    Optional<Profile> findProfileById(String email); // id로 계정 조회
}