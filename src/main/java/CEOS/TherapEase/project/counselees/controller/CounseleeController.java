package CEOS.TherapEase.project.counselees.controller;

import CEOS.TherapEase.project.counselees.domain.Counselee;
import CEOS.TherapEase.project.counselees.dto.CounseleeModifyRequestDto;
import CEOS.TherapEase.project.counselees.dto.CounseleeCreateRequestDto;
import CEOS.TherapEase.project.counselees.dto.CounseleeResponseDto;
import CEOS.TherapEase.project.counselees.service.CounseleeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/counselees")
@RequiredArgsConstructor
public class CounseleeController {
    private final CounseleeService counseleeService;

    //내담자 생성
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CounseleeResponseDto counseleeAdd(@RequestBody CounseleeCreateRequestDto requestDto) {   // request가 JSON으로 들어간다는 의미
        Counselee counselee = counseleeService.addCounselee(requestDto);
        return new CounseleeResponseDto(counselee);
    }

    //내담자 목록 조회
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<CounseleeResponseDto> postListFind() {
        List<Counselee> counseleeList = counseleeService.findCounseleeList();
        List<CounseleeResponseDto> responseDtoList = new ArrayList<>();

        for (Counselee counselee : counseleeList) {    // 스트림으로 한 줄 코드로 바꿀 수 있음
            responseDtoList.add(new CounseleeResponseDto(counselee));
        }
        return responseDtoList;
    }


    //내담자 상세 조회
    @GetMapping("/{counseleeId}")
    @ResponseStatus(value = HttpStatus.OK)
    public CounseleeResponseDto counseleeFind(@PathVariable Long counseleeId) {
        Counselee counselee = counseleeService.findCounselee(counseleeId);
        return new CounseleeResponseDto(counselee);
    }

    //내담자 삭제
    @DeleteMapping("/{counseleeId}")
    @ResponseStatus(value = HttpStatus.OK)
    public String counseleeRemove(@PathVariable Long counseleeId, @RequestParam Long counselorId) { //헷갈
        CounseleeService.removeCounselee(counseleeId, counselorId);
        return "성공적으로 삭제되었습니다.";
    }

    //내담자 상담 완료 ?? 삭제랑 똑같이 구현?

    //내담자 수정
    @PutMapping("/{counseleeId}")
    @ResponseStatus(value = HttpStatus.OK)
    public CounseleeResponseDto counseleeModify(@PathVariable Long counseleeId, @RequestBody CounseleeModifyRequestDto requestDto) {
        Counselee counselee = counseleeService.modifyCounselee(counseleeId, requestDto);
        return new CounseleeResponseDto(counselee);
    }




}
