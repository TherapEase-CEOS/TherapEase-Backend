package CEOS.TherapEase.project.accounts.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "yourSecretKey"; // JWT 암호화에 사용할 시크릿 키

    public static String generateToken(long memberId, String role) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + 86400000); // 토큰 만료 시간 설정 (예: 24시간)

        String token = Jwts.builder()
                .setSubject(Long.toString(memberId))
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();

        return token;
    }

    // 추가적인 메서드나 로직을 구현할 수 있습니다.
}