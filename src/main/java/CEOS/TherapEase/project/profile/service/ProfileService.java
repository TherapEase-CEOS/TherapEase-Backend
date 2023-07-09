package CEOS.TherapEase.project.profile.service;

import CEOS.TherapEase.project.profile.domain.Profile;
import CEOS.TherapEase.project.profile.dto.ProfileModifyRequestDto;
import CEOS.TherapEase.project.profile.dto.ProfileRequestDto;
import CEOS.TherapEase.project.profile.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return profileRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    public Profile findProfileById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 id를 가진 Profile를 찾을 수 없습니다.id="+id));
    }

    public Long update(Long counselorId, ProfileModifyRequestDto requestDto) {
        Profile profile = findProfileById(counselorId);
        profile.updateAccount(requestDto.getIntroduction(), requestDto.getEmail());
        return profile.getCounselorId();
    }
}