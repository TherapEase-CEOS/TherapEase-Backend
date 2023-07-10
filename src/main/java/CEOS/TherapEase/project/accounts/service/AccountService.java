package CEOS.TherapEase.project.accounts.service;

import CEOS.TherapEase.project.accounts.dto.AccountUpdateRequestDto;
import CEOS.TherapEase.project.accounts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import CEOS.TherapEase.project.accounts.domain.Account;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public void updateAccountProfile(Long accountId, AccountUpdateRequestDto requestDto) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("해당 아이디의 계정을 찾을 수 없습니다: " + accountId));

        account.updateAccount(requestDto.getBio(), requestDto.getEmail(), requestDto.getPhone());

        accountRepository.save(account);
    }
}
