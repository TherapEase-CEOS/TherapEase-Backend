package CEOS.TherapEase.project.emotions.controller;

import CEOS.TherapEase.project.emotions.dto.EmotionCreateRequestDto;
import CEOS.TherapEase.project.emotions.dto.EmotionResponseDto;
import CEOS.TherapEase.project.emotions.service.EmotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/emotions")
@RequiredArgsConstructor
public class EmotionController {
    private final EmotionService emotionService;

    //감정 생성 (POST)
    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public EmotionResponseDto createEmotion(@RequestBody @Valid final EmotionCreateRequestDto requestDto){
        return new EmotionResponseDto(emotionService.createEmotion(requestDto)); // 새로 만든 감정의 정보를 DTO 객체로 만들어 리턴
    }

}
