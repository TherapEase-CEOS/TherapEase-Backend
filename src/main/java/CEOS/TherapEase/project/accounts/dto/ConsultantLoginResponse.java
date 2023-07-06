package CEOS.TherapEase.project.accounts.dto;

public class ConsultantLoginResponse {
    private String token;

    public ConsultantLoginResponse() {
    }

    public ConsultantLoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
