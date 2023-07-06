package CEOS.TherapEase.project.accounts.service;

import CEOS.TherapEase.project.accounts.dto.ConsultantLoginRequest;
import CEOS.TherapEase.project.accounts.dto.ConsultantSignUpRequest;
import CEOS.TherapEase.project.accounts.model.Consultant;
import CEOS.TherapEase.project.accounts.repository.ConsultantRepository;
import CEOS.TherapEase.project.accounts.utils.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ConsultantService {

    private final ConsultantRepository consultantRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public ConsultantService(ConsultantRepository consultantRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.consultantRepository = consultantRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean signUp(ConsultantSignUpRequest request) {
        // 입력된 회원 정보를 검증하고 저장
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        Consultant consultant = new Consultant(request.getUsername(), encodedPassword, request.getRole());
        consultantRepository.save(consultant);
        return true;
    }

    public String login(ConsultantLoginRequest request) {
        // 입력된 로그인 정보를 검증하고 토큰을 생성하여 반환
        Consultant consultant = consultantRepository.findByUsername(request.getUsername());
        if (consultant != null && passwordEncoder.matches(request.getPassword(), consultant.getPassword())) {
            return jwtUtil.generateToken(consultant.getId(), consultant.getRole());
        }
        return null;
    }
}
