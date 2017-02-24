package com.hucet.mail.security.repository;

import com.hucet.mail.security.domain.Role;
import com.hucet.mail.security.enums.RoleType;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * Created by taesu on 2017-02-24.
 */
public interface RoleRepository extends Repository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);

    Role save(RoleType roleType);
}
