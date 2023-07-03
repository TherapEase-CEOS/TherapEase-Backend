package CEOS.TherapEase.project.accounts.service;

import org.springframework.stereotype.Service;

@Service
public class ConsultantService {
    public boolean signUp(ConsultantSignUpRequest request) {
        // 상담자 회원가입 처리 로직 구현
        // ...
        // 회원가입 성공 여부에 따라 true 또는 false 반환
        return true;
    }

    public String login(ConsultantLoginRequest request) {
        // 상담자 로그인 처리 로직 구현
        // ...
        // 로그인에 성공한 경우 토큰 반환, 로그인 실패한 경우 null 반환
        return "sampleToken";
    }
}
