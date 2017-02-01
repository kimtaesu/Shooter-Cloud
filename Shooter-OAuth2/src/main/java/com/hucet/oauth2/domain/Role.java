package com.hucet.oauth2.domain;

import com.hucet.oauth2.enums.RoleType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ROLE")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue
    @Column(name = "ROLE_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType roleType;


    @Override
    public String getAuthority() {
        return roleType.name();
    }
}
