package CEOS.TherapEase.project.accounts.controller;

import CEOS.TherapEase.project.accounts.dto.ConsultantLoginRequest;
import CEOS.TherapEase.project.accounts.dto.ConsultantLoginResponse;
import CEOS.TherapEase.project.accounts.dto.ConsultantSignUpRequest;
import CEOS.TherapEase.project.accounts.model.Consultant;
import CEOS.TherapEase.project.accounts.service.ConsultantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class ConsultantController {

    private final ConsultantService consultantService;


    public ConsultantController(ConsultantService consultantService) {
        this.consultantService = consultantService;
    }

    @PostMapping("/consultants/signup")
    public ResponseEntity<String> signUp(@RequestBody ConsultantSignUpRequest request) {
        // 상담사 회원가입 처리 로직
        boolean isSignUpSuccessful = consultantService.signUp(request);
        if (isSignUpSuccessful) {
            return ResponseEntity.ok("Sign up successful");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to sign up");
        }
    }

    @PostMapping("/consultants/login")
    public ResponseEntity<ConsultantLoginResponse> login(@RequestBody ConsultantLoginRequest request) {
        // 상담사 로그인 처리 로직
        String token = consultantService.login(request);
        if (token != null) {
            ConsultantLoginResponse response = new ConsultantLoginResponse(token);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}