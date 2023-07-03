package CEOS.TherapEase.project.emotions.controller;

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
    public EmotionResponseDto createEmotion(@RequestBody @Valid final )

}
