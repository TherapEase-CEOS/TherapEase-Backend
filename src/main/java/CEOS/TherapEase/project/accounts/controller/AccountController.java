package CEOS.TherapEase.project.accounts.controller;

import CEOS.TherapEase.project.accounts.domain.Account;
import CEOS.TherapEase.project.accounts.repository.AccountRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import CEOS.TherapEase.project.accounts.dto.AccountResponseDto;
import CEOS.TherapEase.project.accounts.dto.AccountUpdateRequestDto;
import CEOS.TherapEase.project.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    // 토큰에 사용할 비밀키
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final AccountService accountService;

    // 사용자 코드를 저장할 Map (실제로는 DB에서 조회하는 것이 좋다.)
    private static final Map<String, String> userCodes = new HashMap<>();

    @Autowired
    private AccountRepository accountRepository;

    // 사용자 로그인 API
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String code = request.get("code");

        // 사용자 코드 확인
        Account account = accountRepository.findByCode(code);
        if (account != null) {
            String role = account.getRole();
            String id = account.getAccountId().toString();
            String name = account.getName();

            // JWT 토큰 생성
            String token = generateToken(role, id, name);

            // 응답에 토큰 반환
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("유효하지 않은 코드");
        }
    }

    // JWT 토큰 생성 메서드
    private String generateToken(String role, String id, String name) {
        return Jwts.builder()
                .claim("role", role)
                .claim("id", id)
                .claim("name", name)
                .signWith(SECRET_KEY)
                .compact();
    }

    // 미리 저장된 사용자 코드 초기화 메서드 (DB에서 조회하여 초기화)
    private void initializeUserCodes() {
        List<Account> accounts = accountRepository.findAll();
        for (Account account : accounts) {
            userCodes.put(account.getCode(), account.getCode());
        }


        /* 계정 생성 기능 */
        //  @PostMapping
        // @ResponseStatus(value = HttpStatus.CREATED)
        // public AccountResponseDto signUp(@RequestBody @Valid final SignUpRequestDto requestDto) {
        //    Long id = accountService.signUp(requestDto);
        //    Account findAccount = accountService.findAccountById(id);
        //    return AccountResponseDto.from(findAccount);
        // }

        /* 계정 조회 기능 (1명) */
        // @GetMapping("/{accountId}")
        //  @ResponseStatus(value = HttpStatus.OK)
        // public AccountResponseDto getAccount(@PathVariable Long accountId) {
        //     Account findAccount = accountService.findAccountById(accountId);
        //     return AccountResponseDto.from(findAccount);
        // }

        /* 계정 프로필 수정 */
/*
    @PatchMapping("/profile/{accountId}")
    @ResponseStatus(value = HttpStatus.OK)
    public AccountResponseDto update(@PathVariable final Long accountId, @RequestBody @Valid final AccountUpdateRequestDto requestDto) {
        Long id = accountService.update(accountId, requestDto);
        Account findAccount = accountService.findAccountById(id);
        return AccountResponseDto.from(findAccount);
    }
    */


        /* 계정 삭제 (휴면 계정으로) */
        //  @PatchMapping("/{accountId}")
        //  @ResponseStatus(value = HttpStatus.OK)
        // public String withdraw(@PathVariable long accountId) {
        //     accountService.withdraw(accountId);
        //     return "성공적으로 탈퇴되었습니다.";
        // }

        /* 계정 삭제 (db에서도 삭제) */
        // @DeleteMapping("/{accountId}")
        // @ResponseStatus(value = HttpStatus.OK)
        // public String delete(@PathVariable long accountId) {
        //    accountService.delete(accountId);
        //    return "성공적으로 탈퇴가 완료되었습니다";
        // }
    }
}