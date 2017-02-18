package com.hucet.user_service.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 계정 관련 설정들
 *
 * @see <a href="http://zgundam.tistory.com/49">http://zgundam.tistory.com/49</a>
 * <p>
 * <p>
 * isAccountNonExpired() 계정이 만료되지 않았는지 리턴
 * isAccountNonLocked() 계정이 잠겨있지 않은지 리턴
 * isCredentialsNonExpired() 계정의 패스워드가 만료되지 않았는지 리턴
 * isEnabled() 계정이 사용가능한 계정인지 리턴
 * getAuthorities() 계정이 갖고 있는 권한 목록 리턴
 */
@Entity
// DDD에서는 Domain에 Setter를 지정하는 것은 의도치 않게
// Domain 의 일관성을 유지하지 못하게 한다.

// (ModelMapper)그러나 사용자의 편의성에 따라 제약을 따르지 않는다고 한다.
@Data
public class Account {
    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String password;

    private boolean isEnabled = true;

    private boolean isAccountNonExpired = true;

    private boolean isAccountNonLocked = true;

    private boolean isCredentialsNonExpired = true;
//    @ManyToMany
//    @Setter(AccessLevel.PRIVATE)
//    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
//    private Set<Role> roles = new HashSet<>();
}
