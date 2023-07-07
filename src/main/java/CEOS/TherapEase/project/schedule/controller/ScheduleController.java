package CEOS.TherapEase.project.schedule.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    // 일정 정보를 저장하는 7x15 크기의 이차원 배열
    private boolean[][] schedule = new boolean[7][15];

    // 일정 정보의 최신 업데이트 날짜
    private LocalDate latestUpdated;

    // 상담일정표 조회 API
    @GetMapping("/consultant")
    public ResponseEntity<?> getConsultantSchedule(@RequestHeader("Authorization") String token) {
        // JWT 토큰에서 상담자 정보 가져오기
        String role = extractRoleFromToken(token);

        // 상담자인 경우에만 조회 가능
        if (role.equals("consultant")) {
            // 조회 결과를 담을 Map 객체 생성
            Map<String, Object> response = new HashMap<>();
            Map<String, boolean[]> scheduleMap = new HashMap<>();

            // 일정 정보 맵에 저장
            scheduleMap.put("sunday", schedule[0]);
            scheduleMap.put("monday", schedule[1]);
            scheduleMap.put("tuesday", schedule[2]);
            scheduleMap.put("wednesday", schedule[3]);
            scheduleMap.put("thursday", schedule[4]);
            scheduleMap.put("friday", schedule[5]);
            scheduleMap.put("saturday", schedule[6]);

            // 응답 데이터 생성
            response.put("latestUpdated", latestUpdated);
            response.put("data", scheduleMap);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
        }
    }

    // 일정 정보 업데이트 API
    @PutMapping("/consultant")
    public ResponseEntity<?> updateConsultantSchedule(@RequestBody Map<String, boolean[]> newSchedule,
                                                      @RequestHeader("Authorization") String token) {
        // JWT 토큰에서 상담자 정보 가져오기
        String role = extractRoleFromToken(token);

        // 상담자인 경우에만 업데이트 가능
        if (role.equals("consultant")) {
            // 일정 정보 업데이트
            for (int i = 0; i < 7; i++) {
                if (newSchedule.containsKey(getDayOfWeek(i))) {
                    boolean[] daySchedule = newSchedule.get(getDayOfWeek(i));
                    System.arraycopy(daySchedule, 0, schedule[i], 0, 15);
                }
            }

            // 최신 업데이트 날짜 설정
            latestUpdated = LocalDate.now();

            return ResponseEntity.ok("Schedule updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
        }
    }

    // JWT 토큰에서 상담자 정보 추출하는 메서드
    private String extractRoleFromToken(String token) {
        // 토큰 해석 로직 구현
        // 상담자인지 내담자인지 구분하는 role 정보 추출

        // 임시로 상담자인 경우를 가정하고 "consultant" 반환
        return "consultant";
    }

    // 숫자로 된 요일을 문자열로 변환하는 메서드
    private String getDayOfWeek(int day) {
        return DayOfWeek.of(day + 1).name().toLowerCase();
    }
}