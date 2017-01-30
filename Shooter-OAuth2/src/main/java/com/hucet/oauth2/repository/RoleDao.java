package com.hucet.oauth2.repository;


import com.hucet.oauth2.domain.Role;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface RoleDao extends Repository<Role, Long> {
    Optional<Role> findByRoleType(String roleType);

    Role save(Role role);
}
