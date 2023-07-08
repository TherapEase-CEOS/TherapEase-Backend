package CEOS.TherapEase.project.accounts.service;

import CEOS.TherapEase.project.accounts.domain.Account;
import CEOS.TherapEase.project.accounts.dto.AccountUpdateRequestDto;
import CEOS.TherapEase.project.accounts.dto.SignUpRequestDto;
import CEOS.TherapEase.project.accounts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Long signUp(SignUpRequestDto requestDto) {
        if (existsByEmail(requestDto.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 email입니다." + requestDto.getEmail());
        }
        Account account = accountRepository.save(requestDto.toEntity());
        return account.getAccountId();
    }

    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return accountRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    public Account findAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 id를 가진 Account를 찾을 수 없습니다.id="+id));
    }

    public Long update(Long accountId, AccountUpdateRequestDto requestDto) {
        Account account = findAccountById(accountId);
        account.updateAccount(requestDto.getBio(), requestDto.getNickname());
        return account.getAccountId();
    }

    @Transactional
    public void withdraw(Long accountId) {
        Account account = findAccountById(accountId);
        account.withdrawAccount();
    }

    public void delete(Long accountId) {
        Account account = findAccountById(accountId);
        accountRepository.delete(account);
    }

    @Transactional(readOnly = true)
    public Account findAccountByEmail(String email){
        return accountRepository.findByEmail(email)
                .orElseThrow(()-> new EntityNotFoundException("해당 email을 가진 게정을 찾을 수 잆습니다." +
                        "email = " + email));
    }
}
