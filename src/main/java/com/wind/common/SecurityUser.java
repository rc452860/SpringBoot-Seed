package com.wind.common;

import com.wind.mybatis.pojo.User;
import lombok.*;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


@Getter
@ToString
public class SecurityUser extends User implements UserDetails{

    private final String username;
    private final boolean enabled;
    private final boolean accountNonExpired;
    private final boolean credentialsNonExpired;
    private final boolean accountNonLocked;
    private final Set<GrantedAuthority> authorities;

    public SecurityUser(User user, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        if (user != null) {
            username = user.getName();
            setPassword(user.getPassword());
            setEmail(user.getEmail());
            setExpiredate(user.getExpiredate());
            setId(user.getId());
            setLastlogindate(user.getLastlogindate());
            setLastloginip(user.getLastloginip());
            setPhone(user.getPhone());
            setRegisterdate(user.getRegisterdate());
            setRole(user.getRole());
            setPassword(user.getPassword());
            this.enabled = enabled;
            this.accountNonExpired = accountNonExpired;
            this.credentialsNonExpired = credentialsNonExpired;
            this.accountNonLocked = accountNonLocked;
            this.authorities = Collections.unmodifiableSet(new HashSet<>(CollectionUtils.emptyIfNull(authorities)));
            //this.authorities.add(new SimpleGrantedAuthority(user.getRole()));

        } else {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }
    }

}
