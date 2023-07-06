package CEOS.TherapEase.project.accounts.dto;

import org.springframework.stereotype.Service;

@Service
public class ConsultantLoginRequest {
    private String username;
    private String password;

    public ConsultantLoginRequest() {
    }

    public ConsultantLoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // ... 추가 필드 정의

    // Getter와 Setter 메서드
    // ...
}