package com.wind.security;

import com.wind.mybatis.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import static java.time.Instant.now;


public class SecurityUser extends User implements UserDetails{

    public SecurityUser(User user){
        setName(user.getName());
        setPassword(user.getPassword());
        setEmail(user.getEmail());
        setExpiredate(user.getExpiredate());
        setId(user.getId());
        setLastlogindate(user.getLastlogindate());
        setLastloginip(user.getLastloginip());
        setPhone(user.getPhone());
        setRegisterdate(user.getRegisterdate());
        setRole(user.getRole());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return getPassword();
    }

    @Override
    public String getUsername() {
        return getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return getExpiredate().toInstant().isAfter(now());
    }

    @Override
    public boolean isAccountNonLocked() {
        return getExpiredate().toInstant().isAfter(now());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return getExpiredate().toInstant().isAfter(now());
    }

    @Override
    public boolean isEnabled() {
        return getExpiredate().toInstant().isAfter(now());
    }
}
