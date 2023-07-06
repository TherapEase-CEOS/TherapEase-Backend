package CEOS.TherapEase.project.accounts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.password.Password

//Consultant 모델 클래스를 정의한 후, 해당 클래스는 ConsultantRepository에서 사용될 수 있다.
@Entity
public class Consultant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String role;

    public Consultant(){

    }
    public Consultant(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }



    // getters and setters
}
