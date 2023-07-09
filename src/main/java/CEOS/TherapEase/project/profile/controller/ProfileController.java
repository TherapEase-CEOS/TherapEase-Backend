package CEOS.TherapEase.project.profile.controller;


import CEOS.TherapEase.project.profile.domain.Profile;
import CEOS.TherapEase.project.profile.dto.ProfileModifyRequestDto;
import CEOS.TherapEase.project.profile.dto.ProfileRequestDto;
import CEOS.TherapEase.project.profile.dto.ProfileResponseDto;
import CEOS.TherapEase.project.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    // 계정 조회 기능 (1명)
    @GetMapping("/profile/{counselorId}")
    @ResponseStatus(value = HttpStatus.OK)
    public ProfileResponseDto getAccount(@PathVariable Long counselorId) {
        Profile findProfile = profileService.findProfileById(counselorId);
        return ProfileResponseDto.from(findProfile);
    }

    //계정 프로필 수정
    @PatchMapping("/profile/{counselorId}")
    @ResponseStatus(value = HttpStatus.OK)
    public ProfileResponseDto update(@PathVariable final Long counselorId, @RequestBody @Valid final ProfileModifyRequestDto requestDto) {
        Long id = profileService.update(counselorId, requestDto);
        Profile findAccount = profileService.findProfileById(id);
        return ProfileResponseDto.from(findAccount);
    }
}