package com.hucet.mail.security.service;

import com.hucet.mail.security.domain.Account;
import com.hucet.mail.security.domain.Role;
import com.hucet.mail.security.dto.AccountDto;
import com.hucet.mail.security.enums.RoleType;
import com.hucet.mail.security.exception.AlreadyRegisteredException;
import com.hucet.mail.security.exception.NotFountRoleItem;
import com.hucet.mail.security.repository.AccountRepository;
import com.hucet.mail.security.repository.RoleRepository;
import com.hucet.mail.security.stream.NotifyMailService;
import com.hucet.mail.security.stream.dto.MailDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Slf4j
@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;


    @Autowired
    ModelMapper modelMapper;

    public Account newAccount(AccountDto dto) {
        if (accountRepository.findByUserEmail(dto.getUserEmail()).isPresent()) {
            throw new AlreadyRegisteredException("이미 등록된 사용자입니다.");
        }
        Account account = modelMapper.map(dto, Account.class);
        account.addRole(getDefaultRole());
        account = accountRepository.save(account);
        return account;
    }

    public Account getUser(String userName) {
        Optional<Account> accountOptional = accountRepository.findByUserName(userName);
        if (accountOptional.isPresent()) {
            return accountOptional.get();
        } else {
            // TODO THROW Catch
            throw new RuntimeException("can't find the account");
        }
    }

    private Role getDefaultRole() {
        Optional<Role> defualtRole = roleRepository.findByRoleType(RoleType.ROLE_USER);
        if (defualtRole.isPresent()) {
            return defualtRole.get();
        }
        throw new NotFountRoleItem("Default Role이 존재하지 않습니다.");
    }
}
