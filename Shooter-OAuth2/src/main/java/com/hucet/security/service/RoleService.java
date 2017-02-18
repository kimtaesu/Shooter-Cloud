package com.hucet.security.service;

import com.hucet.security.domain.Role;
import com.hucet.security.enums.RoleType;
import com.hucet.security.repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;

    public Optional<Role> getRoleType(RoleType roleType) {
        return roleDao.findByRoleType(roleType);
    }
}
