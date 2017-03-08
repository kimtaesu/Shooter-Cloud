package com.hucet.security.service;

import com.hucet.security.domain.Account;
import com.hucet.security.domain.Role;
import com.hucet.security.dto.UserDto;
import com.hucet.security.enums.RoleType;
import com.hucet.security.exception.AlreadyRegisteredException;
import com.hucet.security.exception.NotFountRoleItem;
import com.hucet.security.repository.AccountRepository;
import com.hucet.security.repository.RoleRepository;
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

    public Account newAccount(UserDto.JoinDto dto) {
        if (accountRepository.findByUserEmail(dto.getUserEmail()).isPresent()) {
            throw new AlreadyRegisteredException("이미 등록된 사용자입니다.");
        }
        Account account = modelMapper.map(dto, Account.class);
        account.addRole(getDefaultRole());
        account = accountRepository.save(account);
        return account;
    }

    public Account getUser(String userEmail) {
        Optional<Account> accountOptional = accountRepository.findByUserEmail(userEmail);
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
