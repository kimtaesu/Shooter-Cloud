package com.hucet.gateway.security.domain;

import com.hucet.gateway.security.enums.RoleType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

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
