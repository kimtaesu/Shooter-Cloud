package com.hucet.oauth2.repository;


import com.hucet.oauth2.domain.Role;
import com.hucet.oauth2.enums.RoleType;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface RoleDao extends Repository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);

    Role save(Role role);
}
