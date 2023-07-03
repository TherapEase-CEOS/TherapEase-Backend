package CEOS.TherapEase.project.controller;

import CEOS.TherapEase.project.service.ConsultantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultant")
public class ConsultantController {

    private final ConsultantService consultantService;

    public ConsultantController(ConsultantService consultantService) {
        this.consultantService = consultantService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody ConsultantSignUpRequest request) {
        // 상담자 회원가입 처리 로직
        boolean isSignUpSuccessful = consultantService.signUp(request);
        if (isSignUpSuccessful) {
            return ResponseEntity.ok("Sign up successful");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to sign up");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody ConsultantLoginRequest request) {
        // 상담자 로그인 처리 로직
        String token = consultantService.login(request);
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}

