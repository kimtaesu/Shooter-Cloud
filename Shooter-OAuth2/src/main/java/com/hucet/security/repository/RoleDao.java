package com.hucet.security.repository;


import com.hucet.security.domain.Role;
import com.hucet.security.enums.RoleType;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface RoleDao extends Repository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);

    Role save(Role role);
}
