package com.hucet.mail.security.service;

import com.hucet.mail.security.domain.Account;
import com.hucet.mail.security.domain.Role;
import com.hucet.mail.security.dto.AccountDto;
import com.hucet.mail.security.enums.RoleType;
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
    NotifyMailService notifyMailService;

    @Autowired
    ModelMapper modelMapper;

    public Long newAccount(AccountDto dto) {
        // TODO Exist User
        Account account = modelMapper.map(dto, Account.class);
        account.addRole(getDefaultRole());
        account = accountRepository.save(account);

        // notify the mail queue,
        notifyMailService.notifyCertMail(new MailDto(account.getUsername(), account.getUserEmail()));
        return account.getId();
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
        return roleRepository.save(RoleType.ROLE_USER);
    }
}
