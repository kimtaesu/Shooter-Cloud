package com.hucet.gateway.security.repository;


import com.hucet.gateway.security.domain.Role;
import com.hucet.gateway.security.enums.RoleType;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface RoleDao extends Repository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);

    Role save(Role role);
}
