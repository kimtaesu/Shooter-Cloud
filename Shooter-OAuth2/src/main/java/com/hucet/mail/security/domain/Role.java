package com.hucet.mail.security.domain;

import com.hucet.mail.security.enums.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


@Entity
@Getter
@Table(name = "ofRole")
@NoArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue
    @Column(name = "ROLE_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType roleType;

    public Role(RoleType roleUser) {
        this.roleType = roleUser;
    }

    @Override
    public String getAuthority() {
        return roleType.name();
    }
}
