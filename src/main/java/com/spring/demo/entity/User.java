package com.spring.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !isAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isCredentialExpired();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public boolean isCredentialExpired() {
        return credentialExpired;
    }

    public void setCredentialExpired(boolean credentialExpired) {
        this.credentialExpired = credentialExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public User(String username, String password, boolean accountExpired, boolean accountLocked, boolean credentialExpired, boolean enabled) {
        this.username = username;
        this.password = password;

        this.accountExpired = accountExpired;
        this.accountLocked = accountLocked;
        this.credentialExpired = credentialExpired;
        this.enabled = enabled;

    }

    @Column(name="account_expired")
    private boolean accountExpired;

    @Column(name = "account_locked")
    private boolean accountLocked;

    @Column(name = "credentials_expired")
    private boolean credentialExpired;

    @Column(name = "enabled")
    private boolean enabled;

    public Collection<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<Authority> authorities) {
        this.authorities = authorities;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_authorities", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    @OrderBy
    @JsonIgnore
    private Collection<Authority> authorities;

   /* @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Collection<ResetPassword> passwordReset;*/
}
