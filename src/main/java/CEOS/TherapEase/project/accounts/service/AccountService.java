package CEOS.TherapEase.project.accounts.service;

import CEOS.TherapEase.project.accounts.domain.Account;
//import CEOS.TherapEase.project.accounts.dto.AccountUpdateRequestDto;
import CEOS.TherapEase.project.accounts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    /*
    // 업데이트된 계정 정보 반환
    public Long update(Long accountId, AccountUpdateRequestDto requestDto) {
        Account account = findAccountByCode(accountId);
        account.updateAccount(requestDto.getBio(), requestDto.getNickname());
        return account.getAccountId();
    }
    */

    // 이메일로 로그인하는 기능 -> 코드로 하는 기능
    // @Transactional(readOnly = true)
    // public Account findAccountByCode(String code){
    //     return accountRepository.findByCode(code)
    //             .orElseThrow(()-> new EntityNotFoundException("해당 code을 가진 게정을 찾을 수 잆습니다." +
    //                     "code = " + code));
    // }
}