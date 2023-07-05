package CEOS.TherapEase.project.emotions.repository;

import CEOS.TherapEase.project.emotions.domain.Emotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmotionRepostiory extends JpaRepository<Emotion,Long> {
    Optional<Emotion> findByEmotionId(Long emotionId);
}
