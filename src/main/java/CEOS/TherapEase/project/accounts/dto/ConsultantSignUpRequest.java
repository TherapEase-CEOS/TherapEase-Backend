package CEOS.TherapEase.project.accounts.dto;

import org.springframework.stereotype.Service;

@Service
public class ConsultantSignUpRequest {
    private String username;
    private String password;
    private String email;
    private String role;
    // ... 추가 필드 정의할 거 있으면 하기

    //Getter와 Setter 메서드
    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
