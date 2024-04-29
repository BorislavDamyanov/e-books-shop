package com.ebooksstore.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Table(name = "users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class User extends BaseEntity implements UserDetails {



    @Column(nullable = false)
    private String fullName;


    @Column(nullable = false)
    private String username;

    @Column(unique = true, length = 100, nullable = false)
    private String email;



    @Column(nullable = false)
    private String password;


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}