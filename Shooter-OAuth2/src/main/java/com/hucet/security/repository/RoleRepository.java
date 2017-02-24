package com.hucet.security.repository;

import com.hucet.security.domain.Role;
import com.hucet.security.enums.RoleType;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * Created by taesu on 2017-02-24.
 */
public interface RoleRepository extends Repository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);

    Role save(RoleType roleType);
}
