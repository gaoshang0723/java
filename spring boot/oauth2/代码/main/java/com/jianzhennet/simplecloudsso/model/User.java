package com.jianzhennet.simplecloudsso.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private String last_password_change;        //最后修改密码的时间
    private int enable;                           //账号状态

    public User() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }


    public String getLast_password_change() {
        return last_password_change;
    }

    public int getEnable() {
        return enable;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLast_password_change(String last_password_change) {
        this.last_password_change = last_password_change;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
